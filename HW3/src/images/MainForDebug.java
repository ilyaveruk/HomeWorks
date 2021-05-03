package images;

public class MainForDebug {

	public static void main(String[] args) {
		
		Image i1 = new Gradient(100, 150, RGB.RED, 
				RGB.WHITE);
				Image i2 = new Gradient(200, 100, RGB.BLUE, 
				RGB.GREEN);
				Image i = new Mix(i1,  i2, 0.7);
				Displayer.display(i);



		
	}

}
