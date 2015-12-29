package de.gymolching.fsb.regulation; 
 
 import de.gymolching.fsb.api.FSBPosition; 
 import de.gymolching.fsb.maths.Matrix3; 
 import de.gymolching.fsb.maths.Vector3; 
 
 
 public class Regulation { 
 	private static final double RADIUSA = 10; 
 	private static final double HEIGHT = 10; 
 	private static final float MINL = 0; 
 
 
 	private static Vector3 Va = new Vector3(-Math.cos(30 * Math.PI / 180) * RADIUSA, 0, -Math.sin(30 * Math.PI / 180) * RADIUSA); 
 	private static Vector3 Vb = new Vector3(0, 0, RADIUSA); 
 	private static Vector3 Vc = new Vector3(Math.cos(30 * Math.PI / 180) * RADIUSA, 0, -Math.sin(30 * Math.PI / 180) * RADIUSA); 
 	private static Vector3 Vd = new Vector3(0, -HEIGHT, -RADIUSA); 
 	private static Vector3 Ve = new Vector3(-Math.cos(30 * Math.PI / 180) * RADIUSA, -HEIGHT, Math.sin(30 * Math.PI / 180) * RADIUSA); 
 	private static Vector3 Vf = new Vector3(Math.cos(30 * Math.PI / 180) * RADIUSA, -HEIGHT, Math.sin(30 * Math.PI / 180) * RADIUSA); 
 	private static Vector3 Vab; 
 	private static Vector3 Vbb; 
 	private static Vector3 Vcb; 
 	private static Vector3 Vdb; 
 	private static Vector3 Veb; 
 	private static Vector3 Vfb; 
 
 
 	public static FSBPosition calculatePosition(double x, double y, double z, double rotX, double rotY, double rotZ) { 
 		Matrix3 RotMatrix = Matrix3.getRotationMatrix(rotX* Math.PI / 180, rotY* Math.PI / 180, rotZ* Math.PI / 180); 
 		Vab = RotMatrix.multiply(Va); 
 		Vbb = RotMatrix.multiply(Vb); 
 		Vcb = RotMatrix.multiply(Vc); 
 //		System.out.println(" va " + Vab.getLength() + " vb " + Vbb.getLength() + " vc " +Vcb.getLength()); 
 //		Vab.printToScreen(); 
 //		Vbb.printToScreen(); 
 //		Vcb.printToScreen(); 
 		Vector3 m = new Vector3(-x, -y, -z); 
 		Vdb = m.add(Vd); 
 		Veb = m.add(Ve); 
 		Vfb = m.add(Vf); 
 //		Vdb.printToScreen(); 
 //		Veb.printToScreen(); 
 //		Vfb.printToScreen(); 
 //		System.out.println(" vd " + Vdb.getLength() + " ve " + Veb.getLength() + " vf " +Vfb.getLength()); 
 		Vab.invert(); 
 		Vbb.invert(); 
 		Vcb.invert(); 
 		double length1 = Veb.add(Vbb).getLength() - MINL; 
 		double length2 = Vfb.add(Vbb).getLength() - MINL; 
 		 
 		double length3 = Vfb.add(Vcb).getLength() - MINL; 
 		double length4 = Vdb.add(Vcb).getLength() - MINL; 
 		double length5 = Vdb.add(Vab).getLength() - MINL; 
 		double length6 = Veb.add(Vab).getLength() - MINL; 
 //		System.out.println("Länge1  " + length1 + "  Länge2  " + length2 + "  Länge3 " + length3 +"  Länge4 "+ length4 + "  Länge5 " +length5 + "  Länge6 " + length6 ); 
 
 
 		return new FSBPosition((int) Math.round(length1), (int) Math.round((length2)), (int) Math.round(length3), 
 				(int) Math.round(length4), (int) Math.round(length5), (int) Math.round(length6)); 
 	} 
 } 