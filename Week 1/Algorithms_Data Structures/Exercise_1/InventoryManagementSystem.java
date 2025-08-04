/*
Inventory Management System
Scenario: 
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
Steps:
1.Understand the Problem:
  Explain why data structures and algorithms are essential in handling large inventories.
  Discuss the types of data structures suitable for this problem.
2.Setup:
  Create a new project for the inventory management system.
3.Implementation:
  Define a class Product with attributes like productId, productName, quantity, and price.
  Choose an appropriate data structure to store the products (e.g., ArrayList, HashMap).
  Implement methods to add, update, and delete products from the inventory.
4.Analysis:
  Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.
  Discuss how you can optimize these operations.
*/

// Main.java
package Inventory;

public class Main {
	public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(101, "Mouse", 50, 499.99);
        Product p2 = new Product(102, "Keyboard", 30, 899.50);
        Product p3 = new Product(103, "Monitor", 20, 7499.00);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        manager.displayInventory();

        manager.updateProduct(102, 25, 850.00);
        manager.deleteProduct(101);

        manager.displayInventory();
    }
}

// Inventory.java
package Inventory;

public class Product {
	private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: ₹" + price;
    }
    
    
}

// InventoryManager.java
package Inventory;
import java.util.HashMap;

public class InventoryManager {
	private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Product deleted: " + removed);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current Inventory:");
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }
}
