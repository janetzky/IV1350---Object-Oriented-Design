package org.fredrikJ.model;

public abstract class TotalRevenueTemplate implements ControllerPaymentObserver {
    /**
     * The method defined in the observer interface.
     *
     * @param priceOfTheSaleThatWasJustMade
     */
    // This is the method defined in the observer interface .
    public void newSaleWasMade(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome(priceOfTheSaleThatWasJustMade); // Calculate
        // the total amount paid since the program started .
        showTotalIncome();
    }

    /**
     * The procedure to show total income.
     */
    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected abstract void calculateTotalIncome(double priceOfTheSaleThatWasJustMade);

    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);
}
