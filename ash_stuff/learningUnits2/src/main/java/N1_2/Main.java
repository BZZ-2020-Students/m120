package N1_2;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        IntegerModel model = new IntegerModel();
        new InputView(model);
        new HEX_Output(model);
        new DEC_Output(model);
        new BIN_Output(model);
    }
}
