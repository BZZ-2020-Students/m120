package N1_2;

import L_N1_2.OutputView;

import java.util.Observable;


public class BIN_Output extends OutputView {

		public BIN_Output(Observable o){
			super(o);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			outValue.setText("BIN: "+Integer.toBinaryString(((Integer)arg1).intValue()));
		}

	}
