package iterator;

public class Fibonacci implements MyIterator {

	private int upperBound;
	private int previousNumber = 1, nextNumber = 1, current, count;

	// constructor
	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
	}

	// checks if has next
	@Override
	public boolean hasNext() {
		return nextNumber + previousNumber < upperBound;
	}

	@Override
	public int next() {
		// checks the if the number didn't reach the upper bound
		if (hasNext() && count >= 2) {
			current = nextNumber + previousNumber;
			nextNumber = previousNumber;
			previousNumber = current;
			count++;
			return current;
		} else if (count == 0) {
			count++;
			return nextNumber;
		}

		count++;
		return previousNumber;

	}

}
