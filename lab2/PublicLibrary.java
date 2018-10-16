

public class PublicLibrary<T> implements Library<T> {
	public PublicLibrary(int size) {
		publicLibrary = new Book[size];
	}
	private final Book[] publicLibrary;
	private int next = 0;
	//implement methods
	public boolean add(T newEntry) {
		// TODO
		//Body to be defined. Implement this function for lab 2.
		for (Book entry : publicLibrary) {
			if (entry.equals(newEntry)) {
				return false;
			}
		}
		// Add book.
		publicLibrary[next] = (Book)newEntry;
		next++;
		return true;
	}
	
	@Override
	public String toString() {
		// TODO
		//Concatenate information about all books in the public library.
		String str = "";
		for (Book b : publicLibrary) {
			str += "Title:" + b.title + "\tAuthor:" + b.author + "\tYear:" + b.year + "\tISBN:" + b.isbn;
		}
		return str;
	}
}
