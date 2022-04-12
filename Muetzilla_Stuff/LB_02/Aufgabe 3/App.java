public class App {
    public static void main(String[] args) {
        //Datamodel
        DestinationModel m =  new DestinationModel();
        InputGUI inputGui = new InputGUI(m);
        //Input frame
        inputGui.setSize(400,100);
        //Selection frame
        UserGUI userGui = new UserGUI(m);
        userGui.setSize(400,75);
    }
}
