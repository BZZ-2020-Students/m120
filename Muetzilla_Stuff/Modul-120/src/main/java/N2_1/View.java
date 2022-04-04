package N2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Die Klasse View stellt eine Graphik-Komponente gem�ss MVC-Pattern bereit.
 * Es handelt sich um eine JList. Die Daten f�r die Liste werden aus der Model-Klasse
 * Model gelesen. Dazu implementiert die Model-Klasse das Interface ListModel bzw.
 * die Komfort-Klasse DefaultListModel.
 * Hier wird auf ein entsprechendes Objekt referenziert.
 * <p>
 * Die JList kann zur Laufzeit um weitere Eintr�ge (Item) erweitert werden. Dazu
 * dient eine Schaltfl�che [add Item]. Diese blendet dann oberhalb der Liste
 * ein Textfeld ein, in welchem die Eingabe vorgenommen und mit der ENTER-Taste
 * best�tigt wird.
 * Der Eintrag wird dann dem Model �bergeben (�ber die definierte Schnittstelle von
 * DefaultListModel).
 * Danach wird die Eingabe wieder ausgeblendet.
 * <p>
 * Mittels MVC-Mechanismus wird dann die Liste um den neuen Wert erweitert.
 * Die Contoll-Komponenten sind hier als anonyme Klassen in der View integriert.
 * Der ActionListener steuert dabei die Kommunikation mit der View, w�hrend
 * der KeyListener das Model mit neuen Daten versorgt.
 *
 * @author Ren� Probst
 */
public class View extends JFrame {

    /* deklarieren Sie hier alle ben�tigten Graphik-Komponenten
     * - Liste        (muss viewComponent heissen)
     * - Schaltfl�che (beliebiger Name)
     * - Textfeld     (muss inputValue heissen)
     * sowie die Referenz (muss model heissen) zum Daten-Model.
     *
     * do it
     */
    private JList<String> viewComponent;
    private JButton addButton;
    private TextField inputValue;
    private Model model;
    private String filepath = "src/main/java/N2_1/hobbys.csv";


    /**
     * Konstruktor
     */
    public View(DefaultListModel<String> m) {
        super("View-Komponente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        model = (Model) m;
        //
        init();
        //
        pack();
        setVisible(true);
    }


    private void init() {
        setLayout(new BorderLayout());

        /*
         * Erstellen Sie die Liste. Legen Sie diese in einer JScrollPane ab.
         * Diese platzieren Sie dann im Zentrum des Frames.
         *
         * do it
         */
        viewComponent = new JList<>(model);
        JScrollPane jsp = new JScrollPane(viewComponent);
        add(jsp, BorderLayout.CENTER);


        /*
         * Erstellen Sie die Schaltfl�che [add Item]. Legen Sie diese in einem
         * JPanel im Osten ab. Dieses Panel legen Sie dann im S�den des Frames ab.
         * F�gen Sie einen ActionListener als anonyme Klasse zu.
         * Er ruft die onAddItem()-Methode auf.
         *
         * do it
         */
        addButton = new JButton("Add value");
        addButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            //export
            ExportFile export = new ExportFile(filepath, (ArrayList<String>) new ArrayList<String>(model.getData()));
            export.writeInCsvFile();
          }
        });
        add(addButton, BorderLayout.SOUTH);


        /*
         * Erstellen Sie ein Textfeld f�r die Eingabe neuer Items.
         * Das Textfeld ist zu Beginn unsichtbar. Es wird erst �ber [add Item] eingeblendet.
         * Das Textfeld legen Sie im Norden des Frames ab.
         * F�gen Sie einen KeyAdapter als anonyme Klasse  zu.
         * Er ruft die onEnter()-Methode auf.
         *
         * do it
         */
        inputValue = new TextField();
        inputValue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                onEnter(e);
            }
        });
        add(inputValue, BorderLayout.NORTH);

    }


    /**
     * Die Methode wird beim Klicken auf die Schaltfl�che [add Item] aufgerufen.
     * Sie blendet das Textfeld ein und setzt den Fokus f�r die Werteingabe im
     * Textfeld.
     */
    private void onAddItem() {
        inputValue.setVisible(true);
        pack();
        this.repaint();
        inputValue.requestFocus();
    }


    /**
     * Die Methode pr�ft das eingegeben Zeichen auf ENTER.
     * Bei ENTER wird das Textfeld wieder ausgeblendet und der Fokus auf die Liste gesetzt.
     * Nun wird dem Datenmodel der neue Wert �bermittelt und danach der Wert gel�scht.
     *
     * @param event
     */
    private void onEnter(KeyEvent event) {
        if (event.getKeyChar() == KeyEvent.VK_ENTER) {
            pack();
            this.repaint();
            model.addElement(inputValue.getText());

            //
            inputValue.setText("");
            viewComponent.requestFocus();
        }
    }

    /**
     * Main erzeugt zuerst ein Objekt des Daten-Model und
     * danach die View.
     *
     * @param args
     */
    public static void main(String[] args) {
        Vector<String> hobbys = new Vector<>(ImportFile.readLinesFromFile("src/main/java/N2_1/hobbys.csv"));
        Model m = new Model(hobbys);
        new View(m);
    }
}
