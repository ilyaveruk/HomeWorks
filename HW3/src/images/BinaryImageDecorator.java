package images;

public abstract class BinaryImageDecorator implements Image {
//decorator for BinaryImage 
	public abstract int getWidth();

	public abstract int getHeight();

	public abstract RGB get(int x, int y);

}
