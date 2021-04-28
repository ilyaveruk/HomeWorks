package images;

public class Filter extends ImageDecorator {

	private Image base;
	private RGB filter;

	public Filter(Image base, RGB filter) {
		this.base = base;
		this.filter = filter;
	}

	@Override
	public int getWidth() {
		return base.getWidth();
	}

	@Override
	public int getHeight() {
		return base.getHeight();
	}

	@Override
	public RGB get(int x, int y) {

		return base.get(x - base.getHeight() / 2, y - base.getWidth() / 2).filter(filter);
	}

}
