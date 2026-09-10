import java.util.ArrayList;
import java.util.List;

public class MenuManager {

    private List<MenuItem> items;

    public MenuManager() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    private void displayTableHeading() {

        System.out.printf(
                "| %-25s | %-6s | %-3s | %-10s | %-60s | Stock%n",
                "Name",
                "Price",
                "Veg",
                "Limited",
                "Description"
        );

        System.out.println(
                "|---------------------------|--------|-----|------------|" +
                "--------------------------------------------------|-------|"
        );
    }

    public void displayByCategory(String categoryName) {

        System.out.println(
                categoryName + " ⟡ ◯ + ̊⊹♡"
        );

        displayTableHeading();

        for (MenuItem item : items) {

            if (item.getCategory().equalsIgnoreCase(categoryName)) {
                item.displayRow();
            }
        }

        System.out.println();
    }

    public void displayAllCategories() {

        String[] categories = {
                "Starters",
                "Soups",
                "Salads",
                "Wraps",
                "Durums",
                "Meat Platters",
                "Kebabs",
                "Pide",
                "Desserts",
                "Drinks",
                "Extras"
        };

        for (String category : categories) {
            displayByCategory(category);
        }
    }

    public void applyDiscountToAll(Discount discount) {

        for (MenuItem item : items) {

            double newPrice = discount.apply(item);

            System.out.printf(
                    "%-30s after discount: $%.2f%n",
                    item.getName(),
                    newPrice
            );
        }
    }

    public void showFeaturedItem() {

        if (items.isEmpty()) {
            return;
        }

        int randomIndex =
                (int) (Math.random() * items.size());

        System.out.println(
                "\n✨ Chef's Featured Dish Today ✨"
        );

        items.get(randomIndex).displayRow();

        System.out.println();
    }

    public MenuItem getItemByName(String name) {

        for (MenuItem item : items) {

            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}