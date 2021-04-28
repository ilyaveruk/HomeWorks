package images;

public class Invert extends ImageDecorator {

	private Image base;
	
	public Invert(Image base) {
		this.base=base;
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
		
		return base.get(x - base.getHeight() / 2, y - base.getWidth() / 2).invert();
	}

}
