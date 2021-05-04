package images;

public class RGB {
	private double red, green, blue;
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	// constructor for RGB
	public RGB(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	// constructor for RGB
	public RGB(double grey) {
		this.red = grey;
		this.green = grey;
		this.blue = grey;
	}

	// 3 getters
	public double getRed() {
		return red;
	}

	public double getBlue() {
		return blue;
	}

	public double getGreen() {
		return green;
	}

	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	// multiplies each color in the filtered color
	public RGB filter(RGB filter) {
		return new RGB(red * filter.red, green * filter.green, blue * filter.blue);
	}

	// checks for every color if their sum is bigger than 1 it return 1 , else
	// return the sum of the colors
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		return new RGB(rgb1.red + rgb2.red < 1 ? rgb1.red + rgb2.red : 1,
				rgb1.green + rgb2.green < 1 ? rgb1.green + rgb2.green : 1,
				rgb1.blue + rgb2.blue < 1 ? rgb1.blue + rgb2.blue : 1);

	}

	// multiplies alpha in each color and return the new color
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		return new RGB(alpha * rgb1.red + (1 - alpha) * rgb2.red, alpha * rgb1.green + (1 - alpha) * rgb2.green,
				alpha * rgb1.blue + (1 - alpha) * rgb2.blue);
	}

	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);

	}

}
