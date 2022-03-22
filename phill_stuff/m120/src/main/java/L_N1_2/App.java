package L_N1_2;

public class App {
  public static void main(String[] args){
    IntegerModel model = new IntegerModel();
    new InputView(model);
    new HEX_Output(model);
    new BIN_Output(model);
    new DEC_Output(model);
  }
}
