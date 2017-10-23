package tarea02;

/**
 * A representation of a rational number
 * */
public class Fraction {
	
	/**
	 * A' = A.normalized() is such that 
	 * gcd(A'.numerator, A'.denominator) = 1
	 * */
	public Fraction normalized() {
		//TODO stub
		return null;
	}

	public Fraction(int numerator, int denominator) {
		//TODO stub
	}
	
	////////////~~~ARITHMETIC OPERATORS~~~////////////
	
	//// Binary operators ////
	
	/**
	 * a + b
	 * */
	public static Fraction add(Fraction a, Fraction b) {
		//TODO stub
		return null;
	}
	
	/**
	 * a - b
	 * */
	public static Fraction sub(Fraction a, Fraction b) {
		//TODO stub
		return null;
	}
	
	/**
	 * a x b
	 * */
	public static Fraction mul(Fraction a, Fraction b) {
		//TODO stub
		return null;
	}
	
	/**
	 * a / b
	 * */
	public static Fraction div(Fraction a, Fraction b) {
		//TODO stub
		return null;
	}
	

	//// Unary operators ////
	
	/**
	 * -a
	 * */
	public static Fraction neg(Fraction a) {
		//TODO stub
		return null;
	}
	
	/**
	 * 1 / a
	 * */
	public static Fraction invMultiplicative(Fraction a) {
		//TODO stub
		return null;
	}
	

	//// 0-ary operators (constants) ////
	
	/**
	 * 1
	 * */
	public static Fraction one() {
		//TODO stub
		return null;
	}
	
	/**
	 * 0
	 * */
	public static Fraction zero() {
		//TODO stub
		return null;
	}
	
	////////////~~~BOOLEAN OPERATORS~~~////////////
		
	/**
	 * a == b
	 * */
	public static boolean equals(Fraction a, Fraction b) {
		//TODO stub
		return false;
	}
	
	/**
	 * a > b
	 * */
	public static boolean gThan(Fraction a, Fraction b) {
		//TODO stub
		return false;
	}
	
	/**
	 * a < b
	 * */
	public static boolean lThan(Fraction a, Fraction b) {
		//TODO stub
		return false;	
	}
}
