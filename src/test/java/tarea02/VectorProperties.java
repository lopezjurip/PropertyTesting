package tarea02;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class VectorProperties {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static boolean isPerpendicular(Vector v, Vector w) {
        return Vector.cross(v, w).equals(Vector.mul(v, w));
    }
	
	/**
     * A + B == B + A
     * */
    @Property(trials = Short.MAX_VALUE) public void commutative(
            @From(VectorGenerator.class) Vector v,
            @From(VectorGenerator.class) Vector w) {

        Assert.assertEquals(Vector.add(v, w), Vector.add(w, v));
    }

    /**
     * A + 0 = A
     * A · 1 = A
     * */
    @Property(trials = Short.MAX_VALUE) public void identity(
            @From(VectorGenerator.class) Vector v) {

        Assert.assertEquals(Vector.add(v, Vector.zero()), v);
        Assert.assertEquals(Vector.mulScalar(v, Fraction.one()), v);
    }

    /**
     * A - A = 0
     * A · 0 = 0
     * */
    @Property(trials = Short.MAX_VALUE) public void zero(
            @From(VectorGenerator.class) Vector v) {

        Assert.assertEquals(Vector.sub(v, v), Vector.zero());
        Assert.assertEquals(Vector.dot(v, Vector.zero()), Fraction.zero());
    }

    /**
     * A x B == 0 <-> A == 0 || B == 0 || A _|_ B
     * */
    @Property(trials = Short.MAX_VALUE) public void perpendicular(
            @From(VectorGenerator.class) Vector v,
            @From(VectorGenerator.class) Vector w) {

        Assert.assertEquals(
                Vector.dot(v, w).equals(Vector.zero()),
                Vector.zero().equals(v) || Vector.zero().equals(w) || VectorProperties.isPerpendicular(v, w));
    }

    /**
     * A x B != A x B
     * A x B == -B x A
     * */
    @Property(trials = Short.MAX_VALUE) public void crossNotCommutative(
            @From(VectorGenerator.class) Vector v,
            @From(VectorGenerator.class) Vector w) {

        Assert.assertNotEquals(Vector.cross(v, w), Vector.cross(w, v));
        Assert.assertEquals(
                Vector.cross(v, w),
                Vector.cross(Vector.mulScalar(w, Fraction.neg(Fraction.one())), v));
    }
}
