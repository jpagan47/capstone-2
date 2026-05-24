import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;



    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public double getTotal() {
        double total = 0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getTotal();
        }
        for (Drink drink : drinks) {
            total += drink.getTotal();
        }
        for (Chips chip : chips) {
            total += chip.getTotal();
        }

        return total;
    }
    public String getOrderSummary(){
        String summary = "\n===Receipt===\n";
        for (Sandwich sandwich: sandwiches){
            summary += sandwich +"\n";
        }
        for(Drink drink: drinks){
            summary+= drink + "\n";
        }
        for(Chips chip : chips){
            summary+= chip + "\n";
        }
        summary += "\nTOTAL: $" + getTotal() + "\n";
        return summary;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<Chips> getChips() {
        return chips;
    }
}
