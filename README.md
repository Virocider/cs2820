# cs2820
Demo Warehouse Project

## Application Architecture

There are seven parts to the warehouse simulation:

* Master

> this is the main class, which drives the simulation
> by (1) creating initialial instances of all other 
> parts, (2) then looping to generate tick events for
> each simulated time unit, (3) providing a "scheduled event"
> service that other parts can use to have an event occur
> at a specified simulated time

* Floor

> this class is in charge of representing the static layout
> of the simulated warehouse. The warehouse is a grid of squares
> with some squares having special purposes. These are squares
> for picker(s), packer(s), belt areas, shipping dock, receiving
> dock, shelf areas, and chargers. In addition to all this static
> knowledge, the Floor provides a service to keep track of the
> location of each Shelf object, each Robot object, and path
> calculation (what path to take going from one place to other).
> When Floor initializes, it makes Shelf objects and puts them
> in the shelf areas. The size of each shelf is one square in
> warehouse floor; a robot is also one square. Locations of 
> picker(s), packer(s), and docks are also one square. The only
> things that are not single squares are shelf areas and the 
> belt area. The floor provides some nice methods so that 
> Belt can know what is the size of the Belt (how many squares,
> where is picker, where is packer) and so that Visualizer 
> can know the width/length of shelf areas, the length of the
> belt area, location of docks; Visualizer will also be able 
> to ask Floor about locations of robots and shelves. 

* Inventory

> the items of the simulated warehouse come from a catalog of
> names and item numbers. When Inventory initializes, it makes
> some number of each item and distributes these on the Shelf 
> objects (it can ask Floor for a list of all Shelf objects). 
> It's the job of Inventory to watch, as the simulation ticks,
> how many items are on shelves. If stock gets low, Inventory
> should cause a later arrival of new items to the receiving 
> dock, then ask for a robot to bring a shelf to the receiving
> dock, put items on the shelf, and send the robot back to 
> put the shelf in the shelf area of the warehouse. Inventory
> should have a method which finds some shelf containing a 
> needed item. 

* Orders 

> perhaps randomly, orders will be generated by the Orders 
> part of the simulation. Each order will have an address and
> a few desired items. We can think of orders being in a queue
> at the picker station. A picker is working on one order at 
> a time. The Orders part is doing the work of the picker. 
> Orders has to ask Inventory which shelf has a desired item,  
> then ask Floor where is that shelf, then as Robot to bring
> that shelf to the picker location, tell Inventory to remove
> the item from the shelf, then tell a robot to take the shelf
> back to the shelving area. After all items of an order are 
> collected at the picker station, Orders can tell Belt that
> a bin is complete. Orders has to wait for many ticks while
> a robot is bringing a shelf; Orders might also have to wait
> because there is a full bin but the Belt has not moved it 
> yet. 

* Belt

> the two jobs of Belt are moving bins from picker to packer, 
> and moving boxes from packer to shipping dock. At each tick,
> the belt moves everything it has one square. When a bin 
> gets to the packer, then Belt simulates the packer by pausing
> the belt for a few ticks (simulating boxing up items). Belt
> should inform Orders on the progress of an order, and should
> tell Visualizer what to display at each tick.

* Robot

> has the most intuitive task, charging, moving, carrying 
> shelf. Robot needs to keep track of location, tell Floor at
> each tick where it is, call Floor to find a path, and then
> at each tick move one square along a path. Robot needs to 
> simulation "carrying" a shelf (sometimes a shelf is not on
> the floor, it is above the floor being carried). When a robot
> puts a shelf down in a shelving area, the robot has to tell 
> Floor about this. The Robot part gets really tricky when 
> there are two or more robots. Ideally, a robot does not 
> carry a shelf where it would bump into another shelf, but 
> that might be hard to plan for depending on the Floor layout.

* Visualizer

> can initially be primitive, only describing changes in the 
> locations of things at each tick by a print statement. But 
> what is better is to use Java Swing to show a picture of the
> warehouse at each time tick. 
