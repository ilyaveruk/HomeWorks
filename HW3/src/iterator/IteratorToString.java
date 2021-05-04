package iterator;

public class IteratorToString {
	// uses string builder to build the wanted iterator string
	public static String toString(MyIterator it) {

		StringBuilder sb = new StringBuilder();

		sb.append("[");

		while (it.hasNext())
			sb.append(it.next()).append(" ");

		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");

		return sb.toString();
	}

}
