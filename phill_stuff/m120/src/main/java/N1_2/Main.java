package N1_2;

public class Main {
    public static void main(String[] args){
        IntegerModel model = new IntegerModel();
        InputView inputview = new InputView(model);
        DEC_Output dec = new DEC_Output(model);
        BIN_Output bin= new BIN_Output(model);
        HEX_Output hex= new HEX_Output(model);
    }
}
