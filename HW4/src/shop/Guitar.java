package shop;

public class Guitar extends Instrument {

	private Type type;

	public Guitar(String company, int price, Type type) {
		super(company, price);
		this.type = type;

	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("Guitar(%s) %s(%d), price = %d", type, company, getSerial(), getPrice());
	}

}
