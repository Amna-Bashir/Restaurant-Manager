public class DrinkItem extends MenuItem {

    public DrinkItem(
            String name,
            double price,
            String category,
            boolean isLimitedTime,
            int stock,
            String description) {

        super(
                name,
                price,
                category,
                true,
                isLimitedTime,
                stock,
                description
        );
    }
}