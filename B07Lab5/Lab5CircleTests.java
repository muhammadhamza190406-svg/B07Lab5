package B07Lab5;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Lab5CircleTests {

	@Test
	void testPerimeter() {
		Point p = new Point(0,0);
		Circle c = new Circle(p,1);
		assertEquals(c.perimeter(),2*Math.PI);
	}
	
	@Test
	void testArea() {
		Point p = new Point(1,1);
		Circle c = new Circle(p,2);
		assertEquals(c.area(),4*Math.PI);
	}

}
