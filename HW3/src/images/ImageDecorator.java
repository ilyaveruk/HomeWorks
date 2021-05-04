package images;

public abstract class ImageDecorator implements Image {
	//implements the image interface with getters and the get function of the base
	protected int width, height;
	protected Image base;

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public RGB get(int x, int y) {
		return base.get(x, y);
	}

}
