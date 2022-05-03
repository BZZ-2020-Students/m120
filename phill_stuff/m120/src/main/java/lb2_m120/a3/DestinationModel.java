package lb2_m120.a3;

import javax.swing.*;
import java.util.Collections;
import java.util.Vector;

public class DestinationModel extends DefaultComboBoxModel<String> {
    private Vector<String> destinations;

    public DestinationModel() {
        destinations = new Vector<>();
        destinations.addElement("Moskau");
        destinations.addElement("Saint-Petersburg");
        destinations.addElement("Kiev");
        destinations.addElement("Kazan");
        destinations.addElement("Omsk");
        Collections.sort(destinations);
    }

    public void addElement(String dest) {
        destinations.addElement(dest);
        Collections.sort(destinations);
        this.fireIntervalAdded(this,0,destinations.size());
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
