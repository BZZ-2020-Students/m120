import javax.swing.*;
import java.util.Vector;

/**
 * @author Tim Irmler
 * <p>
 * This is the destination model class. It is used to store the information about the destinations.
 * It will display it in a defaultComboBox.
 */
public class DestinationModel extends DefaultComboBoxModel<String> {
    private final Vector<String> destinations;

    public DestinationModel() {
        destinations = new Vector<>();

        destinations.add("Paris");
        destinations.add("New York");
        destinations.add("London");
        destinations.add("Rome");
        destinations.add("Barcelona");
        destinations.add("Madrid");
    }

    public String getElementAt(int index) {
        return destinations.get(index);
    }

    public int getSize() {
        return destinations.size();
    }

    public void addElement(String element) {
        destinations.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String destination : destinations) {
            sb.append(destination);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
