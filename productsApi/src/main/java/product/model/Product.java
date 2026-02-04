package product.model;

public class Product {
    // Atributos
    private String name;
    private long id;
    private double price;

    // Construtor
    public Product(double price, String name, long id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }
}
