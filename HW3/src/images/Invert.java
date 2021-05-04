package images;

public class Invert extends ImageDecorator {
	//constructor and inherits the base width and height
	public Invert(Image base) {
		this.width = base.getWidth();
		this.height = base.getHeight();
		this.base = base;
	}
	//implements the given x and y of the original get function and applies invert function on it
	@Override
	public RGB get(int x, int y) {
		return super.get(x, y).invert();
	}
}
