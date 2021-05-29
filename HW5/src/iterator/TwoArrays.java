package iterator;

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
		private int i = 0, j = 0;
		private Integer holder = 0;

		@Override
		public boolean hasNext() {

			return count < a1.length + a2.length;
		}

		@Override
		public Integer next() {
			int maxTemp[] = a1.length > a2.length ? a1 : a2;
			int minTemp[] = a1.length <= a2.length ? a1 : a2;
			int totalLength = maxTemp.length + minTemp.length;

			if (a2.length >= a1.length) {
				for (; count < totalLength; count++) {

					if (count % 2 == 0 && i < minTemp.length) {
						count++;
						holder = minTemp[i++];
						return holder;
					}
					if (count % 2 != 0 && j < maxTemp.length - 1) {
						count++;
						holder = maxTemp[j++];
						return holder;
					}

					if (i == minTemp.length && j <= maxTemp.length - 2) {
						holder = maxTemp[j++];
						return holder;
					}

				}

			} else {
				for (; count < totalLength; count++) {

					if (count % 2 == 0 && i < maxTemp.length) {
						count++;
						holder = maxTemp[i++];
						return holder;
					}
					if (count % 2 != 0 && j < minTemp.length) {
						count++;
						holder = minTemp[j++];
						return holder;
					}

					if (j == minTemp.length && i <= maxTemp.length - 2) {
						holder = maxTemp[i++];
						return holder;
					}

				}

			}
			return maxTemp[maxTemp.length - 1];
		}

	}

}
