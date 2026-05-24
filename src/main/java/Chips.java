public class Chips implements Product{
    @Override
    public String toString() {
        return "-A bag of Chips";
    }

    @Override
    public double getTotal() {
        return 1.50;
    }
}
