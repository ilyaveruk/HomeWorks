package bank;

//import java.util.Arrays;

public class ProAccount extends Account {
	private int[] arr = new int[100];
	private int count = 0;

	public ProAccount(String name) {
		super(name);
	}

	@Override
	public void add(int amount) {
		super.add(amount);
		arr[count++] = getShekels();

	}

	@Override
	public String toString() {
		
//		int[] temp = new int[count];       beautiful and cleaner code with this
//		for (int i = 0; i < count; i++)
//			temp[i] = arr[i];
//		return super.toString() + Arrays.toString(temp);
		
		String s=" [";
		int[] temp = new int[count];
		for (int i = 0; i < count-1; i++) {
			temp[i] = arr[i];
			s+=temp[i] +",";
		}
		s+=arr[count-1]+ "]";
	
		return super.toString() + s ;

	}

	public static void transfer(ProAccount from, ProAccount to, int amount) {
		from.add(amount * -1);
		to.add(amount);
	}

}
