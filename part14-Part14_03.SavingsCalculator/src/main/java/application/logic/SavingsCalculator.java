package application.logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jere
 */
public class SavingsCalculator {

    private Double monthlySavings;
    private Double yearlyInterestRate;
    Map<Integer, Double> nextYearsAmountNoRates;
    Map<Integer, Double> nextYearsAmountWithRates;

    public SavingsCalculator() {
        monthlySavings = 25.0;
        yearlyInterestRate = 0.0;
        nextYearsAmountNoRates = new HashMap<>();
        nextYearsAmountWithRates = new HashMap<>();
    }

    public void setMonthlySavings(Double monthlySavings) {
        this.monthlySavings = monthlySavings;
    }

    public void setYearlyInterestRate(Double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate / 100;
    }

    public Double getMonthlySavings() {
        return monthlySavings;
    }

    public Double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public Map<Integer, Double> getNextYearsAmountNoRates() {
        return nextYearsAmountNoRates;
    }

    public Map<Integer, Double> getNextYearsAmountWithRates() {
        return nextYearsAmountWithRates;
    }

    public void calculateYearlyAmountNoRates() {
        for (int years = 1; years <= 30; years++) {
            nextYearsAmountNoRates.put(years, monthlySavings * years * 12);
        }
    }

    public void calculateYearlyAmountWithRates() {
        Double savedInAYear = monthlySavings * 12;
        Double currentAmount = 0.0;       
                 
        for (int years = 1; years <= 30; years++) {
            currentAmount = (savedInAYear + currentAmount) * (yearlyInterestRate + 1);
            nextYearsAmountWithRates.put(years, currentAmount);
        }
    }
}
