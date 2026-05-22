public class Drink implements Product{
    private DrinkSize drinkSize;

    public Drink(DrinkSize drinkSize){
        this.drinkSize = drinkSize;
    }

    @Override
    public double getTotal() {
        return 0;
    }
}
