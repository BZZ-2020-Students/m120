package _lbo2;

import javax.swing.*;
import java.util.Vector;

public class DestinationModel extends DefaultComboBoxModel<String> {

    private Vector<String> destinations = new Vector<>();

    public DestinationModel() {
        destinations.add("Zurich");
        destinations.add("London");
        destinations.add("Lissabon");
        destinations.add("Berlin");
    }

    @Override
    public String getElementAt(int index) {
        return destinations.elementAt(index);
    }

    @Override
    public int getSize() {
        return destinations.size();
    }

    @Override
    public void addElement(String value) {
        destinations.add(value);
        fireIntervalAdded(this, destinations.size(), destinations.size());
    }

    @Override
    public String toString() {
        String str = "Destination: ";
        for (String destination : destinations) {
            str += destination + ", ";
        }
        return str;
    }
}
