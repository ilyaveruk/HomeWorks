package iterator;
import java.util.Iterator;

public class Combined<E> implements Iterable<E> {
	
	
	private Iterable<E> first , second;
	
	public Combined(Iterable<E> first, Iterable<E> second) {
		this.first=first;
		this.second=second;
	}

	@Override
	public Iterator<E> iterator() {
		
		return null;
	}
	
	
	
	

}
