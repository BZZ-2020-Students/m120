package L_N1_2;

import java.util.*;

/**
 * Repr�sentiert einen ganzzahligen Wert (integer).
 * Der Wert wird �ber die Methode setValue() gesetzt. Jede �nderung wird 
 * dann allen angemeldeten Observer-Objekten mitgeteilt.
 *
 */
public class IntegerModel extends Observable{
	
	private int value;
	
	public IntegerModel(){
		value = 0;
	}
	
	public void setValue(int value){
		this.value = value;
		this.setChanged();
		this.notifyObservers(new Integer(this.value));
	}

}
