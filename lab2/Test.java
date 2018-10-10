public class Test {
	public static void main(String[] args) {
		PublicLibrary pl = new PublicLibrary(5);
		Book b1 = new Book("Winnie the pooh", "A. A. Milne", 1926, "ABCDEFGHIJ");
		Book b2 = new Book("The Polor Express", "Chis van Allsburg", 1984, "1234567890");
		Book b3 = new Book("The little engine that could", "Platt and mink", 1930, "ABCDEF7890");
		Book b4 = new Book("Winnie the pooh", "A. A. Milne", 1926, "ABCDEFGHIJ");
		System.out.println("Adding books.");
		System.out.println("Adding " + b1.title + ":" + pl.add(b1));
		System.out.println("Adding " + b2.title + ":" + pl.add(b2));
		System.out.println("Adding " + b3.title + ":" + pl.add(b3));
		System.out.println("Adding " + b4.title + ":" + pl.add(b4));
		System.out.println("Library now has:" + pl.toString());
	}
}
