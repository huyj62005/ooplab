package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaToStringTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();


        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);


        // Create a CD with tracks
        ArrayList<Track> cdTracks = new ArrayList<>();
        cdTracks.add(new Track("Billie Jean", 357));
        cdTracks.add(new Track("Beat It", 258));

        CompactDisc cd = new CompactDisc("Thriller", "Pop", 12.99f, "Michael Jackson", cdTracks
        );

        //Create a Book with authors
        ArrayList<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Robert C. Martin");

        Book book = new Book("Clean Code", "Programming", 29.99f, bookAuthors);

        // Add all media to the list
        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for(Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}