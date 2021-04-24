

public class Fibonacci implements MyIterator{
	
	private int upperBound;
	int fib1=1, fib2=1,current;
	
	public Fibonacci(int upperBound) {
		this.upperBound=upperBound;
	}
	
	@Override
	public boolean hasNext() {
		return current < upperBound;
	}
	
	@Override
	public int next() {
		
		if(!hasNext())
			return current;
		
		current=fib1;
		fib1=fib2;
		fib2=fib1+current;
		
		return current;
	}

}
