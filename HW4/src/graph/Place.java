package graph;

public class Place {

	private int x, y;

	public Place(int x, int y, int bound) {
		if (x < 0 || x >= bound || y < 0 || y >= bound)
			throw new IllegalArgumentException();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object obj) {
		Place point = (Place) obj;
		return point.getX() == x && point.getY() == y;
	}

	@Override
	public int hashCode() {
		final int p = 31;
		int result = 1;
		result = p * result + x;
		result = p * result + y;
		return result;

	}

	@Override
	public String toString() {
		return String.format("(%d , %d)", x, y);
	}

}
