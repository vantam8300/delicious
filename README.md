# DELI-cious

This is a Java-based order processing system that enables customers to place orders for items (such as sandwiches, drinks, and chips). The system provides a checkout screen where orders can be confirmed or canceled, and receipts are saved as text files with a unique timestamp-based filename in a `receipts` directory.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [File Format](#file-format)

---

## Features

- **Order Creation**: Create orders with multiple items (e.g., sandwiches, drinks, chips).
- **Item Deletion**: Delete added Items within an order.
- **Item Modification**: Update added Items within an order.
- **Receipt Generation**: Save each completed order as a uniquely named receipt in `.txt` format. Automatically stores each receipt in a `receipts` directory
- **Checkout Options**: Confirm or cancel orders with checkout screen.

## Technologies Used

- **Java**: Core programming language.
- **Java I/O**: Used for file handling and receipt generation.
- **LocalDateTime**: To generate date-based file names for receipts.

---

## Setup and Installation

### Prerequisites

- [Java 11+](https://www.oracle.com/java/technologies/javase-downloads.html)
- Basic knowledge of Java

### Installation

1. Clone or download this project to your local machine.
2. Compile and run the application using your IDE or by executing the following command in your terminal:
    ```bash
    javac Application.java
    java Application
    ```
Enter the respective letter to perform the desired action.
## Application Screens and Actions

The **DELI-cious** application provides a simple, intuitive interface for creating and managing orders. Each screen offers specific actions that guide the user through the process of adding items, customizing sandwiches, and completing orders.

### Home Screen
The Home Screen is the starting point of the application. Users can initiate a new order or exit the program.

- **Options**:
   - `1) New Order`: Starts a new order and navigates to the **Order Screen**.
   - `0) Exit`: Closes the application.

### Order Screen
The Order Screen allows users to add items to their order, proceed to checkout, or cancel the order.

- **Options**:
   - `1) Add Sandwich`: Opens the **Add Sandwich Screen** to customize and add a sandwich to the order.
   - `2) Add Drink`: Opens the **Add Drink Screen** to select a drink size and flavor.
   - `3) Add Chips`: Opens the **Add Chips Screen** to select a type of chips.
   - `4) Add BLT`: Opens the **Add Sandwich Screen** to customize and add a BLT signature sandwich to the order.
   - `5) Add Philly Cheese Steak`: Opens the **Add Sandwich Screen** to customize and add a Philly Cheese Steak signature sandwich to the order.
   - `6) Remove Item`: Display a list of items and select item to remove
   - `7) Modify Item`: Display a list of items and select item to modify
   - `8) Checkout`: Moves to the **Checkout Screen**, displaying a summary of the order for review.
   - `0) Cancel Order`: Discards the current order and returns to the Home Screen.

### Add Sandwich Screen
The Add Sandwich Screen guides users through the steps of customizing a sandwich. Users can select bread type, size, toppings, sauces, and an option to toast the sandwich.

- **Steps**:
   1. **Select Bread Type**: Choose from white, wheat, rye, or wrap.
   2. **Select Sandwich Size**: Choose a size (4", 8", or 12") to determine the base price.
   3. **Select Toppings**: Add from a variety of toppings:
      - **Meats** (premium): Includes steak, ham, salami, roast beef, chicken, and bacon.
      - **Cheeses** (premium): Includes American, provolone, cheddar, and Swiss.
      - **Regular Toppings**: Includes lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, and mushrooms.
      - **Select Sauces**: Choose from sauces like mayo, mustard, ketchup, ranch, thousand islands, and vinaigrette.
   4. **Toasting Option**: Choose whether the sandwich should be toasted.
   5. **Confirmation**: Once all choices are made, the sandwich is added to the order, and the user is returned to the **Order Screen**.

### Add Drink Screen
The Add Drink Screen allows users to add a drink to their order by selecting size and flavor.

- **Options**:
   - **Drink Size**: Choose from `Small`, `Medium`, or `Large`.
   - **Drink Flavor**: Select a drink flavor (options vary by shop availability).
  
After selection, the drink is added to the order, and the user returns to the **Order Screen**.

### Add Chips Screen
The Add Chips Screen provides an option to add chips to the order.

- **Options**:
   - **Chip Type**: Select a type of chips (e.g., regular, BBQ, sour cream, etc.).

Once selected, the chips are added to the order, and the user is returned to the **Order Screen**.

### Checkout Screen
The Checkout Screen displays a summary of the order, including all items added, their quantities, and the total cost.

- **Actions**:
   - **Confirm**: Saves the order as a receipt file in the `receipts` folder with a filename formatted by date and time (e.g., `yyyyMMdd-hhmmss.txt`). The application then returns to the Home Screen.
   - **Cancel**: Discards the current order and returns the user to the Home Screen without saving the receipt.

---

Each screen in **DELI-cious** is designed to streamline the ordering process, from selecting individual items to confirming an order and generating a receipt.

---

## File Format

Each receipt file is saved with a unique, timestamp-based name:

- **File Naming**: `yyyyMMdd-HHmmss.txt` (e.g., `20231113-102530.txt`)

- **Content Example**:

   ```plaintext
  Order ID: 0757b955-b7d9-44d5-90eb-20aad734ad1b
  Date: 2024-11-14 21:36:43
  Items:
  ----------------------------------------------------------------------
  Name                           Size            Quantity        Price
  ----------------------------------------------------------------------
  White Sandwich                 8 Inches        1               $10.50
  Toppings:
  - Bacon
    - Cheddar
    - Lettuce
    - Ranch
  Coke Drink                     small           1               $2.00
  Total Cost: $12.50  
```