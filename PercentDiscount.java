public class PercentageDiscount extends Discount {

    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(MenuItem item) {

        return item.getPrice() * (1 - percent / 100);
    }
}