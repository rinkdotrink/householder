package src.de.excel.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.de.excel.Householder;



public class HouseholderTest {

	Householder actual, expected;
	Double[][] a = new Double[3][3];
	Double[][] r = new Double[3][3];

	@Test
	public void computeTest1() {
		a[0][0] = 1.0;
		a[0][1] = 2.0;
		a[0][2] = 2.0;
		a[1][0] = 2.0;
		a[1][1] = -2.0;
		a[1][2] = -3.0;
		a[2][0] = 2.0;
		a[2][1] = 1.0;
		a[2][2] = 2.0;
		
		r[0][0] = -3.0;
		r[0][1] = 0.0;
		r[0][2] = 0.0;
		r[1][0] = 0.0;
		r[1][1] = 3.0;
		r[1][2] = 4.0;
		r[2][0] = 0.0;
		r[2][1] = 0.0;
		r[2][2] = 1.0;

		actual = new Householder(a);
		actual.compute();
		expected = new Householder(r);
		
	//	assertTrue(actual.equals(expected));
		assertEquals(expected, actual);
	}
	
	@Test
	public void computeTest2() {
		a[0][0] = 1.0;
		a[0][1] = 2.0;
		a[0][2] = 2.0;
		a[1][0] = 1.0;
		a[1][1] = -2.0;
		a[1][2] = -3.0;
		a[2][0] = 2.0;
		a[2][1] = 1.0;
		a[2][2] = 2.0;

		r[0][0] = -2.449;
		r[0][1] = -0.816;
		r[0][2] = -1.225;
		r[1][0] = 0.0;
		r[1][1] = 2.887;
		r[1][2] = 3.811;
		r[2][0] = 0.0;
		r[2][1] = 0.0;
		r[2][2] = 0.990;

		actual = new Householder(a);
		actual.compute();
		expected = new Householder(r);
		assertEquals(expected, actual);
	}

	@Test
	public void computeTest3() {
		Double[][] a = new Double[4][4];
		Double[][] r = new Double[4][4];

		
		a[0][0] = 1.0;
		a[0][1] = 2.0;
		a[0][2] = 2.0;
		a[0][3] = 1.0;
		a[1][0] = 2.0;
		a[1][1] = -2.0;
		a[1][2] = -3.0;
		a[1][3] = -1.0;
		a[2][0] = 2.0;
		a[2][1] = 1.0;
		a[2][2] = 2.0;
		a[2][3] = 2.0;
		a[3][0] = -4.0;
		a[3][1] = 2.0;
		a[3][2] = -4.0;
		a[3][3] = 1.0;
		
		r[0][0] = -5.0;
		r[0][1] = 1.6;
		r[0][2] = -3.2;
		r[0][3] = 0.2;
		r[1][0] = 0.0;
		r[1][1] = 3.2311;
		r[1][2] = 2.8226;
		r[1][3] = 2.3769;
		r[2][0] = 0.0;
		r[2][1] = 0.0;
		r[2][2] = 3.8462;
		r[2][3] = -0.278;
		r[3][0] = 0.0;
		r[3][1] = 0.0;
		r[3][2] = 0.0;
		r[3][3] = -1.11;
		
		actual = new Householder(a);
		actual.compute();
		expected = new Householder(r);
		assertEquals(expected, actual);

	}
	
	
	@Test
	public void computeTest4() {
		Double[][] a = new Double[3][2];
		Double[][] r = new Double[2][2];

		
		a[0][0] = 1.0;
		a[0][1] = 0.0;
		a[1][0] = 1.0;
		a[1][1] = 1.0;
		a[2][0] = 1.0;
		a[2][1] = 2.0;
		
		
		r[0][0] = -1.7321;
		r[0][1] = -1.7321;
		r[1][0] = 0.0;
		r[1][1] = -1.4142;
		
		
		actual = new Householder(a);
		actual.compute();
		expected = new Householder(r);
		assertEquals(expected, actual);

	}

}
