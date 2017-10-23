package tarea02;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class FractionProperties {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
	
	/**
	 * a/b == c/d if and only if a·d = b·c
	 * */
	@Property(trials = Short.MAX_VALUE) public void equivalentFractions(
			@From(FractionGenerator.class) Fraction f,
			@From(FractionGenerator.class) Fraction g) {

        assertEquals(Fraction.equals(f, g), f.Numerator() * g.Denominator() == f.Denominator() * g.Numerator());
	}

    /**
     * a/b * b/a == 1
     * */
    @Property(trials = Short.MAX_VALUE) public void inverse(
            @From(FractionGenerator.class) Fraction f) {

        if (Fraction.equals(f, Fraction.zero())) {
            exception.expect(IllegalArgumentException.class); // Inverting a 0/n should throw an exception.
            Fraction.invMultiplicative(f);
        } else {
            assertEquals(Fraction.mul(f, Fraction.invMultiplicative(f)), Fraction.one());
        }
    }

    /**
     * a/b + c/d == c/d + a/b
     * a/b * c/d == c/d * a/b
     * */
    @Property(trials = Short.MAX_VALUE) public void commutative(
            @From(FractionGenerator.class) Fraction f,
            @From(FractionGenerator.class) Fraction g) {

        assertEquals(Fraction.add(f, g), Fraction.add(g, f));
        assertEquals(Fraction.mul(f, g), Fraction.mul(g, f));
    }

    /**
     * a/b + c/d == c/d + a/b
     * a/b * c/d == c/d * a/b
     * */
    @Property(trials = Short.MAX_VALUE) public void identity(
            @From(FractionGenerator.class) Fraction f) {

        assertEquals(Fraction.add(f, Fraction.zero()), f);
        assertEquals(Fraction.mul(f, Fraction.one()), f);
    }
}
