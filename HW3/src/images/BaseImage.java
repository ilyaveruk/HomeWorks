package images;

public abstract class BaseImage implements Image {
	// implements Image decorator with getters
	protected int width, height;

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}
}
