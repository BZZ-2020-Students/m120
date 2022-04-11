package mvc_test;

public class MVCCalc {
    public static void main(String[] args) {
        CalculatorView theView = new CalculatorView();
        CalculatorModel theModel = new CalculatorModel();
        CalcController theController = new CalcController(theView, theModel);
        theView.setVisible(true);
    }
}
