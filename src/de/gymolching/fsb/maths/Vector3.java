package de.gymolching.fsb.maths;

public class Vector3 {
	public double x, y, z;

	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void  invert(){
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
	}

	public double getLength() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}
	
	public Vector3 add(Vector3 vector) {
		return new Vector3(this.x + vector.x, this.y + vector.y, this.z + vector.z);
	}

	public void printToScreen() {
		System.out.println("[Vector3] " + this + "\n{ " + this.x + ", "
				+ this.y + ", " + this.z + " }");
	}
}
