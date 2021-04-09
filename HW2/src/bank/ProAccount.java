package bank;

//import java.util.Arrays;

public class ProAccount extends Account {
	private int[] arr = new int[100];
	private int count = 0;

	public ProAccount(String name) {
		super(name);
	}

	//uses the method from Account and save any change in the account in array called history
	@Override
	public void add(int amount) {
		super.add(amount);
		arr[count++] = getShekels();

	}

	//uses the method from Account and add string for the history
	@Override
	public String toString() {
	
		String s=" [";
		int[] temp = new int[count];
		for (int i = 0; i < count-1; i++) {
			temp[i] = arr[i];
			s+=temp[i] +",";
		}
		s+=arr[count-1]+ "]";
	
		return super.toString() + s ;

	}

	//transfer from account "from" to account "to"
	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(amount * -1);
		to.add(amount);
	}

}
