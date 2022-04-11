package N3_1;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse TableView bringt die Daten des Modells DataModel zur Anzeige. Die
 * Daten werden �ber das MVC-Pattern von der Model-Klasse gelesen.
 * 
 * @author Ren� Probst
 *
 */
public class TableView extends JFrame {

	// Deklaration der Attribute
	private JTextField cellEditor;
	private TableModel model;
	private JButton newBtn;
	private JTable table;

	public TableView(TableModel m) {
		super("Autoliste");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = m;
		//
		init();
		//
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		// Tabelle erstellen und in Contentpane ablegen
		table = new JTable(model);
		this.add(new JScrollPane(table));

		// Schaltfl�che
		newBtn = new JButton("Zeile zufügen");
		this.add(newBtn, BorderLayout.SOUTH);
		newBtn.addActionListener((ae) -> {
			new InputDialog(model);
		});
	}

	public static void main(String[] args) {
		DataModel m = new DataModel();
		new TableView(m);
	}

}

class InputDialog extends JDialog {

	private JTextField[] eingabeFelder;
	private JButton okBtn, abortBtn;
	private JDialog dialog;

	InputDialog(TableModel model) {
		this.dialog = this;
		this.setTitle("Autoliste erfassen");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//
		this.getContentPane().add(new JLabel("Zeile erfassen"), BorderLayout.NORTH);
		//
		eingabeFelder = new JTextField[model.getColumnCount()];
		JPanel inputPanel = new JPanel(new GridLayout(model.getColumnCount(), 2));
		for (int i = 0; i < model.getColumnCount(); i++) {
			eingabeFelder[i] = new JTextField();
			inputPanel.add(new JLabel(model.getColumnName(i) + ": "));
			inputPanel.add(eingabeFelder[i]);
		}
		this.getContentPane().add(inputPanel, BorderLayout.CENTER);
		//
		okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataModel dm = (DataModel) model;
				dm.addRow(new DataClass(eingabeFelder[0].getText(), Float.parseFloat(eingabeFelder[1].getText()),
						Integer.parseInt(eingabeFelder[2].getText())));
				eingabeFelder[0].setText("");
				eingabeFelder[1].setText("");
				eingabeFelder[2].setText("");
			}
		});

		abortBtn = new JButton("Abbrechen");
		abortBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});

		JPanel btnPanel = new JPanel(new GridLayout(1, 2));
		btnPanel.add(abortBtn);
		btnPanel.add(okBtn);
		this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
		//
		pack();
		setVisible(true);
	}
}
