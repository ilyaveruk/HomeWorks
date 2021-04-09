package bank;

public class Account {
	private String name;
	private int shekels;
	
	public Account(String name) {
		this.name=name;
	}
	
	//return amount of NIS
	public int getShekels() {
		return shekels;
	}
	
	//return the account name
	public String getName() {
		return name;
	}
	
	//add "amount" to shekels
	public void add(int amount) {
		shekels+=amount;
	}
	//make string as asked and return it
	public String toString() { 
		return String.format("%s has %d shekels",name, shekels);
	}
	
}
