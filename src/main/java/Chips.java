public class Chips implements Product{
    @Override
    public String toString() {
        return "Chips";
    }

    @Override
    public double getTotal() {
        return 1.50;
    }
}
