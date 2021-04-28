package images;

public class MainForDebug {

	public static void main(String[] args) {
		Image i = new Circle(120, 60, RGB.WHITE, RGB.BLACK);
		Image i2 = new Filter(i, new RGB(0.5, 0, 1));
		Displayer.display(i2);

	}

}
