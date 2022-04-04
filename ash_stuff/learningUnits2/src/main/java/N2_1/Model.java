package N2_1;

import javax.swing.*;
import java.util.Collections;
import java.util.Vector;

/**
 * Das Daten-Model representiert eine Vielzahl von Strings (z.B. Hobbies)
 * Die Datenwerte werden in einem Vector gehalten.
 * <p>
 * F�r die Kommunikation mit der View werden die notwendigen Methoden aus
 * DefaultListModel überschrieben.
 *
 * @author Ren� Probst
 */
public class Model extends DefaultListModel<String> {


    private Vector<String> data;

    public Model() {
        data = new Vector<String>();
        data.add("Skifahren");
        data.add("Schwimmen");
        data.add("Fussball");
        data.add("Segeln");
        data.add("Cart Rennen");
        data.add("Volleyball");
        data.add("Biken");
        Collections.sort(data);  //das sieht einfach sch�ner aus//
    }


    @Override
    /**
     * Liefert das Element, das durch arg0 indiziert wird.
     */
    public String getElementAt(int arg0) {
        // TODO Auto-generated method stub
        // do it
        return data.get(arg0);
    }

    @Override
    /**
     * Liefert die Anzahl der vorhandenen Datenwerte
     */
    public int getSize() {
        // do it
        return data.size();
    }

    @Override
    /**
     * Fügt den neuen Wert dem Vector zu und sortiert die Liste.
     * Danach muss die View-Komponente über die Änderung der Daten
     * informiert werden → siehe dazu die API von DefaultListModel
     */
    public void addElement(String value) {
        // do it
        data.add(value);
        Collections.sort(data);
        fireIntervalAdded(this, data.size(), data.size());
    }

    @Override
    public String toString() {
        String msg = "";
        for(String s : data) {
            msg += s +"\n";
        }
        return msg;
    }

    @Override
   public void clear() {
        data.clear();
    }

}
