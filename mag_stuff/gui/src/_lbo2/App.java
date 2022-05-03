package _lbo2;

public class App {
    public static void main(String[] args) {
        DestinationModel m = new DestinationModel();
        System.out.println(m);
        InputGUI ig = new InputGUI(m);
        UserGUI ug = new UserGUI(m);
    }
}
