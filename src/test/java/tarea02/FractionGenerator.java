package tarea02;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class FractionGenerator extends Generator<Fraction> {

	public FractionGenerator() {
		super(Fraction.class);
	}
	
	/**
	 * At least for integers, this is straightforward
	 * */
	public Fraction generate(SourceOfRandomness source, GenerationStatus gStatus) {
		return new Fraction(source.nextInt(0, 100000000), source.nextInt(1, 100000000));
	}
}
