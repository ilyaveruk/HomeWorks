
public class MainForDebug {
public static void main(String[] args) {
	int[] x = {2, 4, 6, 1};
	MyIterator it = new MyArray(x);
	while(it.hasNext())
		System.out.print(it.next() + " ");

}
}
