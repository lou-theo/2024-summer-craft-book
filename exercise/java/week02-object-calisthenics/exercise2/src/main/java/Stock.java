public class Stock {
    private int value;

    public Stock(int value) {
        this.value = value;
    }

    public boolean isPositive() {
        return value > 0;
    }

    public void add(Stock additionalCopies) {
        if (additionalCopies.value > 0) {
            this.value += additionalCopies.value;
        }
    }

    public void remove(Stock soldCopies) {
        if (soldCopies.value > 0 && this.value >= soldCopies.value) {
            this.value -= soldCopies.value;
        }
    }
}
