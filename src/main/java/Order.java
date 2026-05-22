import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private  ArrayList<Chips> chips;

    public Order(ArrayList<Sandwich> sandwiches, ArrayList<Drink> drinks, ArrayList<Chips> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }


}
