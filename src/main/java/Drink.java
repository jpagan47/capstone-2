public class Drink implements Product{
    private DrinkSize drinkSize;

    public Drink(DrinkSize drinkSize){
        this.drinkSize = drinkSize;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkSize=" + drinkSize +
                '}';
    }

    @Override
    public double getTotal() {
        double total = 0;
        switch (drinkSize){
            case SMALL -> total= 2.00;
            case MEDIUM -> total = 2.50;
            case LARGE -> total = 3.00;

        }
        return total;
    }
}
