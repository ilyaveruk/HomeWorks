package images;

public abstract class BaseImage implements Image {
//should be one abstract method
	private int width, height;
	private RGB rgb1, rgb2;

	public BaseImage(int width, int height, RGB rgb1, RGB rgb2) {
		this.width = width;
		this.height = height;
		this.rgb1=rgb1;
		this.rgb2=rgb2;
	}

	@Override
	public int getWidth() {

		return width;
	}

	@Override
	public int getHeight() {

		return height;
	}
	
	public RGB getRgb1() {
		return rgb1;
	}
	
	public RGB getRgb2() {
		return rgb2;
	}
}
