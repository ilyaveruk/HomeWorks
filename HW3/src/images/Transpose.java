package images;

public class Transpose extends ImageDecorator {

	private Image base;
	
	public Transpose(Image base) {
		this.base = base;
	}

	@Override
	public int getWidth() {

		return base.getHeight();
	}

	@Override
	public int getHeight() {
		
		return base.getWidth();
	}

	@Override
	public RGB get(int x, int y) {
		
		return base.get(y,x);
	}

}
