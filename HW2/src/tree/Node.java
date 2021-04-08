package tree;

public class Node {
	private int count;
	private Node[] children = new Node['z' - 'a' + 1]; // children[26]

	public int num(String s) {

		if (s.isEmpty())
			return count;

		char tempChar = s.charAt(0);

		if (children['z' - tempChar] == null)
			return 0;

		return children['z' - tempChar].num(s.substring(1));

	}

	public void add(String s) {

		if (s.isEmpty()) {
			count++;
			return;
		}

		char tempChar = s.charAt(0);
		

		if (children['z' - tempChar] == null)
			children['z' - tempChar] = new Node();

		children['z' - tempChar].add(s.substring(1));

	}

}
