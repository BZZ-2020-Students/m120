import javax.swing.*;
import java.util.Vector;

public class DestinationModel extends DefaultComboBoxModel<String> {
    private Vector<String> destinations;

    public DestinationModel() {
        destinations = new Vector<String>();
        destinations.add("Bern");
        destinations.add("Basel");
        destinations.add("Berlin");
        destinations.add("London");
        destinations.add("New York");
    }

    public String getElementAt(int idx) {
        return destinations.get(idx);
    }

    public int getSize() {
        return destinations.size();
    }

    public void addElement(String dest) {
        destinations.add(dest);
        fireIntervalAdded(this, 0, destinations.size());
    }

    @Override
    public String toString() {
        String toString = "Destinationen: ";
        for (int i = 0; i < destinations.size(); i++) {
            toString += destinations.get(i) + ", ";
        }
        return toString;
    }

}
