package N2_1;

import javax.swing.*;
import java.io.Serial;
import java.util.Collections;
import java.util.Vector;

public class Model extends DefaultListModel<String> {
    @Serial
    private static final long serialVersionUID = -7020155788714133491L;
    private final Vector<String> data;

    public Model() {
        data = new Vector<>();
        data.add("Skifahren");
        data.add("Schwimmen");
        data.add("Fussball");
        data.add("Segeln");
        data.add("Cart Rennen");
        data.add("Volleyball");
        data.add("Biken");
        Collections.sort(data);
    }

    @Override
    public String getElementAt(int arg0) {
        return data.elementAt(arg0);
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public void addElement(String value) {
        data.add(value);
        Collections.sort(data);
        fireIntervalAdded(this, data.size(), data.size());
    }
}
