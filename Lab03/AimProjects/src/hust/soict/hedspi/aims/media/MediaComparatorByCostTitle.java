package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media obj1, Media obj2) {
        int result = obj1.getTitle().compareTo(obj2.getTitle());
        if (result == 0) {
            result = Float.compare(obj1.getCost(), obj2.getCost());
        }
        return result;
    }
}