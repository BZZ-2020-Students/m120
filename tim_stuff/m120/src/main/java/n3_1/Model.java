package n3_1;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.util.Collections;
import java.util.Vector;

public class Model extends DefaultListModel<String> {
    @Serial
    private static final long serialVersionUID = -7020155788714133491L;
    private final Vector<String> data;

    public Model() {
        Vector<String> tempData = new Vector<>();
        try (FileInputStream fis = new FileInputStream("model.dat")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            tempData = (Vector<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            tempData.add("Skifahren");
            tempData.add("Schwimmen");
            tempData.add("Fussball");
            tempData.add("Segeln");
            tempData.add("Cart Rennen");
            tempData.add("Volleyball");
            tempData.add("Biken");
        }

        data = tempData;
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

    public Vector<String> getData() {
        return data;
    }
}
