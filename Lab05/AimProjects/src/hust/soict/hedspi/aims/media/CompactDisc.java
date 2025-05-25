package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, float cost,String director,int length, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
		super(title, category,cost);
		this.artist = artist;
		tracks = new ArrayList<>();
	}
    
	public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category,cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	

   
	public CompactDisc(String title, String category, float cost) {
        super(title, category,cost);
        tracks = new ArrayList<>();
    }
    // Add a track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already in list.");
        } else {
            tracks.add(track);
            System.out.println("Successfully added track!");
        }
    }

    // Remove a track
    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Succesfully removed track!");
        } else {
            System.out.println("Track not in list");
        }
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                    throw e; // propagate nếu muốn dừng CD
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }


    @Override
    public String toString() {
    	return String.format("CD - %s - %s - %s - %d: %.2f $", getTitle(), getCategory(), getArtist(), getLength(), getCost());
    }


    //  length = sum of length of all the track in the list
    public int getLength() {
        int length = 0;
        for (Track t : tracks) {
            length += t.getLength();
        }
        return length;
    }

    public String getArtist() {
        return artist;
    }

}