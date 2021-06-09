package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {

	private int[] a1, a2;
	private int reset = 0;

	public TwoArrays(int[] a1, int[] a2) {
		this.a1 = a1;
		this.a2 = a2;
	}

	@Override
	public Iterator<Integer> iterator() {

		return new TwoArrayIterator();
	}

	private class TwoArrayIterator implements Iterator<Integer> {
		private int count = 0;

		@Override
		public boolean hasNext() {

			return count < a1.length || count < a2.length;
		}

		@Override
		public Integer next() {
			if ((reset == 0 && !(count >= a1.length)) && (!(count >= a2.length))) {
				reset++;
				return a1[count];
			} else if (reset == 1 && !(count >= a2.length) && (!(count >= a2.length))) {
				reset = 0;
				return a2[count++];
			} else if (count >= a1.length)
				return a2[count++];
			return a1[count++];
		}

	}

}
