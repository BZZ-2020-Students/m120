package N3_1;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_ENTER;

/**
 * Die Klasse TableView bringt die Daten des Modells DataModel zur Anzeige. 
 * Die Daten werden �ber das MVC-Pattern von der Model-Klasse gelesen.
 * 
 * @author Ren� Probst
 *
 */
public class TableView extends JFrame {
 
  private JTextField cellEditor;
  private DataModel model;
  private JTable table;
  private JButton button;

  public TableView(DataModel m){
      super("Autoliste");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      model = m;
      init();
      this.pack();
      this.setVisible(true);
    }

    private void init(){
      table = new JTable(model);
      ColorTable ct = new ColorTable();
      ct.getTableCellRendererComponent(table,model,true, false, table.getColumnCount(), table.getRowCount());
      add(new JScrollPane(table));

      button = new JButton("Add");
      button.addActionListener((e) -> new InputDialog(model));

      add(button, BorderLayout.SOUTH);


      cellEditor = new JTextField();
      cellEditor.addKeyListener(new KeyAdapter(){
        @Override
        public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == VK_ENTER){
            System.out.println("neuer Wert in Spalte"+table.getEditingColumn()+" und Zeile"+table.getEditingRow());
            System.out.println("Wert = "+ table.getValueAt(table.getEditingRow(), table.getEditingColumn()));
            //
            System.out.println( ((JTextField)table.getEditorComponent()).getText());
          }
        }
      } );
   }
  //Main method
    public static void main(String[] args){
      ArrayList<DataClass> list = new ArrayList<DataClass>();
      list.add(new DataClass("VW", 2.4f, 155));
      list.add(new DataClass("Opel", 1.3f, 90));
      list.add(new DataClass("Toyota", 2.0f, 130));
      list.add(new DataClass("Fiat", 1.2f, 75));
      DataModel model = new DataModel(list);
      new TableView(model);
    }

  }

  //Creates the input dialog
  class InputDialog extends JDialog {
    private JTextField[] eingabeFelder;
    private JButton okBtn, abortBtn;
    private JDialog dialog;

    InputDialog(DataModel model){
      this.dialog = this;
      this.setTitle("Autoliste erfassen");
      this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      this.getContentPane().add(new JLabel("Zeile erfassen"), BorderLayout.NORTH);
      eingabeFelder = new JTextField[model.getColumnCount()];
      JPanel inputPanel = new JPanel(new GridLayout(model.getColumnCount(),2));
      for (int i=0; i < model.getColumnCount(); i++){
        eingabeFelder[i] = new JTextField();
        inputPanel.add(new JLabel(model.getColumnName(i)+": "));
        inputPanel.add(eingabeFelder[i]);
      }
      this.getContentPane().add(inputPanel, BorderLayout.CENTER);
      okBtn = new JButton("OK");
      okBtn.addActionListener(e -> {
        DataClass dataClass = new DataClass();
        dataClass.setHersteller(eingabeFelder[0].getText());
        dataClass.setHubraum(Float.parseFloat(eingabeFelder[1].getText()));
        dataClass.setLeistung(Integer.parseInt(eingabeFelder[2].getText()));
        model.addElement(dataClass);
        dispose();
      });

      abortBtn = new JButton("Abbrechen");
      abortBtn.addActionListener(e -> dialog.dispose());

      JPanel btnPanel = new JPanel(new GridLayout(1,2));
      btnPanel.add(abortBtn);
      btnPanel.add(okBtn);
      this.getContentPane().add(btnPanel, BorderLayout.SOUTH);
      pack();
      setVisible(true);
    }
}
