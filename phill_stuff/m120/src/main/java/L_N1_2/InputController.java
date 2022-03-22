package L_N1_2;

import java.awt.event.*;
import javax.swing.*;

/*
 * Der Controller wird �ber Schnittstelle des KeyListener aktiviert.
 * Sobald der Zeichencode f�r ENTER erkannt wird, liest der Controller
 * bei der graphischen Komponente den Text aus - �ber getText(). 
 * Danach wird gepr�ft, ob es sich um eine korrekte Zahlendarstellung
 * handelt, wenn nicht, erfolgt eine Fehlermeldung.
 * Ist der Wert korrekt, wird er dem Model �bermittelt - �ber setValue()
 */
public class InputController  extends KeyAdapter{

	private InputView view;
	private IntegerModel model;
	
	public InputController(InputView v, IntegerModel m){
		view = v;
		model = m;
	}
	
	/*
	 * Die Methode pr�ft die Zeichen auf ENTER.
	 * Dann liest Sie den Wert aus der graphischen Komponente und pr�ft diesen
	 * auf die korrekte Interpretation eines Zahlenwertes.
	 * Ist der Wert i.O. wird er dem Model geliefert. Sonst wird eine Fehlermeldung generiert.
	 */
	public void keyTyped(KeyEvent ke){
		if (ke.getKeyChar() == KeyEvent.VK_ENTER){
			String s = view.getText();
			try{
				model.setValue(Integer.valueOf(s).intValue());
			}
			catch(NumberFormatException nf){
				JOptionPane.showMessageDialog(view, "Bitte geben Sie eine korrekte Zahl ein!", "FEHLER", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
