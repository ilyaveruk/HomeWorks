package root;

public class Rooter {

	private double precision;

	public Rooter(double precision) {
		this.precision = precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public double sqrt(double x) {
		double one = x / 2; // 2/2=1.0
		double two = x / one; // 2/1.0=2.0

		while (x > 0) {
			two = x / one;
			if (one == two)
				return one;

			if (Math.abs(two - one) < precision)
				return one;

			one = (one + two) / 2;

		}
		return one;

	}

}
