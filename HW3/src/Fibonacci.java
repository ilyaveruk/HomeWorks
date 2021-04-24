
public class Fibonacci implements MyIterator {

	private int upperBound;
	int previousNumber = 1, nextNumber = 1, current, count;

	public Fibonacci(int upperBound) {
		this.upperBound = upperBound;
	}

	@Override
	public boolean hasNext() {
		return nextNumber + previousNumber < upperBound;
	}

	@Override
	public int next() {

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
