package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media obj1, Media obj2) {
        int result = Float.compare(obj1.getCost(), obj2.getCost());
        if (result == 0) {
            result = obj1.getTitle().compareTo(obj2.getTitle());
        }
        return result;
    }
}