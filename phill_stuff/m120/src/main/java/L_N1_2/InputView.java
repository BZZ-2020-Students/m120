package L_N1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Diese Klasse stellt das GUI für die Werteingabe der Anwendung bereit.
 * Als Controller wird ein KeyListener-Objekt instanziert.
 * 
 * Damit der Controller auf die Daten der Komonente zugreifen kann, wird die
 * Schnittstellenfunktion getText() angeboten.
 */
public class InputView extends JFrame{
	private JTextField   inputField;
	private IntegerModel model;
	
	public InputView(IntegerModel m){
		super("Werteinagbe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		model = m;
		
		init();
		
		pack();
		setVisible(true);
		inputField.requestFocusInWindow();
	}
	
	private void init(){
		// Hinweistext
		JTextArea info = new JTextArea(3,35);
		info.setEditable(false);
		info.setLineWrap(true);
		info.setText("Geben Sie hier eine Zahl ein. Sie wird in den Ausgabefenstern \nin Hex, Bin und Dec ausgegeben.\nBestätigen Sie die Eingabe mit ENTER");
		this.getContentPane().add(info, BorderLayout.NORTH);
		// Eingabe
		inputField = new JTextField(10);
		JPanel inputPanle = new JPanel(new BorderLayout());
		inputPanle.add(inputField, BorderLayout.SOUTH);
		this.getContentPane().add(inputPanle, BorderLayout.EAST);
		
		inputField.addKeyListener(new InputController(this, model));
	}
	
	/**
	 * Liefert den Wert der Eingabe und löscht dann das Feld.
	 * @return
	 */
	public String getText(){
		String s = inputField.getText();
		inputField.setText("");
		return s;
	}
	
	
}
