package tests;

import java.awt.geom.Point2D;

import model.UnknownConnectionError;

public class linesolver {

	/*
	 * we assume that there are two points p1,p2 belonging to line1 two points
	 * p3,p4 belonging to line2 and we need to calculate whether there is an
	 * intersection of these two lines
	 */

	public static void main(String[] args) throws UnknownConnectionError {
		Point2D.Double p1 = new Point2D.Double(0, 0);
		Point2D.Double p2 = new Point2D.Double(10, 0);
		Point2D.Double p3 = new Point2D.Double(11, 0);
		Point2D.Double p4 = new Point2D.Double(12, 0);
		System.out.println(checkIntersection(p1, p2, p3, p4));
	}

	public static Point2D checkIntersection(Point2D.Double p1,
			Point2D.Double p2, Point2D.Double p3, Point2D.Double p4) throws UnknownConnectionError {
		Double d = (p1.x - p2.x) * (p3.y - p4.y) - (p1.y - p2.y)
				* (p3.x - p4.x);
		if (d == 0)
			throw new UnknownConnectionError();
		Double xi = ((p3.x - p4.x) * (p1.x * p2.y - p1.y * p2.x) - (p1.x - p2.x)
				* (p3.x * p4.y - p3.y * p4.x))
				/ d;
		Double yi = ((p3.y - p4.y) * (p1.x * p2.y - p1.y * p2.x) - (p1.y - p2.y)
				* (p3.x * p4.y - p3.y * p4.x))
				/ d;

		Point2D.Double intersection = new Point2D.Double(xi, yi);

		return intersection;
	}

}
