import java.util.ArrayList;

public class Sandwich implements Product {
    private SandwichSize size;
    private BreadType breadType;
    private boolean toasted;
    private ArrayList<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }


    @Override
    public double getTotal() {
        double total = 0;
        switch (size) {
            case FOUR -> total = 5.50;
            case EIGHT -> total = 7.00;
            case TWELVE -> total = 8.50;
        }
        for (Topping topping : toppings) {
            if (topping.isPremium()) {
                if (topping.getCategory() == ToppingCategory.MEAT) {
                    switch (size) {
                        case FOUR -> total += 1;
                        case EIGHT -> total += 2;
                        case TWELVE -> total += 3;
                    }
                }
                if (topping.getCategory() == ToppingCategory.CHEESE) {
                    switch (size) {
                        case FOUR -> total += .75;
                        case EIGHT -> total += 1.50;
                        case TWELVE -> total += 2.25;
                    }
                }
            }

        }
        return total;
    }
}
