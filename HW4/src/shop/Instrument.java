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

}
