import outputs.BIN_Output;
import outputs.DEC_Output;
import outputs.HEX_Output;

public class Main {
    public static void main(String[] args) {
        IntegerModel model = new IntegerModel();

        InputView inputView = new InputView(model);

        HEX_Output outputHex = new HEX_Output(model);
        BIN_Output outputBin = new BIN_Output(model);
        DEC_Output outputDec = new DEC_Output(model);

    }
}
