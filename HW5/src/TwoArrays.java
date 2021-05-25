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
		private int i = 0, j = 0, holder = 0;

		@Override
		public boolean hasNext() {

			return count < a1.length + a2.length;
		}

		@Override
		public Integer next() {
			int maxTemp[] = a1.length > a2.length ? a1 : a2;
			int minTemp[] = a1.length <= a2.length ? a1 : a2;
			int minCnt=a1.length > a2.length ? j : i;
			int maxCnt = a1.length < a2.length ? j : i;
//			int i = 0, j = 1, cnt = 0;
//			Integer[] a = new Integer[a1.length + a2.length];
//
//			for (; cnt < min; i = i + 2, j = j + 2, cnt++) {
//				a[i] = a1[cnt];
//				a[j] = a2[cnt];
//			}
//
//			for (j--; j < a.length; j++, cnt++)
//				if (a2.length == max)
//					a[j] = a2[cnt];
//				else
//					a[j] = a1[cnt];
//
//			return a[count++];
//-----------------------------------------------------------------
//
//
//			while (count < min + max ) {
//
//				if (count % 2 == 0 && i<a1.length) {
//					count++;
//					holder = a1[i++];
//					return holder;
//				}
//
//				if (count % 2 != 0 && j < a2.length) {
//					count++;
//					holder = a2[j++];
//					return holder;
//				}
//				
//			
//				if(i == a1.length && j<a2.length) {
//					holder=a2[j++];
//				return holder;
//				}
//				
//				break;
//				
//			}
//			//need to break the loop and not return null and check if a1 longer length;
//			return return a2[a2.length-1];	
//------------------------------------------------------------------------------

			for (; count < minTemp.length + maxTemp.length; count++) {

				if (count % 2 == 0 && minCnt < minTemp.length) {
					count++;
					holder = minTemp[i++];
					return holder;
				}
				if (count % 2 != 0 && maxCnt < maxTemp.length) {
					count++;
					holder = maxTemp[j++];
					return holder;
				}
				if (minCnt == minTemp.length && maxCnt < maxTemp.length- minTemp.length) {
					holder = maxTemp[j++];
					return holder;
				}

			}

			return maxTemp[maxTemp.length - 1];

		}
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 4 };
		int[] a2 = { 100,101,102,103,104,105,106,107,108,109};

		TwoArrays aa = new TwoArrays(a1, a2);
		for (int i : aa)
			System.out.print(i + " ");

	}

}
