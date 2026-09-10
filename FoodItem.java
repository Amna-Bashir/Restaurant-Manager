public class FoodItem extends MenuItem {

    public FoodItem(
            String name,
            double price,
            String category,
            boolean isVegetarian,
            boolean isLimitedTime,
            int stock,
            String description) {

        super(
                name,
                price,
                category,
                isVegetarian,
                isLimitedTime,
                stock,
                description
        );
    }
}