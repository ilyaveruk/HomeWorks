package images;

public interface Image {
	//interface for image
	public int getWidth();

	public int getHeight();

	public RGB get(int x, int y);
}
