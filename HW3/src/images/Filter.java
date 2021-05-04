package images;

public class Filter extends ImageDecorator {
	
	private RGB filter;
	//constructor and inherits the base width and height
	public Filter(Image base, RGB filter) {
		this.base = base;
		this.filter = filter;
		width = base.getWidth();
		height = base.getHeight();
	}
	//implements the given x and y of the original get function and applies filter
	@Override
	public RGB get(int x, int y) {
		return super.get(x, y).filter(filter);
	}
}
