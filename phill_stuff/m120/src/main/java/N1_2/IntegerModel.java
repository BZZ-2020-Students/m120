package N1_2;

import java.util.Observable;

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
