package images;

public class Gradient extends BaseImage {
	
	private RGB start, end;
	//constructor
	public Gradient(int width, int height, RGB start, RGB end) {
		this.width = width;
		this.height = height;
		this.start = start;
		this.end = end;
	}

	@Override
	//returns the new mixed color by the x that given
	public RGB get(int x, int y) {
		return RGB.mix(end, start, (double) x / width);
	}
}