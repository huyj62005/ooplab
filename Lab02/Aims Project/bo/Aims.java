package bo;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder =new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation","Roger Allers", 87,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction","George Lucas", 87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Hero", "Animation", 20.84f);
        anOrder.addDigitalVideoDisc(dvd4);
        /*bai14.a
        DigitalVideoDisc[] dvdList= {dvd1,dvd2,dvd3,dvd4};
        anOrder.addDigitalVideoDisc(dvdList);
        anOrder.addDigitalVideoDisc1(dvd1,dvd2,dvd3);
        anOrder.printCart();*/
        System.out.println("Total Cost is: " + anOrder.totalCost());
        anOrder.removeDigitalVideoDisc(dvd3);
        anOrder.printCart();
        System.out.println("Total Cost is: " + anOrder.totalCost());
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.printCart();
        System.out.println("Total Cost is: " + anOrder.totalCost());
		
        //bai16
		/*DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
     
        System.out.println("DVD 1 - ID: " + dvd1.getID() + ", Tiêu đề: " + dvd1.getTitle());
		System.out.println("DVD 2 - ID: " + dvd2.getID() + ", Tiêu đề: " + dvd2.getTitle());
		System.out.println("DVD 3 - ID: " + dvd3.getID() + ", Tiêu đề: " + dvd3.getTitle());

		System.out.println("Tổng số DVD đã tạo: " + DigitalVideoDisc.nbDigitalVideoDiscs1());*/
		 
	}
	}

