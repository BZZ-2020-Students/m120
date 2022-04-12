/**
 * @author Tim Irmler
 * <p>
 * This is the main class for the application.
 * It just creates a new instance of the DestinationModel class and prints out the destinations.
 */
public class App {
    public static void main(String[] args) {
        DestinationModel destinationModel = new DestinationModel();
        InputGUI inputGUI = new InputGUI(destinationModel);
    }
}
