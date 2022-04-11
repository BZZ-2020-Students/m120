package mvc_test;

public class CalculatorModel {

    private int calculationValue;
    private int minusCalculatiiopnValue;

    public void addTwoNumber(int firstNumber, int secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public int getCalculationValue() {
        return calculationValue;
    }

    public void minusttwoNbr(int firstNbr, int secondNbr){
        minusCalculatiiopnValue = firstNbr - secondNbr;
    }

    public int getMinusCalculatiiopnValue(){
        return calculationValue;
    }

}
