package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		Store str = new Store();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		/*str.addDVD123(dvd1);
		str.addDVD123(dvd2);
		str.addDVD123(dvd3);
		str.printDVD();

		str.removeDVD(dvd1);
		str.removeDVD(dvd2);
		str.printDVD();*/

	}
}
