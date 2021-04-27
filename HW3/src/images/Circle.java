package images;

public class Circle extends BaseImage {

	private int centerX, centerY, radius;

	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height, center, outside);
		this.radius=radius;
		this.centerX = centerX;
		this.centerY = centerY;
	}

	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size, center, outside);
		this.radius = radius;
	}

	@Override
	public RGB get(int x, int y) {

		double distance = Math.sqrt(Math.pow((x - (double) centerX), 2) + Math.pow(y - (double) centerY, 2));

		if (distance > radius)
			distance = radius;

		return RGB.mix(super.getRgb2(), super.getRgb1(), distance / (double) radius);
	}
	
	
	

}
