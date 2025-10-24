package B07Lab5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class SquareTests {
	Square s0 = new Square(new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1));
	Square s1 = new Square(new Point(10, 3.5), new Point(9.5, 3), new Point(10.5, 3), new Point(10, 2.5));

	@Test
	void Test_Unit_Square_Perimeter() {
		assertEquals(s0.perimeter(), 4, 1e-9);
	}
	
	@Test
	void Test_Unit_Square_Area() {
		assertEquals(s0.area(), 1, 1e-9);
	}
	
	@Test
	void Test_Invalid_Square_Exception() {
		try{
			Square s1 = new Square(new Point(1, 0), new Point(1, 1), new Point(0, 1), new Point(2, 2));
			assertFalse(true);
		}
		catch(IllegalArgumentException ex) {
			assertEquals(ex.getMessage(), "The given points do not form a valid square.");
		}
	}
	
	@Test
	void Test_Float_Square_Perimeter() {
		assertEquals(s1.perimeter(), 2 * Math.sqrt(2), 1e-9);
	}
	
	@Test
	void Test_Float_Square_Area() {
		assertEquals(s1.area(), 0.5, 1e-9);
	}
	
	@Test
	void Test_Valid_Half_S0() {
		Triangle Hs0 = new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0));
		assertTrue(s0.halftriangle(Hs0));
	}
	
	@Test
	void Test_Valid_Half_S0_from_Remote_Distance() {
		Triangle Hs0_Remote = new Triangle(new Point(100, 100), new Point(100, 101), new Point(101, 100));
		assertTrue(s0.halftriangle(Hs0_Remote));
	}
	
	@Test
	void Test_Valid_Half_S1_from_Its_Unit_Half() {
		Triangle Hs1_Unit = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0.5, 0.5));
		assertTrue(s1.halftriangle(Hs1_Unit));
	}
	
	@Test
	void Test_Invalid_Half_S1() {
		Triangle HS1_Invalid = new Triangle(new Point(10, 2.5), new Point(10, 3.5), new Point(10, 3));
		assertFalse(s1.halftriangle(HS1_Invalid));
	}

}
