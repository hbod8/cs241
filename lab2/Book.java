

public class Book {
	public Book(String title, String author, int year, String isbn) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
	}
	String title;
	String author;
	int year;
	String isbn;
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book bookObj = (Book)obj;
			if (bookObj.isbn.equals(isbn)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
