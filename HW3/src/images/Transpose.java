package images;

public class Transpose extends ImageDecorator {

	private Image base;

	public Transpose(Image base) {
		this.base = base;
	}

	// inverts height to width
	@Override
	public int getWidth() {

		return base.getHeight();
	}

	// inverts width to height
	@Override
	public int getHeight() {

		return base.getWidth();
	}

	// return the inverted height and width color
	@Override
	public RGB get(int x, int y) {

		return base.get(y, x);
	}

}
