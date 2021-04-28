package images;

public class MainForDebug {

	public static void main(String[] args) {
		
		Image i2 = new Invert(new Circle(120, 60, RGB.RED, RGB.BLACK));
		Displayer.display(i2);

		new Invert(new Circle(120, 60, RGB.RED, RGB.BLACK));
	}

}
