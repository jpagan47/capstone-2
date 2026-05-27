import java.util.ArrayList;

public class Sandwich implements Product {
    private final SandwichSize size;
    private final BreadType breadType;
    private final boolean toasted;
    private final ArrayList<Topping> toppings;

    @Override
    public String toString() {
        String sanwichInfo = "Sandwich\n" +
                "Size: " + size +" inches" +"\n" +
                "Bread Type: " + breadType + "\n" +
                "Toasted: " + toasted + "\n";
        sanwichInfo += "\n Toppings: \n";
        for (Topping topping : toppings) {
            sanwichInfo += "-" + topping.getName() + "\n";
        }
        return sanwichInfo;
    }

    public Sandwich(SandwichSize size, BreadType breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
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
            if (topping.isExtra()) {
                if (topping.getCategory() == ToppingCategory.CHEESE) {
                    switch (size) {
                        case FOUR -> total += .30;
                        case EIGHT -> total += .60;
                        case TWELVE -> total += .90;
                    }
                }
                if (topping.getCategory() == ToppingCategory.MEAT) {
                    switch (size) {
                        case FOUR -> total += .50;
                        case EIGHT -> total += 1.00;
                        case TWELVE -> total += 1.50;
                    }
                }
            }

        }
        return total;
    }
}



