package images;

public class Mix extends BinaryImageDecorator{

	private Image base1, base2;
	private double alpha;
	
	public Mix(Image base1, Image base2, double alpha) {
	this.alpha=alpha;	
	this.base1=base1;
	this.base2=base2;
	}
	
	@Override
	public int getWidth() {
		
		return base1.getWidth() > base2.getWidth() ? base1.getWidth() : base2.getWidth();
	}

	@Override
	public int getHeight() {
		
		return base1.getHeight() > base2.getHeight() ? base1.getHeight() : base2.getHeight();
	}

	@Override
	public RGB get(int x, int y) {
		
		if (x > getWidth() || y > getHeight())
			return null;
		
			if ((x > base1.getWidth() || y > base1.getHeight()) && (x > base2.getWidth() || y > base2.getHeight()))
				return RGB.BLACK;

			else if (x > base1.getWidth() || y > base1.getHeight())
				return base2.get(x, y);

			else if (x > base2.getWidth() || y > base2.getHeight())
				return base1.get(x, y);
			
			else
				return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
	}

}
