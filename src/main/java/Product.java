public abstract class Product {
    protected String name;

    public Product(String name) {
        this.name = name;
    }

    public abstract double calculatePrice();
}
