package de.excel.test;

import static org.junit.Assert.*;

import org.junit.Test;

import de.excel.Householder;

public class HouseholderTest {
	
	Householder actual, expected;
	Double[][] a = new Double[3][3];
	Double[][] r = new Double[3][3];
	

	@Test
	public void computeTest() {
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
		
		expected = new Householder(r,true);
		
		
		
		assertTrue(actual.equals(expected));
		
		
		
		
		
	}

}
