import java.util.HashMap;
import java.util.Map;

class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public void updateStock(int quantity) {
        stock += quantity;
    }

    public void removeStock(int quantity) {
        stock -= quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + "\nPrice: $" + price + "\nStock: " + stock;
    }
}

class InventoryManagementSystem {
    private Map<String, Product> products;

    public InventoryManagementSystem() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price, int stock) {
        Product product = new Product(name, price, stock);
        products.put(name, product);
    }

    public void updateProduct(String name, int quantity) {
        if (products.containsKey(name)) {
            Product product = products.get(name);
            product.updateStock(quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void removeProduct(String name) {
        if (products.containsKey(name)) {
            products.remove(name);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void checkStock(String name) {
        if (products.containsKey(name)) {
            Product product = products.get(name);
            System.out.println(product);
        } else {
            System.out.println("Product not found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding products
        inventory.addProduct("Phone", 599.99, 10);
        inventory.addProduct("Laptop", 1299.99, 5);
        inventory.addProduct("Headphones", 99.99, 20);

        // Updating product stock
        inventory.updateProduct("Phone", 5);

        // Removing a product
        inventory.removeProduct("Laptop");

        // Checking stock
        inventory.checkStock("Phone");
        inventory.checkStock("Laptop");
    }
}
