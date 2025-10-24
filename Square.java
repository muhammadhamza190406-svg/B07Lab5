package B07Lab5;
import java.util.Arrays;

public class Square {
	Point A;
	Point B;
	Point C;
	Point D;
	double[] dists; //holds all distances between points, going from shortest to longest
	
	public Square(Point p1, Point p2, Point p3, Point p4){
		if(!(isValidSquare(p1,p2,p3,p4))) {
			throw new IllegalArgumentException("The given points do not form a valid square.");
		}
		A = p1;
		B = p2;
		C = p3;
		D = p4;
		dists = new double[] {
		        p1.distance(p2), p1.distance(p3), p1.distance(p4),
		        p2.distance(p3), p2.distance(p4), p3.distance(p4)
		    };
		Arrays.sort(dists); //sorts dists in from shortest to longest 
	}
	
	private boolean isValidSquare(Point p1,Point p2, Point p3,Point p4) {
		double[] dists = {
		        p1.distance(p2), p1.distance(p3), p1.distance(p4),
		        p2.distance(p3), p2.distance(p4), p3.distance(p4)
		    };

		 Arrays.sort(dists);
		 return dists[0] > 0 && 
				 dists[0] == dists[1] &&  //4 sides with equal length
				 dists[1] == dists[2] &&  //4 sides with equal length
				 dists[2] == dists[3] &&  //4 sides with equal length
				 dists[4] == dists[5] &&  //2 diagonals with equal length
				 (Math.abs(dists[5] - (dists[0] * Math.sqrt(2))) < 1e-9); 	//diagonal length == side length * root2
		 																	//however we are accounting for precision of doubles, hence 1e-9
	}
	
	public double area() {
		return dists[0] * dists[0];
	}
	
	public double perimeter() {
		return dists[0]*4;
	}
	
	public boolean halftriangle(Triangle tri) { //returns whether tri forms half of square
		double[] tri_dists = {
		        tri.A.distance(tri.B), tri.A.distance(tri.C), tri.B.distance(tri.C)};
		Arrays.sort(tri_dists);
		
		return (Math.abs(tri_dists[0] - tri_dists[1]) < 1e-9) && //two shortest sides of triangle are equal
		(Math.abs(tri_dists[0] - dists[0]) < 1e-9) && //shortest side of triangle is equal to side length of square
		(Math.abs(tri_dists[2] - dists[5]) < 1e-9); //longest side of triangle is equal to diagonal of square
		
	}

}
