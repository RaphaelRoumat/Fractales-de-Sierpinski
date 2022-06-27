package carre;

import java.awt.Polygon;
import java.lang.Math;



public class Sierpinski {

	public Polygon[] polyList;
	public int count = 0;
	
	public Sierpinski( int splits )
	{
		int squares_number = 1;
		
		for(int k = 0; k < splits; k++)
		{
			squares_number = squares_number * 8 + 1;
		}
		

		this.polyList = new Polygon[squares_number];
	}
	
	public void computeSquares(int splits, int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy)
	{		
		int[] point1 = getPoint1st(ax, ay, bx, by);
		int[] point2 = getPoint2nd(ax, ay, bx, by);
		int[] point3 = getPoint1st(ax, ay, dx, dy);
		int[] point7 = getPoint2nd(ax, ay, dx, dy);
		int[] point6 = getPoint1st(bx, by, cx, cy);
		int[] point10 = getPoint2nd(bx, by, cx, cy);
		int[] point11 = getPoint1st(dx, dy, cx, cy);
		int[] point12 = getPoint2nd(dx, dy, cx, cy);
		int[] point4 = getPoint1st(point3[0], point3[1], point6[0], point6[1]);
		int[] point5 = getPoint2nd(point3[0], point3[1], point6[0], point6[1]);
		int[] point8 = getPoint1st(point7[0], point7[1], point10[0], point10[1]);
		int[] point9 = getPoint2nd(point7[0], point7[1], point10[0], point10[1]);

		int[]xs={point4[0],point5[0],point9[0], point8[0]};
		int[]ys={point4[1],point5[1],point9[1], point8[1]};
		Polygon p = new Polygon(xs,ys,xs.length);
		polyList[count] = p;
		count ++;
		
		if( splits != 0)
		{
			computeSquares(splits - 1, ax, ay, point1[0], point1[1],point4[0], point4[1], point3[0], point3[1]);
			computeSquares(splits - 1, point1[0], point1[1], point2[0], point2[1],point5[0], point5[1], point4[0], point4[1]);
			computeSquares(splits - 1, point2[0], point2[1], bx, by, point6[0], point6[1], point5[0], point5[1]);
			computeSquares(splits - 1, point3[0], point3[1], point4[0], point4[1], point8[0], point8[1], point7[0], point7[1]);
			computeSquares(splits - 1, point5[0], point5[1], point6[0], point6[1], point10[0], point10[1], point9[0], point9[1]);
			computeSquares(splits - 1, point7[0], point7[1], point8[0], point8[1], point11[0], point11[1], dx, dy);
			computeSquares(splits - 1, point8[0], point8[1], point9[0], point9[1], point12[0], point12[1], point11[0], point11[1]);
			computeSquares(splits - 1, point9[0], point9[1], point10[0], point10[1], cx, cy, point12[0], point12[1]);
		}
	}
	
	// returns the midpoint as an array [x1, y1, x2, y2] of any line given the coordinates
	public static int[] getPoint1st(int ax, int ay, int bx, int by)
	{
		int x = (int)(ax * (2./3) + bx * 1./3);
		int y = (int)(ay * (2./3) + by * 1./3);
		int ret[] = new int[2];
		ret[0] = x;
		ret[1] = y;
		return ret;
	}

	public static int[] getPoint2nd(int ax, int ay, int bx, int by)
	{
		int x =(int)(ax * (1./3) + bx * 2./3);
		int y =(int)(ay * (1./3) + by * 2./3);
		int ret[] = new int[2];
		ret[0] = x;
		ret[1] = y;
		return ret;
	}
}