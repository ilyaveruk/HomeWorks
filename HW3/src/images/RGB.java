package images;

public class RGB {
	private double red, green, blue;
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	public RGB(double red, double green, double blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public RGB(double grey) {
		this.red = grey;
		this.green = grey;
		this.blue = grey;
	}

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

	public RGB filter(RGB filter) {

		red = red * filter.red;
		green = green * filter.green;
		blue = blue * filter.blue;

		return new RGB(red, green, blue);
	}

	public static RGB superpose(RGB rgb1, RGB rgb2) {
		RGB newColor = new RGB(0,0,0);//should be initialized to null

		newColor.red = (rgb1.red + rgb2.red) > 1 ? 1 : rgb1.red + rgb2.red;
		newColor.green = (rgb1.green + rgb2.green) > 1 ? 1 : rgb1.green + rgb2.green;
		newColor.blue = (rgb1.blue + rgb2.blue) > 1 ? 1 : rgb1.blue + rgb2.blue;

		return newColor;

	}

	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		RGB newColor = new RGB(0,0,0);//should be initialized to null

		newColor.red = alpha * rgb1.red + (1 - alpha) * rgb2.red;
		newColor.green = alpha * rgb1.green + (1 - alpha) * rgb2.green;
		newColor.blue = alpha * rgb1.blue + (1 - alpha) * rgb2.blue;

		return newColor;
	}

	public String toString() {

		String str = String.format("<%.4f, %.4f, %.4f>", red, green, blue);

		return str;

	}

}
