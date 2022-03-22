package L_N1_2;

import java.util.Observable;


public class DEC_Output extends OutputView {

		public DEC_Output(Observable o){
			super(o);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			outValue.setText("DEC: "+ arg1);
		}

	}