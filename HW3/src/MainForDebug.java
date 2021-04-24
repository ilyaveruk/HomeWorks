
public class MainForDebug {
	public static void main(String[] args) {
//	int[] x = {2, 4, 6, 1};
//	MyIterator it = new MyArray(x);
//	while(it.hasNext())
//		System.out.print(it.next() + " ");

		MyIterator it = new Fibonacci(9);
		while (it.hasNext())
			System.out.print(it.next() + " ");
		
		System.out.print(it.next() + " ");
		System.out.print(it.next() + " ");
		System.out.print(it.next() + " ");
		
		System.out.println();
		System.out.println(IteratorToString.toString(new Fibonacci(10)));

	}
}
