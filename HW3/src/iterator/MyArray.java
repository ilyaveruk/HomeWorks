package iterator;

import java.util.NoSuchElementException;

public class MyArray implements MyIterator {
	private int numOfCalls;
	private int[] arr;

	public MyArray(int[] arr) {
		this.arr = arr;
	}

	// checks if didn't reached to end of the array
	@Override
	public boolean hasNext() {
		return numOfCalls < arr.length;
	}

	// throws an exception if there no more elements otherwise return the next
	// element
	@Override
	public int next() {

		if (!hasNext())
			throw new NoSuchElementException();

		return arr[numOfCalls++];
	}

}
