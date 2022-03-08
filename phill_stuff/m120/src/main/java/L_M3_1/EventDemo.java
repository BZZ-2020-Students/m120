package L_M3_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class EventDemo extends JFrame{

	private JButton btnOne, btnTwo;
	private JTextField userInput;
	private JTextArea  userOutput;
	private Color actualBtnColor;
	private JList<String> liste;
	
	public EventDemo(){
		super("Beispiele für Eventhandling");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		init();
		//
		this.pack();
		this.setVisible(true);
	}
	
	private void init(){
		/*----------------------------------------*/
		// Eine Schaltfläche mit Actionhandler
		btnOne = new JButton("toggle color");
		btnOne.setBackground(Color.GREEN);
		btnOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				onClick();
			}
		});
		JPanel btnOnePanel = new JPanel(new BorderLayout());
		JPanel btnPanel    = new JPanel(new BorderLayout());
		btnOnePanel.add(btnOne, BorderLayout.SOUTH);
		btnPanel.add(btnOnePanel, BorderLayout.WEST);
		/*----------------------------------------*/
		// Eine Schaltfläche mit Mousehandler
		btnTwo = new JButton("mouse over color");
		btnTwo.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				onMouseEnter();
			}
			public void mouseExited(MouseEvent e){
				onMouseExit();
			}
		});
		JPanel btnTwoPanel = new JPanel(new BorderLayout());
		btnTwoPanel.add(btnTwo, BorderLayout.SOUTH);
		btnPanel.add(btnTwoPanel, BorderLayout.EAST);
		/*----------------------------------------*/
		// Ein Textfeld mit Keyhandler...
		userInput = new JTextField(40);
		userInput.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				onEnter(ke);
			}
		});
		//...und Fokushandler
		userInput.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent e){
				onFocusGained();
			}
			public void focusLost(FocusEvent e){
				onFocusLost();
			}
		});
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputPanel.add(userInput, BorderLayout.EAST);
		inputPanel.add(new JLabel("Hier Text eingeben:"), BorderLayout.WEST);
		// TextArea für die Ausgabe (aus TextFeld)
		userOutput = new JTextArea(5,40);
		JScrollPane outScrollPane = new JScrollPane(userOutput);
		/*----------------------------------------*/
		// Eine Listbox für Listhandler
		String[] data = {"one", "two", "three", "four"};
		liste = new JList<String>(data);
		liste.setFixedCellWidth(100);
		liste.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				onListSelection(e);
			}
		});
		JScrollPane listScrollPane = new JScrollPane(liste);
		
		/*----------------------------------------*/
		this.getContentPane().setBounds(5, 5, 5, 5);
		this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
		this.getContentPane().add(inputPanel, BorderLayout.NORTH);
		this.getContentPane().add(outScrollPane, BorderLayout.CENTER);
		this.getContentPane().add(listScrollPane, BorderLayout.EAST);
	}
	
	
/* Actionevent*/
	private void onClick(){
		if (btnOne.getBackground() == Color.GREEN)
			btnOne.setBackground(Color.CYAN);
		else
			btnOne.setBackground(Color.GREEN);
	}
	
/* MouseEvent */
	private void onMouseEnter(){
		actualBtnColor = btnTwo.getBackground();
		btnTwo.setBackground(Color.WHITE);
	}
	
	private void onMouseExit(){
		btnTwo.setBackground(actualBtnColor);
	}
	
	public static void main(String[] args){
		new EventDemo();
	}
	
/* KeyEvent */
	private void onEnter(KeyEvent ke){
		//System.out.println(ke.getKeyChar());
		if (ke.getKeyCode() == KeyEvent.VK_ENTER){
			userOutput.append(userInput.getText()+"\n");
			userInput.setText("");
		}
	}
	
/* FocusEvent */
	public void onFocusGained(){
		System.out.println("Fokus auf Textfeld");
	}
	
	public void onFocusLost(){
		System.out.println("Fokus von Textfeld entfernt");
	}

/* ListselectionEvent */
	private void onListSelection(ListSelectionEvent e){
		System.out.println(liste.getSelectedIndex());
	}
	
}
