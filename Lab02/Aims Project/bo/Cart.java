package bo;

import java.util.ArrayList;
public class Cart {

	public static final int MAX_NUMBERSS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
				new DigitalVideoDisc[MAX_NUMBERSS_ORDERED];
	private int qtyOrdered =0;
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered <= MAX_NUMBERSS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
				System.out.println("The cart is almost full");
			}
			
		}
	//bai14.a
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc dvd : dvdList) {
			addDigitalVideoDisc(dvd);
		}
	}
	public void addDigitalVideoDisc1(DigitalVideoDisc... dvds) {
	    for (DigitalVideoDisc dvd : dvds) {
	        addDigitalVideoDisc(dvd);
	    }
	}
	//bai14.b
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean check=false;
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered[i].equals(disc)) {
				check=true;
				for(int j=i;j<qtyOrdered-1;j++) {
					itemsOrdered[j]=itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered-1]=null;
				qtyOrdered--;
				System.out.println("This disc has been removed");
				break;
				
			}
			
		}
		
	}
	public float totalCost() {
		float cost=0;
		for(int i=0;i<qtyOrdered;i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
	public void printCart() {
		for(int i=0;i<qtyOrdered;i++) {
			System.out.printf("%-3d %-16s %6f\n", i+1,itemsOrdered[i].getTitle(),itemsOrdered[i].getCost());
		}
	}
		
}
	