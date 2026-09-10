public class MenuItem {

    private String name;
    private double price;
    private String category;
    private boolean isVegetarian;
    private boolean isLimitedTime;
    private int stock;
    private String review;
    private int rating;
    private String description;

    public MenuItem(
            String name,
            double price,
            String category,
            boolean isVegetarian,
            boolean isLimitedTime,
            int stock,
            String description) {

        this.name = name;
        this.price = price;
        this.category = category;
        this.isVegetarian = isVegetarian;
        this.isLimitedTime = isLimitedTime;
        this.stock = stock;
        this.description = description;

        this.review = "";
        this.rating = 0;
    }

    public void displayRow() {

        String vegStatus = isVegetarian ? "Yes" : "No";
        String limitedStatus = isLimitedTime ? "Limited!" : "";

        System.out.printf(
                "| %-25s | %6.2f | %-3s | %-10s | %-60s | Stock: %d%n",
                name,
                price,
                vegStatus,
                limitedStatus,
                description,
                stock
        );

        if (!review.isEmpty()) {
            System.out.printf(
                    " 👉 Review: %s (%d stars)%n",
                    review,
                    rating
            );
        }
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int newStock) {

        if (newStock >= 0) {
            this.stock = newStock;
        } else {
            System.out.println(
                    "❌ Invalid stock value. It must be 0 or higher."
            );
        }
    }

    public void addReview(String reviewText, int starRating) {

        review = reviewText;

        if (starRating >= 1 && starRating <= 5) {
            rating = starRating;
        }
    }

    public void displayReview() {

        if (!review.isEmpty()) {
            System.out.println(
                    "Review: " + review + " (" + rating + " stars)"
            );
        }
    }
}