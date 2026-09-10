import java.time.LocalTime;

public class TimeBasedDiscount extends Discount {

    private int startHour;
    private int endHour;
    private double percent;

    public TimeBasedDiscount(
            int startHour,
            int endHour,
            double percent) {

        this.startHour = startHour;
        this.endHour = endHour;
        this.percent = percent;
    }

    @Override
    public double apply(MenuItem item) {

        int currentHour = LocalTime.now().getHour();

        if (currentHour >= startHour && currentHour <= endHour) {

            return item.getPrice() * (1 - percent / 100);
        }

        return item.getPrice();
    }
}