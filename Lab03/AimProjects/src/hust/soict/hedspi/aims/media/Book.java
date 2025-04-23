package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost,ArrayList<String>authors) {
        super(title, category, cost);
        this.authors=authors;    
        }
   
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author " + authorName + " already exists");
		}
		else {
			authors.add(authorName);
			System.out.println("Author " + authorName + " is add to the authors list");
		}
	}
		
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName + " is removed ");
		}
		else {
			System.out.println("Author " + authorName + " is not in the authors list");
		}
	}
	
	@Override
	public String toString() {
		return "BOOK - " + this.getTitle()+" - "+ this.getCategory()
				+ " : "+ this.getCost() + " $";
	}
}