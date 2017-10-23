package tarea02;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class FractionGenerator extends Generator<Fraction> {
	private static final int MIN = -100;
	private static final int MAX = 100;

	public FractionGenerator() {
		super(Fraction.class);
	}

	public Fraction generate(SourceOfRandomness source, GenerationStatus gStatus) {
		while (true) {
			int denominator = source.nextInt(MIN, MAX);
			if (denominator != 0) {
				return new Fraction(source.nextInt(MIN, MAX), denominator);
			}
		}
	}
}
