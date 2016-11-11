package warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ted Herman
 *
 */
public class ShelfArea {
  int width; // height will always be 2 -- just two shelves
  Point corner;  // lower left corner of shelf area
  List<Point> contents;
  SimRandom randomsource; // for deterministic randomness
  /**
   * @param corner - lower left corner of shelf area
   * @param width - how many squares wide shelf area is
   */
  ShelfArea(Point corner, int width, SimRandom rand) {
	contents = new ArrayList<Point>();
	randomsource = rand; 
	this.corner = new Point(corner.x,corner.y);
	this.width = width;
	for (int i=corner.y; i<corner.y+2; i++)
	 for (int j=corner.x; j<corner.x+width; j++) {
	   contents.add(new Point(j,i));
       }
	populate();  // fill with shelves
    }
  /**
   * @return Point in lower left corner of
   * this ShelfArea.
   */
  Point getCorner() { return corner; }
  /**
   * @return width of this ShelfArea
   */
  int getWidth() { return width; }
  /**
   * @return height of this ShelfArea
   */
  int getHeight() { return 2; }
  /**
   * fill this shelfarea with Shelf objects at each Point;
   * this will be called by the constructor
   */
  void populate() {
	for (Point e: contents) {
	  e.setContents(new Shelf(e));
	  }
    }
  /**
   * @return true if point P is within this ShelfArea
   * @param P point to test
   */
  boolean within(Point P) {
	if (P.x < corner.x) return false;
	if (P.x >= corner.x + width) return false;
	if (P.y >= corner.y+2) return false;
	if (P.y < corner.y) return false;
	return true;
    }
  /**
   * @return true if point P has non-null content (robot or shelf)
   */
  boolean occupied(Point P) {
	if (within(P) && P.contents != null) return true;
	return false;
    }
  /**
   * @param Object to place in a Point
   * @note if Object is null, then makes Point P empty
   */
  void setContent(Point P, Object O) {
	if (!occupied(P) && within(P)) {
	  P.contents = O;	
	  }
    }
  /**
   * @return random Point within this shelfarea
   */
  Point randomPoint() {
	int column = randomsource.nextInt(width);
	int row = randomsource.nextInt(2);
	Point P = new Point(corner.x+column,corner.y-row);
	return P;
    }
 }