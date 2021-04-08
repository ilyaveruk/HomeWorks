package library;

public class Library {
	private Book arr[];

	public Library(int size) {
		arr = new Book[size];
		
	}

	public void setBook(int bookNum, String title, Author auth) {
		Book book = new Book(title, auth);
		arr[bookNum] = book;
	}

	public Book getBook(int bookNum) {

		if (arr[bookNum] != null)
			return arr[bookNum];
		else
			return null;

	}

}
