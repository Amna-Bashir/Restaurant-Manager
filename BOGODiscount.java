public class BOGODiscount extends Discount {

    @Override
    public double apply(MenuItem item) {
        return item.getPrice();
    }
}