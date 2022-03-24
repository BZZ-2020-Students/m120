package n3_1;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Die Klasse TableView bringt die Daten des Modells DataModel zur Anzeige. 
 * Die Daten werden �ber das MVC-Pattern von der Model-Klasse gelesen.
 * 
 * @author Ren� Probst
 *
 */
public class TableView extends JFrame {
 
  // Deklaration der Attribute
  private JTextField cellEditor;
  private JTable table;
  private JButton button;
  private final DataModel model;

  public TableView(DataModel m){
    super("Autoliste");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    model = m;
    //
    init();
    //
    this.pack();
    this.setVisible(true);
  }
  
  private void init(){
    table = new JTable(model);
    add(new JScrollPane(table));

    button = new JButton("Add");
    button.addActionListener((e) -> new InputDialog(model));

    add(button, BorderLayout.SOUTH);


    cellEditor = new JTextField();
    cellEditor.addKeyListener(new KeyAdapter(){
      @Override
      public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
          System.out.println("neuer Wert in Spalte"+table.getEditingColumn()+" und Zeile"+table.getEditingRow());
          System.out.println("Wert = "+ table.getValueAt(table.getEditingRow(), table.getEditingColumn()));
          //
          System.out.println( ((JTextField)table.getEditorComponent()).getText());
        }
      }
    } );
    table.setDefaultEditor(Object.class, new DefaultCellEditor(cellEditor));
  }
  
  
  public static void main(String[] args){
    var list = new ArrayList<Engine>();
    list.add(new Engine("GM", 5.3f, 450));
    list.add(new Engine("Toyota", 3.0f, 300));
    var model = new DataModel(list);
    new TableView(model);
  }
  
}

class InputDialog extends JDialog {
  private JTextField[] eingabeFelder;
  private JButton okBtn, abortBtn;
  private JDialog dialog;
  
  InputDialog(DataModel model){
    this.dialog = this;
    this.setTitle("Autoliste erfassen");
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    //
    this.getContentPane().add(new JLabel("Zeile erfassen"), BorderLayout.NORTH);
    //
    eingabeFelder = new JTextField[model.getColumnCount()];
    JPanel inputPanel = new JPanel(new GridLayout(model.getColumnCount(),2));
    for (int i=0; i < model.getColumnCount(); i++){
      eingabeFelder[i] = new JTextField();
      inputPanel.add(new JLabel(model.getColumnName(i)+": "));
      inputPanel.add(eingabeFelder[i]);
    }
    this.getContentPane().add(inputPanel, BorderLayout.CENTER);
    //
    okBtn = new JButton("OK");
    okBtn.addActionListener(e -> {
      var engine = new Engine();
      engine.setHersteller(eingabeFelder[0].getText());
      engine.setHubraum(Float.parseFloat(eingabeFelder[1].getText()));
      engine.setLeistung(Integer.parseInt(eingabeFelder[2].getText()));
      model.addElement(engine);
    });
    
    abortBtn = new JButton("Abbrechen");
    abortBtn.addActionListener(e -> dialog.dispose());
    
    JPanel btnPanel = new JPanel(new GridLayout(1,2));
    btnPanel.add(abortBtn);
    btnPanel.add(okBtn);
    this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
    //
    pack();
    setVisible(true);   
  }
}
