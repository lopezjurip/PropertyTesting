package tarea02;

/**
 * A 3D Vector.
 * Since it uses Fractions, calculations are 
 * guaranteed to be exact
 * */
public class Vector {

	private Fraction x;
	private Fraction y;
	private Fraction z;

	public Fraction X() {
		return x;
	}
	public Fraction Y() {
		return y;
	}
	public Fraction Z() {
		return z;
	}
	
	public Vector(Fraction x, Fraction y, Fraction z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * a + b
	 * */
	public static Vector add(Vector a, Vector b) {
		Fraction x = Fraction.add(a.x, b.x);
		Fraction y = Fraction.add(a.y, b.y);
		Fraction z = Fraction.add(a.z, b.z);
		return new Vector(x, y, z);
	}
	
	/**
	 * a - b
	 * */
	public static Vector sub(Vector a, Vector b) {
		Fraction x = Fraction.sub(a.x, b.x);
		Fraction y = Fraction.sub(a.y, b.y);
		Fraction z = Fraction.sub(a.z, b.z);
		return new Vector(x, y, z);
	}

	/**
	 * (a.X * bX, a.Y * b.Y, a.Z * b.Z)
	 * */
	public static Vector mul(Vector a, Vector b) {
		Fraction x = Fraction.mul(a.x, b.x);
		Fraction y = Fraction.mul(a.y, b.y);
		Fraction z = Fraction.mul(a.z, b.z);
		return new Vector(x, y, z);
	}
	
	/**
	 * (a.X / bX, a.Y / b.Y, a.Z / b.Z)
	 * */
	public static Vector div(Vector a, Vector b) {
		Fraction x = Fraction.div(a.x, b.x);
		Fraction y = Fraction.div(a.y, b.y);
		Fraction z = Fraction.div(a.z, b.z);
	}
	
	/**
	 * Multiplication of a vector by a scalar
	 * */
	public static Vector mulScalar(Vector a, Fraction s) {
		Fraction x = Fraction.mul(a.x, s);
		Fraction y = Fraction.mul(a.y, s);
		Fraction z = Fraction.mul(a.z, s);
		return new Vector(x, y, z);
	}
	
	/**
	 * Division of a vector by a scalar
	 * */
	public static Vector divScalar(Vector a, Fraction s) {
		Fraction x = Fraction.div(a.x, s);
		Fraction y = Fraction.div(a.y, s);
		Fraction z = Fraction.div(a.z, s);
		return new Vector(x, y, z);
	}
	
	/**
	 * Dot product
	 * */
	public static Fraction dot(Vector a, Vector b) {
		return Fraction.add(Fraction.add(Fraction.mul(a.x, b.x), Fraction.mul(a.y, b.y)), Fraction.mul(a.z, b.z));
	}
	
	/**
	 * Cross product
	 * */
	public static Vector cross(Vector a, Vector b) {
		Fraction x = Fraction.sub(Fraction.mul(a.y, b.z), Fraction.mul(b.y, a.z));
		Fraction y = Fraction.sub(Fraction.mul(a.z, b.x), Fraction.mul(b.z, a.x));
		Fraction z = Fraction.sub(Fraction.mul(a.x, b.y), Fraction.mul(b.x, a.y));
		return new Vector(x, y, z);
	}

	/**
	 * Zero vector
	 * */
	public static Vector zero() {
		return new Vector(Fraction.zero(), Fraction.zero(), Fraction.zero());
	}
	
	/**
	 * (1, 0, 0)
	 * */
	public static Vector eX() {
		return new Vector(Fraction.one(), Fraction.zero(), Fraction.zero());
	}
	
	/**
	 * (0, 1, 0)
	 * */
	public static Vector eY() {
		return new Vector(Fraction.zero(), Fraction.one(), Fraction.zero());
	}
	
	/**
	 * (0, 0, 1)
	 * */
	public static Vector eZ() {
		return new Vector(Fraction.zero(), Fraction.zero(), Fraction.one());
	}
	
	public static boolean equals(Vector a, Vector b) {
		return Fraction.equals(a.x, b.x) && Fraction.equals(a.y, b.y) && Fraction.equals(a.z, b.z);
	}
}
