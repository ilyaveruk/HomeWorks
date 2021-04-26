package images;

public class Gradient extends BaseImage {
	
	
	private RGB start,end;
	
	public Gradient(int width, int height, RGB start, RGB end) {
		super(width,height);
		this.start=start;
		this.end=end;
	}
	
	@Override
	public RGB get(int x, int y) {
		//reversed between end and start ( could be 1-(double)x/width)
		return RGB.mix(end,start,(double)x/super.getWidth());
	}

	

}
