package sg.nus.iss.javaspring.minicoins;


public class Submission {
    private String inputValue;
    private double[] selectedCoins;

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    public double[] getSelectedCoins() {
        return selectedCoins;
    }

    public void setSelectedCoins(double[] selectedCoins) {
        this.selectedCoins = selectedCoins;
    }
}
