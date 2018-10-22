

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
		//System.out.println(next);
		for (int i = 0; i < next; i++) {
			//System.out.println("Checking if " + publicLibrary[i].isbn + " is same as " + newEntry.toString());
			if (publicLibrary[i].equals(newEntry)) {
				//System.out.println("DUPLICATE!");
				return false;
			}
		}
		// Add book
		//System.out.println("Adding " + newEntry.toString());
		publicLibrary[next] = (Book)newEntry;
		next++;
		//System.out.println(next);
		return true;
	}
	
	@Override
	public String toString() {
		// TODO
		//Concatenate information about all books in the public library.
		String str = "";
		for (int i = 0; i < next; i++) {
			str += "Title:" + publicLibrary[i].title + "\tAuthor:" + publicLibrary[i].author + "\tYear:" + publicLibrary[i].year + "\tISBN:" + publicLibrary[i].isbn + "\n";
		}
		return str;
	}
}
