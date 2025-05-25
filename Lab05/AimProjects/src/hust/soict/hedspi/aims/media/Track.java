package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing track: " + this.getTitle());
	    } else {
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;
        return this.title.equals(other.getTitle()) && this.length == other.getLength();
    }

}
