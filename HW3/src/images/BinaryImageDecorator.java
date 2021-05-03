package images;

public abstract class BinaryImageDecorator implements Image {

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract RGB get(int x, int y);

}
