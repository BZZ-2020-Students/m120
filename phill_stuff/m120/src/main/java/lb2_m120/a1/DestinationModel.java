package lb2_m120.a1;

import javax.swing.*;
import java.util.Vector;

public class DestinationModel extends DefaultComboBoxModel<String> {
    private Vector<String> destinations;

    public DestinationModel() {
        destinations = new Vector<>();
        destinations.add("Moskau");
        destinations.add("Saint-Petersburg");
        destinations.add("Kiev");
        destinations.add("Kazan");
        destinations.add("Omsk");
    }

    public void addElement(String dest) {
        destinations.add(dest);
    }

    public int getSize() {
        return destinations.size();
    }

    public String getElement(int idx) {
        return destinations.get(idx);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Destinationen: ");
        for (String dest : destinations) {
            sb.append(dest).append(", ");
        }
        return sb.toString();
    }
}
