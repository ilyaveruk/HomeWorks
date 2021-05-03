package images;

public class MainForDebug {

	public static void main(String[] args) {
		
		Image i1 = new Gradient(100, 150, RGB.RED,
				RGB.RED);
				Image i2 = new Gradient(200, 100, RGB.BLUE,
				RGB.BLUE);
				Image i = new Superpose(i1,  i2);
				Displayer.display(i);


		
	}

}
