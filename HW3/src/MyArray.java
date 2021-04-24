import java.util.NoSuchElementException;

public class MyArray implements MyIterator{
	private int numOfCalls;
	private int[] arr;
	
	public MyArray(int[] arr) {
		this.arr=arr;
	}
	
	@Override
	public boolean hasNext() {
		return numOfCalls < arr.length;
	}
	
	@Override
	public int next() {

		if (!hasNext())
			throw new NoSuchElementException();

		return arr[numOfCalls++];
	}

}
