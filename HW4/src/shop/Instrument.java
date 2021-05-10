package shop;

public abstract class Instrument {
	
	protected String company;
	private int price;
	static int serial;
	
	public Instrument(String company, int price) {
	this.company=company;
	this.price=price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getCompany() {
		return company;
	}
	
	public int getSerial() {
		return serial++;
	}
	
	
	
	public static void main(String[] args) {
		Shop s = new Shop();
		s.add(new Guitar("Gibson", 1000, Type.ACOUSTIC));
		s.add(new Piano("Yamaha", 5000, 6));
		s.add(new Piano("Yamaha", 10000, 7));
		s.add(new Guitar("Fender", 4000, Type.ELECTRIC));

		System.out.println(s.allSerials());
		System.out.println(s.guitarsOfType(Type.ELECTRIC));
	}
}
