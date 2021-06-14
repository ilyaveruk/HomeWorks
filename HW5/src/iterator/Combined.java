package iterator;


import java.util.Iterator;
;

public class Combined<E> implements Iterable<E> {

	private Iterator<E> first;
	private Iterator<E> second;
	private int set = 0;

	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first = first.iterator();
		this.second = second.iterator();
	}

	@Override
	public Iterator<E> iterator() {
		return new CombinedIterator();
	}

	public class CombinedIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return (first.hasNext() || second.hasNext());
		}

		@Override
		public E next() {
			if ((set == 0 && first.hasNext() && second.hasNext())) {
				set++;
				return first.next();
			} else if (set == 1 && first.hasNext() && second.hasNext()) {
				set = 0;
				return second.next();
			} else if (!(first.hasNext()))
				return second.next();
			return first.next();
		}
	}

}
