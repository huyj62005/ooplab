package hust.soict.hedspi.Carttest;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.cart.Cart;
public class CartTest {
	public static void main(String[] args) {
		Cart cart=new Cart();
		
		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87,24.95f);
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        
        cart.printcart();
		cart.SearchByID(2);
        cart.SearchByTitle("Star Wars");
	}
}