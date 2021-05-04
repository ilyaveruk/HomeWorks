package images;

public class Circle extends BaseImage {

	private int centerX, centerY, radius;
	private RGB center, outside;
	// 2 constructors for the circle 
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		this.width = width;
		this.height = height;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		this.width = size;
		this.height = size;
		this.centerX = size / 2;
		this.centerY = size / 2;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	@Override
	// calculates the distance of the point from the center and return the relational color between the radius and distance
	public RGB get(int x, int y) {
		double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

		return distance > radius ? outside:RGB.mix(outside, center, distance / (double) radius);
	}
}
