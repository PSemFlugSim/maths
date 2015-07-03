package de.gymolching.fsb.maths.test;

import junit.framework.Assert;

import org.junit.Test;

import de.gymolching.fsb.maths.Matrix3;

public class MathsTest {
	public MathsTest() {

	}

	@Test
	public void testMultiplyMatrixMatrix() {
		// Allocate Matrices
		Matrix3 mat1 = new Matrix3();
		Matrix3 mat2 = new Matrix3();
		
		// Fill matrix with elements
		mat1.elements[0] = 0;
		mat1.elements[1] = 1;
		mat1.elements[2] = 2;
		mat1.elements[3] = 4;
		mat1.elements[4] = 2;
		mat1.elements[5] = 3;
		mat1.elements[6] = 5;
		mat1.elements[7] = 3;
		mat1.elements[8] = 1;
		
		// Fill matrix with elements
		mat2.elements[0] = 3;
		mat2.elements[1] = 1;
		mat2.elements[2] = 1;
		mat2.elements[3] = 1;
		mat2.elements[4] = 3;
		mat2.elements[5] = 1;
		mat2.elements[6] = 4;
		mat2.elements[7] = 0;
		mat2.elements[8] = 2;
		
		// multiply matrices
		Matrix3 result = mat1.multiply(mat2);
		result.printToScreen();
		
		Assert.assertTrue(result.elements[0] == 9);
		Assert.assertTrue(result.elements[1] == 3);
		Assert.assertTrue(result.elements[2] == 5);
		Assert.assertTrue(result.elements[3] == 26);
		Assert.assertTrue(result.elements[4] == 10);
		Assert.assertTrue(result.elements[5] == 12);
		Assert.assertTrue(result.elements[6] == 22);
		Assert.assertTrue(result.elements[7] == 14);
		Assert.assertTrue(result.elements[8] == 10);
	}
	
	@Test
	public void testMultiplyMatrixVector() {
		// Allocate Matrices
		Matrix3 mat1 = new Matrix3();
		Vector3 vec1 = new Vector3(3, 2, 3);
		
		// Fill matrix with elements
		mat1.elements[0] = 1;
		mat1.elements[1] = 2;
		mat1.elements[2] = 2;
		mat1.elements[3] = 5;
		mat1.elements[4] = 7;
		mat1.elements[5] = 3;
		mat1.elements[6] = 4;
		mat1.elements[7] = 9;
		mat1.elements[8] = 3;
				
		
		// multiply matrices
		Vector3 result = mat1.multiply(vec1);
		result.printToScreen();
		
		Assert.assertTrue(result.x == 13);
		Assert.assertTrue(result.y == 38);
		Assert.assertTrue(result.z == 39);
	}
}
