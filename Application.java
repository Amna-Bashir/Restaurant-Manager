import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        MenuManager manager =
                createMenu();

        showWelcomeMessage();

        manager.showFeaturedItem();

        addReviews(manager);

        manager.displayAllCategories();

        showDiscountMenu(scanner, manager);

        runRestaurantSystem(scanner, manager);

        scanner.close();
    }

    private static MenuManager createMenu() {

        MenuManager manager =
                new MenuManager();

        // Starters
        manager.addItem(
                new FoodItem(
                        "Mixed Appetizer Plate",
                        22.99,
                        "Starters",
                        true,
                        false,
                        10,
                        "A mix of hummus, eggplant dip, chili tomato dip, tabbouleh, and labneh."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Atom",
                        10.99,
                        "Starters",
                        true,
                        false,
                        10,
                        "Roasted pepper, garlic, and yogurt with butter."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Feta Cheese Rolls",
                        11.99,
                        "Starters",
                        true,
                        false,
                        10,
                        "Rolled pastry filled with feta cheese and herbs."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Ezme",
                        9.99,
                        "Starters",
                        true,
                        false,
                        10,
                        "Spicy Turkish tomato dip."
                )
        );

        // Soups
        manager.addItem(
                new FoodItem(
                        "Meat Soup",
                        10.99,
                        "Soups",
                        false,
                        false,
                        10,
                        "Veal chickpea soup served fresh daily with bread."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Lentil Soup",
                        9.99,
                        "Soups",
                        true,
                        false,
                        10,
                        "Traditional red lentil soup."
                )
        );

        // Salads
        manager.addItem(
                new FoodItem(
                        "Greek Salad",
                        12.99,
                        "Salads",
                        true,
                        false,
                        10,
                        "Lettuce, tomato, cucumber, olives, feta cheese, herbs."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Shepherd's Salad",
                        11.99,
                        "Salads",
                        true,
                        false,
                        10,
                        "Fresh tomato cucumber onion parsley salad."
                )
        );

        // Wraps
        manager.addItem(
                new FoodItem(
                        "Chicken Shawarma Wrap",
                        11.99,
                        "Wraps",
                        false,
                        false,
                        10,
                        "Marinated chicken in wrap."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Beef Shawarma Wrap",
                        13.99,
                        "Wraps",
                        false,
                        false,
                        10,
                        "Marinated beef in wrap."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Falafel Wrap",
                        10.99,
                        "Wraps",
                        true,
                        false,
                        10,
                        "Falafel balls with veggies and tahini sauce."
                )
        );

        // Kebabs
        manager.addItem(
                new FoodItem(
                        "Adana Kebab",
                        18.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Spicy minced beef and lamb grilled on skewers."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Chicken Shish",
                        19.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Grilled marinated chicken cubes on skewers."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Lamb Shish",
                        22.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Grilled marinated lamb cubes on skewers."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Iskender Kebab",
                        21.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Grilled doner meat over pita with yogurt and tomato sauce."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Beef Doner",
                        17.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Slow-roasted beef slices."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Chicken Doner",
                        16.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Slow-roasted chicken slices."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Kofte Kebab",
                        17.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Grilled Turkish meatballs."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Mixed Grill Kebab",
                        32.99,
                        "Kebabs",
                        false,
                        false,
                        10,
                        "Mix of lamb, chicken, kofte, adana on one plate."
                )
        );

        // Meat Platters
        manager.addItem(
                new FoodItem(
                        "Family Platter",
                        79.99,
                        "Meat Platters",
                        false,
                        false,
                        10,
                        "Large platter for 4 with kebabs, rice, salad, bread."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Chicken Platter",
                        23.99,
                        "Meat Platters",
                        false,
                        false,
                        10,
                        "Marinated chicken cubes with rice, salad, and bread."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Lamb Platter",
                        26.99,
                        "Meat Platters",
                        false,
                        false,
                        10,
                        "Marinated lamb cubes with rice, salad, and bread."
                )
        );

        // Pide
        manager.addItem(
                new FoodItem(
                        "Lahmacun",
                        8.99,
                        "Pide",
                        false,
                        false,
                        10,
                        "Thin Turkish flatbread topped with minced beef and herbs."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Cheese Pide",
                        12.99,
                        "Pide",
                        true,
                        false,
                        10,
                        "Cheesy Turkish style pizza."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Sucuk Pide",
                        15.99,
                        "Pide",
                        false,
                        false,
                        10,
                        "Pide topped with spicy Turkish sausage."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Meat Pide",
                        14.99,
                        "Pide",
                        false,
                        true,
                        10,
                        "Pide topped with ground beef."
                )
        );

        // Desserts
        manager.addItem(
                new FoodItem(
                        "Kunefe",
                        9.99,
                        "Desserts",
                        true,
                        false,
                        10,
                        "Sweet cheese pastry soaked in syrup, served hot."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Baklava",
                        7.99,
                        "Desserts",
                        true,
                        false,
                        10,
                        "Filo pastry layers with pistachios and syrup."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Rice Pudding",
                        5.99,
                        "Desserts",
                        true,
                        true,
                        10,
                        "Traditional creamy rice dessert."
                )
        );

        // Drinks
        manager.addItem(
                new DrinkItem(
                        "Ayran",
                        2.99,
                        "Drinks",
                        false,
                        10,
                        "Cold Turkish yogurt drink."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Turkish Tea",
                        1.99,
                        "Drinks",
                        false,
                        10,
                        "Hot black tea."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Turkish Coffee",
                        3.99,
                        "Drinks",
                        false,
                        10,
                        "Strong traditional Turkish coffee."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Soda Water",
                        2.50,
                        "Drinks",
                        false,
                        10,
                        "Sparkling mineral water."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Coca-Cola",
                        2.99,
                        "Drinks",
                        false,
                        10,
                        "Classic Coke soft drink."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Fanta",
                        2.99,
                        "Drinks",
                        false,
                        10,
                        "Orange soda drink."
                )
        );

        manager.addItem(
                new DrinkItem(
                        "Water Bottle",
                        1.50,
                        "Drinks",
                        false,
                        10,
                        "Small bottled water."
                )
        );

        // Extras
        manager.addItem(
                new FoodItem(
                        "French Fries",
                        5.99,
                        "Extras",
                        true,
                        false,
                        10,
                        "Crispy golden fries."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Garlic Sauce",
                        0.99,
                        "Extras",
                        true,
                        false,
                        10,
                        "Creamy garlic sauce side."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Spicy Sauce",
                        0.99,
                        "Extras",
                        true,
                        false,
                        10,
                        "Hot pepper spicy sauce."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Rice Side",
                        4.99,
                        "Extras",
                        true,
                        false,
                        10,
                        "Steamed rice side dish."
                )
        );

        manager.addItem(
                new FoodItem(
                        "Pita Bread",
                        2.99,
                        "Extras",
                        true,
                        false,
                        10,
                        "Fresh baked pita bread."
                )
        );

        return manager;
    }

    private static void showWelcomeMessage() {

        System.out.println(
                "\t\t\t\t╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "\t\t\t\t║ Welcome to Kebap Haven!                          ║"
        );

        System.out.println(
                "\t\t\t\t║ The Home of Authentic Turkish Cuisine            ║"
        );

        System.out.println(
                "\t\t\t\t╚══════════════════════════════════════════════════╝\n"
        );
    }

    private static void addReviews(
            MenuManager manager) {

        MenuItem chicken =
                manager.getItemByName(
                        "Chicken Shawarma Wrap"
                );

        MenuItem falafel =
                manager.getItemByName(
                        "Falafel Wrap"
                );

        MenuItem lahmacun =
                manager.getItemByName(
                        "Lahmacun"
                );

        if (chicken != null) {
            chicken.addReview(
                    "Delicious and juicy!",
                    5
            );
        }

        if (falafel != null) {
            falafel.addReview(
                    "So tasty and crispy! Chef's Kiss!",
                    4
            );
        }

        if (lahmacun != null) {
            lahmacun.addReview(
                    "Authentic flavor, just like Istanbul!",
                    5
            );
        }
    }

    private static void showDiscountMenu(
            Scanner scanner,
            MenuManager manager) {

        System.out.print(
                "WOULD YOU LIKE TO SEE CLERK'S ASSISTANCE "
                        + "[MENU W/DISCOUNTED PRICES]? "
                        + "(Enter 1 for yes, 2 to continue): "
        );

        int clerkMenu = scanner.nextInt();
        scanner.nextLine();

        if (clerkMenu != 1) {
            return;
        }

        System.out.print(
                "Would you like to see the opening week discount "
                        + "or lunch time discount?\n"
                        + "Enter 'opening' for opening week discount "
                        + "or 'lunch' for lunch time discount: "
        );

        String choice =
                scanner.nextLine();

        while (!choice.equalsIgnoreCase("opening")
                && !choice.equalsIgnoreCase("lunch")) {

            System.out.println(
                    "\nInvalid input"
            );

            System.out.print(
                    "Enter 'opening' or 'lunch': "
            );

            choice =
                    scanner.nextLine();
        }

        if (choice.equalsIgnoreCase("opening")) {

            System.out.println(
                    "\n➤ Opening Week Menu (20% Discount):"
            );

            System.out.println(
                    "----------------------------------------------"
            );

            manager.applyDiscountToAll(
                    new PercentageDiscount(20)
            );

        } else {

            System.out.println(
                    "\n➤ Lunch Time Discounted Menu:"
            );

            System.out.println(
                    "----------------------------------------------"
            );

            manager.applyDiscountToAll(
                    new TimeBasedDiscount(
                            11,
                            14,
                            30
                    )
            );
        }
    }

    private static void runRestaurantSystem(
            Scanner scanner,
            MenuManager manager) {

        System.out.println(
                "BOOTING THE SYSTEM. PLEASE WAIT.........."
        );

        System.out.println(
                "Server 1.\n"
                        + "\t────୨ৎ────────୨ৎ────────୨ৎ────────୨ৎ────────୨ৎ"
                        + "\n\t\tWELCOME TO KEBAB HAVEN'S SOFTWARE."
        );

        System.out.println(
                "BEFORE ACCESSING THE FEATURES. "
                        + "PLEASE ENTER THE REQUIRED INFORMATION."
        );

        System.out.println(
                "────────────────────────────────────────────"
        );

        System.out.print(
                "Enter the location of the restaurant: "
        );

        String location =
                scanner.nextLine();

        while (location.trim().isEmpty()) {

            System.out.println(
                    "Location cannot be empty."
            );

            System.out.print(
                    "Enter the location of the restaurant: "
            );

            location =
                    scanner.nextLine();
        }

        System.out.print(
                "\nEnter the current year: "
        );

        int year =
                scanner.nextInt();

        System.out.print(
                "Enter the current month: "
        );

        int month =
                scanner.nextInt();

        while (month < 1 || month > 12) {

            System.out.print(
                    "Month must be 1-12. Try again: "
            );

            month =
                    scanner.nextInt();
        }

        System.out.print(
                "Enter the current date: "
        );

        int date =
                scanner.nextInt();

        while (date < 1 || date > 31) {

            System.out.print(
                    "Date must be 1-31. Try again: "
            );

            date =
                    scanner.nextInt();
        }

        System.out.print(
                "\nEnter the opening year: "
        );

        int openYear =
                scanner.nextInt();

        System.out.print(
                "Enter the opening month: "
        );

        int openMonth =
                scanner.nextInt();

        System.out.print(
                "Enter the opening date: "
        );

        int openDate =
                scanner.nextInt();

        System.out.print(
                "\nEnter the end of opening week's year: "
        );

        int closeYear =
                scanner.nextInt();

        System.out.print(
                "Enter the end of opening week's closing month: "
        );

        int closeMonth =
                scanner.nextInt();

        System.out.print(
                "Enter the end of opening week's closing date: "
        );

        int closeDate =
                scanner.nextInt();

        System.out.print(
                "\nEnter the UTC offset of your location "
                        + "(Ex: -1, 0, 1): "
        );

        int offset =
                scanner.nextInt();

        while (offset < -12 || offset > 14) {

            System.out.print(
                    "Offset must be between -12 and +14. "
                            + "Try again: "
            );

            offset =
                    scanner.nextInt();
        }

        System.out.print(
                "\nEnter the start of the lunch hour "
                        + "(military time): "
        );

        int startHour =
                scanner.nextInt();

        System.out.print(
                "Minutes: "
        );

        int startMinutes =
                scanner.nextInt();

        System.out.print(
                "\nEnter the end of the lunch hour "
                        + "(military time): "
        );

        int endHour =
                scanner.nextInt();

        System.out.print(
                "Minutes: "
        );

        int endMinutes =
                scanner.nextInt();

        while (endHour < startHour
                || (endHour == startHour
                && endMinutes <= startMinutes)) {

            System.out.println(
                    "End time must be after start time."
            );

            System.out.print(
                    "Enter end hour: "
            );

            endHour =
                    scanner.nextInt();

            System.out.print(
                    "Enter end minutes: "
            );

            endMinutes =
                    scanner.nextInt();
        }

        System.out.print(
                "\nEnter the discount percentage for lunch: "
        );

        double lunchDiscount =
                scanner.nextDouble();

        System.out.print(
                "Enter tax percentage: "
        );

        int tax =
                scanner.nextInt();

        scanner.nextLine();

        System.out.println(
                "\n-ˋˏ ༻❁✿❀༺ ˎˊ- INFORMATION STORED -ˋˏ༻❁✿❀༺ ˎˊ-"
        );

        boolean running = true;

        while (running) {

            System.out.println(
                    "\nWould you like to access the "
                            + "ORDERING SYSTEM or CONTROL PANEL?"
            );

            System.out.println(
                    "Enter 1 for ORDERING SYSTEM "
                            + "and 2 for CONTROL PANEL:"
            );

            int menuChoice =
                    scanner.nextInt();

            scanner.nextLine();

            if (menuChoice == 1) {

                runOrderingSystem(
                        scanner,
                        location,
                        year,
                        month,
                        date,
                        offset,
                        lunchDiscount,
                        openYear,
                        openMonth,
                        openDate,
                        closeYear,
                        closeMonth,
                        closeDate,
                        startHour,
                        startMinutes,
                        endHour,
                        endMinutes,
                        tax
                );

            } else if (menuChoice == 2) {

                runControlPanel(
                        scanner,
                        manager
                );

            } else {

                System.out.println(
                        "Invalid option."
                );
            }

            System.out.print(
                    "\nContinue with Ordering/Control Panel? "
                            + "(yes/no): "
            );

            String choice =
                    scanner.nextLine();

            if (choice.equalsIgnoreCase("no")) {

                running = false;

                System.out.println(
                        "Exiting..."
                );
            }
        }
    }

    private static void runOrderingSystem(
            Scanner scanner,
            String location,
            int year,
            int month,
            int date,
            int offset,
            double lunchDiscount,
            int openYear,
            int openMonth,
            int openDate,
            int closeYear,
            int closeMonth,
            int closeDate,
            int startHour,
            int startMinutes,
            int endHour,
            int endMinutes,
            int tax) {

        Order order =
                new Order();

        boolean running = true;

        while (running) {

            System.out.println(
                    "\nWELCOME TO THE ORDER SYSTEM."
            );

            System.out.println(
                    "Enter 1 for in-person (CASHIER), "
                            + "2 for third-party app, "
                            + "or 3 for reservation:"
            );

            int platform =
                    scanner.nextInt();

            scanner.nextLine();

            if (platform == 1) {

                handleCashierOrder(scanner);

            } else if (platform == 2) {

                handleDeliveryOrder(scanner);

            } else if (platform == 3) {

                handleReservation(
                        scanner,
                        date,
                        month,
                        year
                );

            } else {

                System.out.println(
                        "Invalid option."
                );
            }

            System.out.print(
                    "\nContinue with ordering system? "
                            + "(1 yes, 2 no): "
            );

            int continueChoice =
                    scanner.nextInt();

            scanner.nextLine();

            if (continueChoice == 2) {
                running = false;
            }
        }
    }

    private static void handleCashierOrder(
            Scanner scanner) {

        System.out.print(
                "Enter cashier's name: "
        );

        String cashier =
                scanner.nextLine();

        while (cashier.trim().isEmpty()) {

            System.out.print(
                    "Name cannot be empty. "
                            + "Enter cashier's name: "
            );

            cashier =
                    scanner.nextLine();
        }

        System.out.print(
                "Would the customer like to Dine-in? "
                        + "(yes/no): "
        );

        String dineIn =
                scanner.nextLine();

        if (dineIn.equalsIgnoreCase("yes")) {

            collectItems(scanner);

        } else if (dineIn.equalsIgnoreCase("no")) {

            System.out.print(
                    "Would the customer like to Take-out? "
                            + "(yes/no): "
            );

            String takeout =
                    scanner.nextLine();

            if (takeout.equalsIgnoreCase("yes")) {
                collectItems(scanner);
            }
        }
    }

    private static String[] collectItems(
            Scanner scanner) {

        System.out.print(
                "Enter number of items to order: "
        );

        int number =
                scanner.nextInt();

        scanner.nextLine();

        String[] items =
                new String[number];

        for (int j = 0; j < number; j++) {

            boolean valid = false;

            while (!valid) {

                System.out.print(
                        "Enter name of item "
                                + (j + 1)
                                + ": "
                );

                items[j] =
                        scanner.nextLine();

                for (String menuItem :
                        Order.menu_items) {

                    if (menuItem.equalsIgnoreCase(
                            items[j])) {

                        valid = true;
                        break;
                    }
                }

                if (!valid) {

                    System.out.println(
                            "Invalid item. Please try again."
                    );
                }
            }
        }

        return items;
    }

    private static void handleDeliveryOrder(
            Scanner scanner) {

        System.out.println(
                "WELCOME TO DELIVERY SERVICES."
        );

        String[] items =
                collectItems(scanner);

        System.out.print(
                "Enter delivery year: "
        );

        int year =
                scanner.nextInt();

        System.out.print(
                "Enter delivery month: "
        );

        int month =
                scanner.nextInt();

        System.out.print(
                "Enter delivery date: "
        );

        int date =
                scanner.nextInt();

        System.out.print(
                "Enter delivery hour: "
        );

        int hour =
                scanner.nextInt();

        System.out.print(
                "Enter delivery minutes: "
        );

        int minutes =
                scanner.nextInt();

        scanner.nextLine();

        boolean validTransaction = false;

        while (!validTransaction) {

            System.out.print(
                    "\nEnter payment method "
                            + "(cash, debit, credit, e-transfer): "
            );

            String payment =
                    scanner.nextLine();

            System.out.print(
                    "Was the transaction successful? "
                            + "(1 yes, 2 no): "
            );

            int transaction =
                    scanner.nextInt();

            scanner.nextLine();

            boolean validPayment =
                    payment.equalsIgnoreCase("cash")
                            || payment.equalsIgnoreCase("debit")
                            || payment.equalsIgnoreCase("credit")
                            || payment.equalsIgnoreCase("e-transfer")
                            || payment.equalsIgnoreCase("etransfer");

            if (!validPayment) {

                System.out.println(
                        "Invalid purchase method."
                );

                continue;
            }

            if (transaction != 1
                    && transaction != 2) {

                System.out.println(
                        "Invalid response."
                );

                continue;
            }

            if (transaction == 1) {

                validTransaction = true;

                System.out.println(
                        "Transaction successful."
                );
            }
        }
    }

    private static void handleReservation(
            Scanner scanner,
            int date,
            int month,
            int year) {

        System.out.print(
                "Would you like to reserve an event space? "
                        + "(yes/no): "
        );

        String response =
                scanner.nextLine();

        if (!response.equalsIgnoreCase("yes")) {
            return;
        }

        Date today =
                new Date(
                        date,
                        month,
                        year
                );

        today.reservation(
                today,
                Order.space1isBooked,
                Order.space2isBooked,
                Order.space3isBooked
        );

        System.out.println(
                "Event space 1: Capacity of 10 people max."
        );

        System.out.println(
                "Event space 2: Capacity of 20 people max."
        );

        System.out.println(
                "Event space 3: Capacity of 30 people max."
        );

        System.out.print(
                "Enter event space number (1-3): "
        );

        int space =
                scanner.nextInt();

        System.out.print(
                "Enter day of month to reserve: "
        );

        int day =
                scanner.nextInt();

        scanner.nextLine();

        boolean successful = false;

        if (day >= 1 && day <= 35) {

            if (space == 1
                    && !Order.space1isBooked[day - 1]) {

                Order.space1isBooked[day - 1] =
                        true;

                successful = true;

            } else if (space == 2
                    && !Order.space2isBooked[day - 1]) {

                Order.space2isBooked[day - 1] =
                        true;

                successful = true;

            } else if (space == 3
                    && !Order.space3isBooked[day - 1]) {

                Order.space3isBooked[day - 1] =
                        true;

                successful = true;
            }
        }

        if (successful) {

            System.out.println(
                    "Reservation successful for day "
                            + day
                            + " in space "
                            + space
                            + "."
            );

        } else {

            System.out.println(
                    "Reservation failed. "
                            + "That day is already booked or invalid."
            );
        }
    }

    private static void runControlPanel(
            Scanner scanner,
            MenuManager manager) {

        boolean running = true;

        while (running) {

            System.out.print(
                    "Would you like to change the stock "
                            + "of an item? (yes/no): "
            );

            String response =
                    scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {

                System.out.print(
                        "Enter item name to change stock: "
                );

                String itemName =
                        scanner.nextLine();

                MenuItem selectedItem =
                        manager.getItemByName(
                                itemName
                        );

                if (selectedItem != null) {

                    System.out.println(
                            "Current stock for "
                                    + selectedItem.getName()
                                    + ": "
                                    + selectedItem.getStock()
                    );

                    System.out.print(
                            "Enter new stock value: "
                    );

                    int newStock =
                            scanner.nextInt();

                    scanner.nextLine();

                    selectedItem.setStock(
                            newStock
                    );

                    System.out.println(
                            "✅ Stock updated! New stock: "
                                    + selectedItem.getStock()
                    );

                } else {

                    System.out.println(
                            "❌ Item not found."
                    );
                }
            }

            System.out.println(
                    "\nDisplaying updated full menu:"
            );

            manager.showFeaturedItem();

            manager.displayAllCategories();

            System.out.print(
                    "\nContinue with control panel? "
                            + "(1 yes, 2 no): "
            );

            int choice =
                    scanner.nextInt();

            scanner.nextLine();

            if (choice == 2) {
                running = false;
            }
        }
    }
}