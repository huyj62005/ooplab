package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    
    @Override
    public void play() {
    	System.out.println("Playing DVD: "+this.getTitle());
    	System.out.println("DVD length: "+this.getLength());
    }
    
}