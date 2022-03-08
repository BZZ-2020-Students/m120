package M1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerDemo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2488889547100219311L;
	private JButton btnOne, btnTwo, btnThree;
	private String actionBtnThree = "Schaltfl�che 3";
	
	public ListenerDemo(){
		super("Beispiele f�r Listner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		init();
		//
		this.pack();
		this.setVisible(true);
	}
	
	private void init(){
		JPanel btnPanel = new JPanel(new GridLayout(3,1));
		btnOne   = new JButton("Schatlfl�che 1");
		btnTwo   = new JButton("Schaltfl�che 2");
		btnThree = new JButton(actionBtnThree);
		//
		btnPanel.add(btnOne);
		btnPanel.add(btnTwo);
		btnPanel.add(btnThree);
		this.getContentPane().add(btnPanel, BorderLayout.CENTER);
		//
		/*
		 * Listener 1
		 * Ist als externe Klasse zu erstellen und der Schaltfl�che btnOne zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnOne.addActionListener(new ListenerInterfaceDemo());
		
		/*
		 * Listener 2 ist als Elementklasse zu erstellen und der Schaltfl�che btnTwo zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnTwo.addActionListener(new Elementklasse());
		
		/*
		 * Listener 3 ist als anonyme Klasse zu erstellen und der Schaltfl�che btnThree zuzuordnen.
		 * Es ist der Text der Beschriftung im StdOut auszugeben.
		 * 
		 */
		btnThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(btnThree.getText());
			}
		});
		
		
	}

	class Elementklasse implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(btnTwo.getText());
		}
	}
	public static void main(String[] args){
		new ListenerDemo();
	}
	
}
