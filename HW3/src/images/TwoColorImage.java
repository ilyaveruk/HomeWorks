package images;

public class TwoColorImage extends BaseImage {

	private RGB zero, one;
	private TwoDFunc func;

	// constructor
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		this.width = width;
		this.height = height;
		this.zero = zero;
		this.one = one;
		this.func = func;
	}

	// normalize the x and the y coordinates and if the normal greater than 1
	// returns one color if less than 0 return zero color otherwise return the mix
	// of one and zero with the normal
	@Override
	public RGB get(int x, int y) {
		double normal = func.f((double) x / width, (double) y / height);

		if (normal <= 0)
			return zero;
		if (normal >= 1)
			return one;

		return RGB.mix(one, zero, normal);
	}
}
