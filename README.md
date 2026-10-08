# Java Store System

A console-based store management application written in Java. It lets you manage products, customers, and orders through a simple text menu.

## Features

- **Products:** add products with a unique ID, name, price, and stock. Input is validated (no duplicate IDs, no negative prices or stock, no non-numeric input).
- **Customers:** register and list customers.
- **Orders:** create an order for an existing customer by selecting products from the store. Stock is reduced automatically when a product is added to an order.
- **Order lookup:** search and display an order by its ID.

## Tech

- Java
- Object-oriented design with separate classes: `Store`, `Product`, `Customer`, `Order`
- Collections (`ArrayList`), input handling with `Scanner`, and exception handling (`InputMismatchException`)

## How to run

Requires a JDK installed.

```bash
javac -d bin src/*.java
java -cp bin Main
```

## Menu

```
1. Add Product
2. Show Products
3. Add Customer
4. Show Customers
5. Create Order
6. Show Order
7. Exit
```

## Limitations and next steps

- Data is stored in memory only, so it is lost when the program closes.
- Next steps: save data to a file or database, validate customer and order IDs, allow product quantities in an order, and add unit tests.

## Author

Jonathan Avella  - Computer Science student at FIU