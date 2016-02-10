package ch.csbe.hotel;

import ch.csbe.hotel.model.Doppelzimmer;
import ch.csbe.hotel.model.Einzelzimmer;
import ch.csbe.hotel.model.Hotel;

public class HotelApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel h = new Hotel();
		h.getDoppelzimmer().add(new Doppelzimmer());
		h.getDoppelzimmer().get(0).setAnzahlBett(4);
		h.getDoppelzimmer().add(new Doppelzimmer());
		h.getEinzelzimmer().add(new Einzelzimmer());
		
		for(Doppelzimmer dz : h.getDoppelzimmer()){
			System.out.println(dz.toString());
			System.out.println(dz.getAnzahlBett());
		}
		
		for(Einzelzimmer dz : h.getEinzelzimmer()){
			System.out.println(dz.toString());
		}

	}

}
