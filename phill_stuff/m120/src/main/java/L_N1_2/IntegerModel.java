package L_N1_2;

import java.util.*;

/**
 * Repräsentiert einen ganzzahligen Wert (integer).
 * Der Wert wird über die Methode setValue() gesetzt. Jede Änderung wird 
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
