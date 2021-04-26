package images;

public class Circle extends BaseImage {

	private int centerX, centerY, radius;
	private RGB center, outside;

	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.center = center;
		this.outside = outside;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size);
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	@Override
	public RGB get(int x, int y) {

		double rdX = x - centerX;
		double rdY = y - centerY;

		double newR = radius / Math.sqrt(rdX * rdX + rdY * rdY);

		return RGB.mix(center, outside, newR);
	}

}
