package triangle;

import java.awt.Polygon;

public class Sierpinski {

	public Polygon[] polyList;
	public int count = 0;
	
	public Sierpinski( int splits )
	{
		int triangle_number = 1;

		for(int k = 0; k < splits; k++)
		{
			triangle_number = triangle_number * 3;
		}
		this.polyList = new Polygon[triangle_number];
	}
	
	public void computeTriangles(int splits, int ax, int ay, int bx, int by, int cx, int cy)
	{
		int[]xs={ax,bx,cx};
		int[]ys={ay,by,cy};
		Polygon p = new Polygon(xs,ys,xs.length);
		if(splits == 0)
		{
			polyList[count] = p;
			count ++;
		}
		else
		{
			int[] M1 = getMidpoint(ax, ay, bx, by);
			int[] M2 = getMidpoint(ax, ay, cx, cy);
			int[] M3 = getMidpoint(cx, cy, bx, by);

			computeTriangles(splits - 1, M1[0], M1[1], ax, ay, M2[0], M2[1]);
			computeTriangles(splits - 1, M2[0], M2[1], cx, cy, M3[0], M3[1]);
			computeTriangles(splits - 1, M1[0], M1[1], M3[0], M3[1], bx, by);
		}



	}
	
	// returns the midpoint as an array [x,y] of any line given the coordinates
	public static int[] getMidpoint(int ax, int ay, int bx, int by)
	{
		int[] ret = {(ax + bx)/2, (ay + by)/2};

		return ret;
	}

	
}



/*
//create basic triangle
		int[]xs={ax,bx,cx};
		int[]ys={ay,by,cy};
		Polygon p = new Polygon(xs,ys,xs.length);
		 
		//polyList[count] = p;
		//count++;

		int[] M1 = getMidpoint(ax, ay, bx, by);
		int[] M2 = getMidpoint(ax, ay, cx, cy);
		int[] M3 = getMidpoint(cx, cy, bx, by);

		xs[0] = M1[0]; xs[1] = ax; xs[2] = M2[0];
		ys[0] = M1[1]; ys[1] = ay; ys[2] = M2[1];
		Polygon p1 = new Polygon(xs,ys,xs.length);


		xs[0] = M2[0]; xs[1] = cx; xs[2] = M3[0];
		ys[0] = M2[1]; ys[1] = cy; ys[2] = M3[1];
		Polygon p2 = new Polygon(xs,ys,xs.length);

		xs[0] = M1[0]; xs[1] = M3[0]; xs[2] = bx;
		ys[0] = M1[1]; ys[1] = M3[1]; ys[2] = by;
		Polygon p3 = new Polygon(xs,ys,xs.length);

		polyList[0] = p1;
		polyList[1] = p2;
		polyList[2] = p3;

*/




