package images;

public class MainForDebug {

	public static void main(String[] args) {
		
//		Image i1 = new Gradient(500, 500, RGB.BLUE, RGB.BLACK);
//		Image i2 = new Transpose(new Gradient(500, 500, RGB.RED, RGB.BLACK));
//		Image i3 = new Mix(i1, i2, 0.5);
//		Image i4 = new Circle(350, 150, new RGB(1, 1, 0), RGB.BLACK);
//		Image i5 = new Circle(200, 100, new RGB(0, 0.5, 1), RGB.BLACK);
//		Image i6 = new Circle(500, 200, RGB.WHITE, RGB.BLACK);
//
//		Image i7 = new Superpose(i3, i4);
//		Image i8 = new Superpose(i5, i6);
//		Image i9 = new Superpose(i7, i8);
//
//		Displayer.display(i9);



		
		Image i2 = new Invert(new Circle(120, 60, RGB.RED, RGB.BLACK));
		Displayer.display(i2);



		
	}

}
