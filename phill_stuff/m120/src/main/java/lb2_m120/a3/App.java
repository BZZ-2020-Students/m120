package lb2_m120.a3;

public class App {
    public static void main(String[] args) {
        DestinationModel m = new DestinationModel();
        InputGUI in = new InputGUI(m);
        UserGUI userGUI = new UserGUI(m);
    }
}
