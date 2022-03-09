package L_M1_1;

import java.awt.event.*;
public class MyListener implements ActionListener {

	public void actionPerformed(ActionEvent ae){
		System.out.println(ae.getActionCommand());
	}
}
