package mvc_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {

    private CalculatorModel theModel;
    private CalculatorView theView;

    public CalcController(CalculatorView theView, CalculatorModel theModel){
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addCalculationsListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNbr, secondNbr = 0;
            try{
                firstNbr = theView.getFirstNbr();
                secondNbr = theView.getSecondNbr();

                theModel.addTwoNumber(firstNbr, secondNbr);
                theView.setCalcSolution(theModel.getCalculationValue());
            }catch (NumberFormatException ex){
               theView.displayErrorMsg();
            }
        }
    }
}
