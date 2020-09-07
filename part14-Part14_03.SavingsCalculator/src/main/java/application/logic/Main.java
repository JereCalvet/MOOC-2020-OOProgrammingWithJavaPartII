package application.logic;

/**
 *
 * @author Jere
 */
public class Main {
    public static void main(String[] args) {
        SavingsCalculator calculator = new SavingsCalculator();
        calculator.setMonthlySavings(50.0);
        calculator.setYearlyInterestRate(5.0);
        calculator.calculateYearlyAmountWithRates();
        calculator.test();
    }
}
