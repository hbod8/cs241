

public class PublicLibrary<T> implements Library<T> {
	public PublicLibrary(int size) {
		Book[] bArr = new Book[size];
		publicLibrary = (T[])bArr;
	}
	private final T[] publicLibrary;
	//implement methods
	public boolean add(T newEntry) {
		// TODO
		//Body to be defined. Implement this function for lab 2.
		for (T entry : publicLibrary) {
			if (entry.equals(newEntry)) {
				return false;
			}
		}
		// Add book.
		return true;
	}
	
	@Override
	public String toString() {
		// TODO
		//Concatenate information about all books in the public library.
	}
}
