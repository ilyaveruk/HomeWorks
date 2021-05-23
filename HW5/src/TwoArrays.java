
import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {

	private int[] a1, a2;

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

			return count < a1.length + a2.length;
		}

		@Override
		public Integer next() {

			int min = Math.min(a1.length, a2.length);
			int max = Math.max(a1.length, a2.length);
			int i = 0, j = 1, cnt = 0;
			Integer[] a = new Integer[a1.length + a2.length];

			for (; cnt < min; i = i + 2, j = j + 2, cnt++) {
				a[i] = a1[cnt];
				a[j] = a2[cnt];
			}

			for (j--; j < a.length; j++, cnt++)
				if (a2.length == max)
					a[j] = a2[cnt];
				else
					a[j] = a1[cnt];

			return a[count++];
		}

	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4 };
		int[] a2 = { 100, 101, 102, 103, 104, 105, 106 };

		TwoArrays aa = new TwoArrays(a1, a2);
		for (int i : aa)
			System.out.print(i + " ");

	}
}
