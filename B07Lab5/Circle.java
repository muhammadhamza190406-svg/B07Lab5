package B07Lab5;

public class Circle{
	Point center;
	int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public double perimeter() {
        return 2 * Math.PI * this.radius;
    }


    public double area() {
        return Math.PI * (this.radius * this.radius);
    }
	
}