package tarea02;

public class Utils {
	
	public static int greatestCommonDenominator(int a, int b) {
		return b == 0 ? a : Utils.greatestCommonDenominator(b, a % b);
	}
}
