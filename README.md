# Kebab Haven — Restaurant Management Application

A Java-based restaurant management application designed to handle menu items, orders, discounts, memberships, and reservations for a Turkish restaurant.

## Features

* **Menu Management**

  * Organizes food and drink items by category
  * Supports different item types such as food and drinks
  * Displays menu items and prices

* **Order Management**

  * Creates and processes customer orders
  * Calculates order totals
  * Supports different ordering options

* **Discount System**

  * Percentage-based discounts
  * Buy-One-Get-One (BOGO) discounts
  * Time-based discounts

* **Membership System**

  * Stores customer membership information
  * Checks membership details during ordering

* **Reservations**

  * Handles restaurant reservations
  * Supports multiple reservation spaces
  * Includes custom date and calendar functionality

* **Object-Oriented Design**

  * Uses inheritance and polymorphism
  * Uses abstract classes for discounts
  * Separates application components into individual Java classes

## Project Structure

```text
Restaurant_Management_Application/
│
├── src/
│   ├── Restaurant_Management_Application.java
│   ├── MenuItem.java
│   ├── FoodItem.java
│   ├── DrinkItem.java
│   ├── Discount.java
│   ├── PercentageDiscount.java
│   ├── BOGODiscount.java
│   ├── TimeBasedDiscount.java
│   ├── MenuManager.java
│   ├── Membership.java
│   ├── Order.java
│   └── Date.java
│
└── README.md
```

## Technologies

* Java
* Object-Oriented Programming
* Java Collections
* Java Time API
* File I/O

## OOP Concepts Demonstrated

This project demonstrates several core object-oriented programming concepts:

* **Inheritance** — `FoodItem` and `DrinkItem` extend `MenuItem`
* **Abstraction** — `Discount` is an abstract class
* **Polymorphism** — Different discount types implement their own discount calculations
* **Encapsulation** — Application functionality is organized into separate classes
* **Composition** — Orders interact with menu items, memberships, and discounts

