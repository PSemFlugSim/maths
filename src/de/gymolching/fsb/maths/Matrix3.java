package de.gymolching.fsb.maths;

import de.gymolching.fsb.maths.test.Vector3;

public class Matrix3 {
	public double[] elements;

	/**
	 * Creates zeroed-out matrix
	 */
	public Matrix3() {
		// Allocate 3 by 3 matrix
		this.elements = new double[3 * 3];

		// Zero out each matrix's element
		for (int i = 0; i < this.elements.length; i++) {
			this.elements[i] = 0.0;
		}
	}

	/**
	 * Creates "vector matrix"
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Matrix3(double x, double y, double z) {
		this();

		this.elements[0] = x;
		this.elements[3] = y;
		this.elements[6] = z;
	}

	/**
	 * Returns the multiplication result of this matrix and the parameter (this
	 * * parameter)
	 * 
	 * @param matrix
	 * @return
	 */
	public Matrix3 multiply(Matrix3 matrix) {
		Matrix3 result = new Matrix3();
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				float sum = 0.0f;
				for (int e = 0; e < 3; e++) {
					sum += this.elements[e + column * 3]
							* matrix.elements[row + e * 3];
				}

				result.elements[row + column * 3] = sum;
			}
		}

		return result;
	}

	/**
	 * Returns the multiplication result of this matrix and the parameter vector
	 * (this * vector)
	 * 
	 * @param vector
	 * @return
	 */
	public Vector3 multiply(Vector3 vector) {
		Matrix3 vectorMatrix = new Matrix3();
		vectorMatrix.elements[0] = vector.x;
		vectorMatrix.elements[3] = vector.y;
		vectorMatrix.elements[6] = vector.z;

		Matrix3 resultMatrix = this.multiply(vectorMatrix);

		Vector3 result = new Vector3(resultMatrix.elements[0],
				resultMatrix.elements[3], resultMatrix.elements[6]);
		return result;
	}

	public void printToScreen() {
		System.out.println("[Matrix3] " + this + "\n{");
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				System.out.print(this.elements[3 * row + column] + ", ");
			}
			System.out.println("");
		}
		System.out.println("}");
	}
}
