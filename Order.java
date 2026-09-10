import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order extends Membership {

    public static boolean[] space1isBooked =
            new boolean[35];

    public static boolean[] space2isBooked =
            new boolean[35];

    public static boolean[] space3isBooked =
            new boolean[35];

    public static String[] menu_items = {
            "Mixed Appetizer Plate",
            "Atom",
            "Feta Cheese Rolls",
            "Ezme",
            "Meat Soup",
            "Lentil Soup",
            "Greek Salad",
            "Shepherd's Salad",
            "Chicken Shawarma Wrap",
            "Beef Shawarma Wrap",
            "Falafel Wrap",
            "Adana Kebab",
            "Chicken Shish",
            "Lamb Shish",
            "Iskender Kebab",
            "Beef Doner",
            "Chicken Doner",
            "Kofte Kebab",
            "Mixed Grill Kebab",
            "Family Platter",
            "Chicken Platter",
            "Lahmacun",
            "Cheese Pide",
            "Sucuk Pide",
            "Meat Pie",
            "Kunefe",
            "Baklava",
            "Rice Pudding",
            "Ayran",
            "Turkish Tea",
            "Turkish Coffee",
            "Soda Water",
            "Coca-Cola",
            "Fanta",
            "Water Bottle",
            "French Fries",
            "Garlic Sauce",
            "Spicy Sauce",
            "Rice Side",
            "Pita Bread"
    };

    public static double[] prices = {
            22.99,
            10.99,
            11.99,
            9.99,
            10.99,
            9.99,
            12.99,
            11.99,
            11.99,
            13.99,
            10.99,
            18.99,
            19.99,
            22.99,
            21.99,
            17.88,
            16.99,
            17.99,
            32.99,
            79.99,
            23.99,
            26.99,
            8.99,
            12.99,
            15.99,
            14.99,
            9.99,
            7.99,
            5.99,
            2.99,
            1.99,
            3.99,
            2.50,
            2.99,
            2.99,
            1.50,
            5.99,
            0.99,
            0.99,
            4.99,
            2.99
    };

    private int noItems;
    private double total;

    private String[][] receipt;

    private int bogofCounter;

    private String[] bogof;

    private String[] locationPositive;
    private String[] locationNegative;

    private String value;
    private String discountApplied;

    public static ArrayList<String> orderNumbersArray =
            new ArrayList<>();

    private String location;

    public Order() {

        super();

        noItems = 0;
        bogofCounter = 0;

        locationPositive = new String[]{
                "Africa/Ndjamena",
                "Africa/Windhoek",
                "Asia/Gaza",
                "Asia/Dubai",
                "Asia/Karachi",
                "Asia/Dhaka",
                "Asia/Bangkok",
                "Asia/Shanghai",
                "Asia/Tokyo",
                "Australia/Brisbane",
                "Pacific/Noumea",
                "Pacific/Fiji",
                "Pacific/Tongatapu"
        };

        locationNegative = new String[]{
                "Africa/Casablanca",
                "Atlantic/South_Georgia",
                "America/Argentina/Buenos_Aires",
                "America/Halifax",
                "America/New_York",
                "America/Chicago",
                "America/Denver",
                "America/Los_Angeles",
                "America/Anchorage",
                "Pacific/Honolulu",
                "Pacific/Pago_Pago"
        };

        value = "Africa/Abidjan";
        discountApplied = "";

        bogof = new String[1000];
    }

    public Order(
            int numItems,
            String number,
            String name) {

        super(number, name);

        noItems = numItems;

        receipt =
                new String[2][numItems];

        locationPositive = new String[]{
                "Africa/Ndjamena",
                "Africa/Windhoek",
                "Asia/Gaza",
                "Asia/Dubai",
                "Asia/Karachi",
                "Asia/Dhaka",
                "Asia/Bangkok",
                "Asia/Shanghai",
                "Asia/Tokyo",
                "Australia/Brisbane",
                "Pacific/Noumea",
                "Pacific/Fiji",
                "Pacific/Tongatapu"
        };

        locationNegative = new String[]{
                "Africa/Casablanca",
                "Atlantic/South_Georgia",
                "America/Argentina/Buenos_Aires",
                "America/Halifax",
                "America/New_York",
                "America/Chicago",
                "America/Denver",
                "America/Los_Angeles",
                "America/Anchorage",
                "Pacific/Honolulu",
                "Pacific/Pago_Pago"
        };

        value = "Africa/Abidjan";

        bogof = new String[1000];
    }

    public void Customer_order(
            String[] array,
            int zoneOffset,
            double lunchtimeDiscount,
            int year,
            int month,
            int date,
            int openYear,
            int openMonth,
            int openDate,
            int closeYear,
            int closeMonth,
            int closeDate,
            int startHour,
            int startMinutes,
            int endHour,
            int endMinutes) {

        for (int j = 0; j < noItems; j++) {

            receipt[0][j] = array[j];

            int index = findMenuItem(
                    receipt[0][j]
            );

            if (index == -1) {
                continue;
            }

            if (zoneOffset >= 1) {

                location =
                        locationPositive[zoneOffset - 1];

            } else if (zoneOffset < 0) {

                location =
                        locationNegative[-zoneOffset - 1];

            } else {

                location = value;
            }

            ZoneId timezone =
                    ZoneId.of(location);

            ZonedDateTime currentDateTime =
                    ZonedDateTime.now(timezone);

            LocalTime currentTime =
                    currentDateTime.toLocalTime();

            LocalDate currentDate =
                    currentDateTime.toLocalDate();

            LocalTime targetTime =
                    LocalTime.of(
                            startHour,
                            startMinutes
                    );

            LocalTime targetTime2 =
                    LocalTime.of(
                            endHour,
                            endMinutes
                    );

            LocalDate startingDate =
                    LocalDate.of(
                            openYear,
                            openMonth,
                            openDate
                    );

            LocalDate endingDate =
                    LocalDate.of(
                            closeYear,
                            closeMonth,
                            closeDate
                    );

            if ((currentDate.isEqual(startingDate)
                    || currentDate.isAfter(startingDate))
                    && !currentDate.isEqual(endingDate)) {

                receipt[1][j] =
                        String.valueOf(
                                prices[index] * 0.8
                        );

                total += prices[index] * 0.8;

                discountApplied =
                        "Opening week discount";

            } else if (!currentTime.isBefore(targetTime)
                    && !currentTime.isAfter(targetTime2)) {

                receipt[1][j] =
                        String.valueOf(
                                prices[index]
                                        * (1 - lunchtimeDiscount / 100)
                        );

                total += prices[index]
                        * (1 - lunchtimeDiscount / 100);

                discountApplied =
                        "Lunch time discount";

            } else if (super.checkMembership(
                    phonenumber,
                    membername)) {

                receipt[1][j] =
                        String.valueOf(prices[index]);

                bogof[bogofCounter] =
                        receipt[0][j];

                bogofCounter++;

                total += prices[index];

                discountApplied =
                        "Membership discount";

            } else {

                receipt[1][j] =
                        String.valueOf(prices[index]);

                total += prices[index];

                discountApplied =
                        "No discount";
            }
        }

        // Income class removed.
        // No income object is created here anymore.
    }

    private int findMenuItem(String itemName) {

        for (int i = 0; i < menu_items.length; i++) {

            if (menu_items[i]
                    .equalsIgnoreCase(itemName)) {

                return i;
            }
        }

        return -1;
    }

    public void Receipt(
            String locationName,
            String cashier,
            String methodPayment,
            double tax,
            String type,
            String orderNumber) {

        ZonedDateTime currentDateTime =
                ZonedDateTime.now(
                        ZoneId.of(location)
                );

        LocalDate currentDate =
                currentDateTime.toLocalDate();

        LocalTime currentTime =
                currentDateTime.toLocalTime();

        printReceiptHeader(locationName);

        System.out.println(
                "***COPY RECEIPT*******"
        );

        System.out.println(
                "Order # " + orderNumber
                        + "\nCLERK:" + cashier
                        + "\tDate: " + currentDate
                        + "\nTime: " + currentTime
                        + "\tType: " + type
        );

        printDivider();

        printItems();

        printDivider();

        System.out.printf(
                "\tSub total: $%.2f%n",
                total
        );

        printDivider();

        double taxAmount =
                total * tax / 100.0;

        System.out.printf(
                "\tTax: $%.2f%n",
                taxAmount
        );

        printDivider();

        double finalTotal =
                total + taxAmount;

        System.out.printf(
                "\tTotal: $%.2f%n",
                finalTotal
        );

        printDivider();

        System.out.println(
                "\tDiscount applied: "
                        + discountApplied
        );

        printDivider();

        System.out.println(
                "Method of payment: "
                        + methodPayment
        );

        System.out.println(
                "THANK YOU. Please come again."
        );
    }

    public void ReceiptDelivery(
            String locationName,
            String methodPayment,
            double tax,
            int deliveryYear,
            int deliveryMonth,
            int deliveryDate,
            int deliveryHour,
            int deliveryMinutes) {

        LocalDate deliveryDateValue =
                LocalDate.of(
                        deliveryYear,
                        deliveryMonth,
                        deliveryDate
                );

        LocalTime deliveryTime =
                LocalTime.of(
                        deliveryHour,
                        deliveryMinutes
                );

        ZonedDateTime currentDateTime =
                ZonedDateTime.now(
                        ZoneId.of(location)
                );

        LocalDate currentDate =
                currentDateTime.toLocalDate();

        LocalTime currentTime =
                currentDateTime.toLocalTime();

        DateTimeFormatter dateFormatter =
                DateTimeFormatter.ofPattern(
                        "yyyy-MM-dd"
                );

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern(
                        "HH:mm"
                );

        printReceiptHeader(locationName);

        System.out.println(
                "***DELIVERY RECEIPT***"
        );

        System.out.println(
                "\nPrinted Date: " + currentDate
                        + "\nPrinted Time: " + currentTime
                        + "\tType: Delivery"
        );

        System.out.println(
                "Delivery Date: "
                        + deliveryDateValue.format(
                        dateFormatter
                )
        );

        System.out.println(
                "Delivery Time: "
                        + deliveryTime.format(
                        timeFormatter
                )
        );

        printDivider();

        printItems();

        printDivider();

        System.out.printf(
                "\tSub total: $%.2f%n",
                total
        );

        printDivider();

        double taxAmount =
                total * tax / 100.0;

        System.out.printf(
                "\tTax: $%.2f%n",
                taxAmount
        );

        printDivider();

        double finalTotal =
                total + taxAmount;

        System.out.printf(
                "\tTotal: $%.2f%n",
                finalTotal
        );

        printDivider();

        System.out.println(
                "\tDiscount applied: "
                        + discountApplied
        );

        printDivider();

        System.out.println(
                "Method of payment: "
                        + methodPayment
        );

        System.out.println(
                "THANK YOU. Please come again."
        );
    }

    private void printItems() {

        if (receipt == null) {
            return;
        }

        for (int b = 0;
             b < receipt[0].length;
             b++) {

            int itemCounting = 1;

            for (int i = 0;
                 i < bogofCounter;
                 i++) {

                if (receipt[0][b]
                        .equalsIgnoreCase(bogof[i])) {

                    itemCounting++;
                }
            }

            System.out.println(
                    itemCounting
                            + ". "
                            + receipt[0][b]
                            + " $"
                            + String.format(
                            "%.2f",
                            Double.parseDouble(
                                    receipt[1][b]
                            )
                    )
            );
        }
    }

    private void printReceiptHeader(
            String locationName) {

        System.out.println(
                "\t\t,---. ,---.\r\n" +
                " /\"`.\\.--\"\"\"--./,'\"\\ \\\r\n" +
                " \\ \\ _ _ /\r\n" +
                " `./ / __ __ \\ \r\n" +
                " \\,'\r\n" +
                " / /_O)_(_O\\ \r\n" +
                " | .-' ___ `-. |\r\n" +
                " .--| \\_/ |\r\n" +
                " ,' \\ \\ | / /\r\n" +
                " / `. `--^--' ,'\r\n" +
                " .-\"\"\"\"\"-. `--.___.--\"\"\"\"\"-.\r\n" +
                ".-----------/ \\------------------/\r\n" +
                "| .---------\\ /----------------- \\ \r\n" +
                "| | `-`--`--' `--'--'-' | |\r\n" +
                "| | KEBAB HAVEN | |\r\n" +
                "| | Location: "
                        + locationName
                        + " | |\r\n" +
                "|_____________________________________________________________| |\r\n" +
                "|_________________________________________________________________|"
        );
    }

    private void printDivider() {

        System.out.println(
                "─── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ───── ⋆⋅☆⋅⋆ ─────"
        );
    }

    public static void printer2D(char[][] arr) {

        for (int row = 0;
             row < arr.length;
             row++) {

            for (int col = 0;
                 col < arr[0].length;
                 col++) {

                System.out.print(arr[row][col]);
            }

            System.out.println();
        }

        System.out.println();
    }
}