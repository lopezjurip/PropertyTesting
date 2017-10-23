package tarea02;

/**
 * A representation of a rational number
 * */
public class Fraction {

	private int numerator;
    private int denominator;

	public int Numerator() {
		return numerator;
	}
    public int Denominator() {
        return denominator;
    }

	/**
	 * A' = A.normalized() is such that 
	 * gcd(A'.numerator, A'.denominator) = 1
	 * */
	public Fraction normalized() {
		int gcd = Utils.greatestCommonDenominator(this.numerator, this.denominator);
		int numerator = this.numerator / gcd;
        int denominator = this.denominator / gcd;
		return new Fraction(numerator, denominator);
	}

	public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can not equal to 0");
        }
        if (numerator < 0 && denominator < 0) {
            this.numerator = Math.abs(numerator);
            this.denominator = Math.abs(denominator);
        } else if (denominator < 0) {
            this.numerator = numerator * -1;
            this.denominator = denominator * -1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
	}
	
	////////////~~~ARITHMETIC OPERATORS~~~////////////
	
	//// Binary operators ////
	
	/**
	 * a + b
	 * */
	public static Fraction add(Fraction a, Fraction b) {
		int denominator = a.denominator * b.denominator;
		return new Fraction(a.numerator * b.denominator + b.numerator * a.denominator, denominator);
	}
	
	/**
	 * a - b
	 * */
	public static Fraction sub(Fraction a, Fraction b) {
		return Fraction.add(a, Fraction.neg(b));
	}
	
	/**
	 * a x b
	 * */
	public static Fraction mul(Fraction a, Fraction b) {
		return new Fraction(a.numerator * b.numerator, a.denominator * b.denominator);
	}
	
	/**
	 * a / b
	 * */
	public static Fraction div(Fraction a, Fraction b) {
		return Fraction.mul(a, Fraction.invMultiplicative(b));
	}
	

	//// Unary operators ////
	
	/**
	 * -a
	 * */
	public static Fraction neg(Fraction a) {
		return new Fraction(a.numerator * -1, a.denominator);
	}
	
	/**
	 * 1 / a
	 * */
	public static Fraction invMultiplicative(Fraction a) {
		return new Fraction(a.denominator, a.numerator);
	}
	

	//// 0-ary operators (constants) ////
	
	/**
	 * 1
	 * */
	public static Fraction one() {
		return new Fraction(1, 1);
	}
	
	/**
	 * 0
	 * */
	public static Fraction zero() {
		return new Fraction(0, 1);
	}
	
	////////////~~~BOOLEAN OPERATORS~~~////////////

	/**
	 * a == b
	 * */
	public static boolean equals(Fraction a, Fraction b) {
		Fraction aNormalized = a.normalized();
        Fraction bNormalized = b.normalized();
		return aNormalized.numerator == bNormalized.numerator && aNormalized.denominator == bNormalized.denominator;
	}
	
	/**
	 * a > b
	 * */
	public static boolean gThan(Fraction a, Fraction b) {
        return (a.numerator / a.denominator) > (b.numerator / b.denominator);
	}
	
	/**
	 * a < b
	 * */
	public static boolean lThan(Fraction a, Fraction b) {
        return a.numerator / a.denominator < b.numerator / b.denominator;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Fraction.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return Fraction.equals(this, (Fraction) obj);
    }

    @Override
    public String toString() {
        return this.numerator+ "/" + this.denominator;
    }
}
