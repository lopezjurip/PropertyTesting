package tarea02;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class VectorGenerator extends Generator<Vector> {
	private FractionGenerator fractionGenerator;

	public VectorGenerator() {
		super(Vector.class);
		this.fractionGenerator = new FractionGenerator();
	}

	public Vector generate(SourceOfRandomness source, GenerationStatus gStatus) {
		return new Vector(
				this.fractionGenerator.generate(source, gStatus),
				this.fractionGenerator.generate(source, gStatus),
				this.fractionGenerator.generate(source, gStatus));
	}
}
