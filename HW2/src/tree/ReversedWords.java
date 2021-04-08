package tree;

import java.util.Scanner;

public class ReversedWords {

	public static int checkReversed() {

		int count = 0;
		Node word = new Node();
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		while (!str.equals("X")) {
			String temp = "";

			for (int i = str.length() - 1; i >= 0; i--)
				temp += str.charAt(i);

			if (word.num(temp) > 0)
				count++;

			word.add(str);
			str = scanner.next();
		}

		scanner.close();
		return count;
	}

}
