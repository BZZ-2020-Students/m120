package aNzweiEins;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Die Klasse MVCView stellt eine Graphik-Komponente gem?ss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten f?r die Liste werden aus der Model-Klasse
 * Model gelesen. Dazu implementiert die Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 *
 * Die JList kann zur Laufzeit um weitere Eintr?ge (Item) erweitert werden. Dazu
 * dient eine Schaltfl?che [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * best?tigt wird.
 * Der Eintrag wird dann dem Model ?bergeben (?ber die definierte Schnittstelle von
 * DefaultListModel).
 * Danach wird die Eingabe wieder ausgeblendet.
 *
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Contoll-Komponenten sind hier als anonyme Klassen in der MVCView integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der MVCView, w?hrend
 * der KeyListener das Model ?ber mit neuen Daten versorgt.
 *
 * @author Ren? Probst
 *
 */
public class MVCView extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1659560662167244636L;
    /* deklarieren Sie hier alle ben?tigten Graphik-Komponenten sowie
     * die Referenz zum Daten-Model.
     * do it
     */
    private JList<String>     		  viewComponent;
    private DefaultListModel<String>  model;
    private JButton           		  addItem;
    private JTextField        		  inputValue;

    public MVCView(DefaultListModel<String> m){
        super("MVCView-Komponente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        model = m;
        //
        init();
        //
        pack();
        setVisible(true);
    }


    private void init(){
        /*
         * Erstellen Sie die Liste. Legen Sie diese in einer JScrollPane ab.
         * Diese platzieren Sie dann im Zentrum des Frames.
         * do it
         */
        viewComponent = new JList<String>(model);
        JScrollPane scroller = new JScrollPane(viewComponent);
        this.getContentPane().add(scroller, BorderLayout.CENTER);
        //
        /*
         * Erstellen Sie die Schaltfl?che [add Item]. Legen Sie diese in einem
         * JPanel im Osten ab. Dieses Panel legen Sie dann im S?den des Frames ab.
         * F?gen Sie einen ActionListener zu. Er ruft die onAddItem()-Methode auf.
         * do it
         */
        addItem = new JButton("add Item");
        JPanel btnPanel = new JPanel(new BorderLayout());
        btnPanel.add(addItem, BorderLayout.EAST);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        addItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                onAddItem();
            }
        });
        //
        /*
         * Erstellen Sie ein Textfeld f?r die Eingabe neuer Items.
         * Das Textfeld ist zu Beginn unsichtbar. Es wird erst ?ber [add Item] eingeblendet.
         * Das Textfeld legen Sie im Norden des Frames ab.
         * F?gen Sie einen KeyAdapter zu. Er ruft die onEnter()-Methode auf.
         * do it
         */
        inputValue = new JTextField(10);
        inputValue.setVisible(false);
        this.getContentPane().add(inputValue, BorderLayout.NORTH);

        inputValue.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub
                onEnter(arg0);
            }
        });
    }


    /**
     * Die Methode wird beim Klicken auf die Schaltfl?che [add Item] aufgerufen.
     * Sie blendet das Textfeld ein und setzt den Fokus f?r die Werteingabe.
     */
    private void onAddItem(){
        inputValue.setVisible(true);
        pack();
        this.repaint();
        inputValue.requestFocus();
    }


    /**
     * Die Methode pr?ft das eingegeben Zeichen auf ENTER.
     * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
     * Nun wird dem Datenmodel der neue Wert ?bermittelt und danach der Wert gel?scht.
     * @param event
     */
    private void onEnter(KeyEvent event){
        if (event.getKeyChar() == KeyEvent.VK_ENTER){
            System.out.println("ENTER");
            inputValue.setVisible(false);
            pack();
            this.repaint();
            viewComponent.requestFocus();
            // Hier dem Daten-Model den Wert des Textfeldes ?bergeben
            // do it
            model.addElement(inputValue.getText());
            //
            inputValue.setText("");
        }
    }

    public static void main(String[] args){
        System.out.println("Demo zu MVC mit JList");
        Model m = new Model();
        new MVCView(m);
    }
}
