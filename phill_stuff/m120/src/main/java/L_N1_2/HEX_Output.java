package L_N1_2;

import java.util.*;


public class HEX_Output extends OutputView {

	public HEX_Output(Observable o){
		super(o);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		outValue.setText("HEX: "+Integer.toHexString(((Integer)arg1).intValue()));
	}

}
