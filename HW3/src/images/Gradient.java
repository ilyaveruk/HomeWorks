package images;

public class Gradient extends BaseImage {

	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height, start, end);

	}

	@Override
	public RGB get(int x, int y) {
		// reversed between end and start ( could be 1-(double)x/width)
		return RGB.mix(super.getRgb2(), super.getRgb1(), (double) x / super.getWidth());
	}

}
