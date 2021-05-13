package shop;

public abstract class Instrument {

	protected String company;
	private int price;
	protected static int serial = 0;
	private int serialID;

	public Instrument(String company, int price) {
		this.company = company;
		this.price = price;
		this.serialID = serial++;
	}

	public int getPrice() {
		return price;
	}

	public String getCompany() {
		return company;
	}

	public int getSerial() {
		return serialID;
	}

	public static void main(String[] args) throws MusicShopException {
		Shop s = new Shop();
		s.add(new Guitar("son", 1000, Type.ACOUSTIC));
		s.add(new Piano("Yamaha", 5000, 6));
		s.add(new Guitar("son", 1000, Type.ACOUSTIC));
		s.add(new Guitar("son", 1000, Type.ACOUSTIC));
		s.add(new Guitar("son", 1000, Type.ELECTRIC));

		System.out.println(s.allSerials());
		// System.out.println(s.guitarsOfType(Type.ACOUSTIC));//need to fix
		System.out.println(s.get(3));
		
		
		s.sell(0);
		s.sell(2);
		

		System.out.println(s.allSerials());
		
		
	}

}
