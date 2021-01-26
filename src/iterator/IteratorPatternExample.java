package iterator;

import java.util.Iterator;

interface Subjects {
//	Iterator createIterator();
	ArtsIterator createIterator();
}

class Arts implements Subjects {
	private String[] papers;

	public Arts() {
		papers = new String[] { "English", "History", "Geography", "Psychology" };
	}

	@Override
//	public Iterator createIterator() {
//		return new ArtsIterator(papers);
//	}
	public ArtsIterator createIterator() {
		return new ArtsIterator(papers);
	}
}

//interface Iterator {
//	void first();
//
//	String next();
//
//	String currentItem();
//
//	boolean hasNext();
//}

//class ArtsIterator implements Iterator {
class ArtsIterator implements Iterator<String> {
	private String[] papers;
	private int position;

	public ArtsIterator(String[] papers) {
		this.papers = papers;
		position = 0;
	}

	public void first() {
		position = 0;
	}

	@Override
	public String next() {
		return papers[position++];
	}

	public String currentItem() {
		return papers[position];
	}

	@Override
	public boolean hasNext() {
		return position < papers.length;
	}

}

public class IteratorPatternExample {

	public static void main(String[] args) {
		System.out.println("*** Iterator Pattern Demo ***");
		Subjects artsSubjects = new Arts();

//		Iterator iteratorForArts = artsSubjects.createIterator();
		ArtsIterator iteratorForArts = artsSubjects.createIterator();
		System.out.println("\n Arts subjects are as follows : ");

		while (iteratorForArts.hasNext()) {
			System.out.println(iteratorForArts.next());
		}

		iteratorForArts.first();
		System.out.println("Currently pointing back to: " + iteratorForArts.currentItem());
	}

}
