import java.util.ArrayList;

public class Sandwich implements Product {
    private final SandwichSize size;
    private Meat meat;
    private boolean extraMeat;
    private Cheese cheese;
    private boolean extraCheese;
    private final BreadType breadType;
    private final boolean toasted;
    private Sauce sauce;
    //Store all my toppings in this list
    private ArrayList<RegularTopping> regularToppings;

    public Sandwich(SandwichSize size, BreadType breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.regularToppings = new ArrayList<>();
    }

    @Override
    public String toString() {
        String sandwichInfo = "Sandwich\n" +
                "Size: " + size + " inches" + "\n" +
                "Bread Type: " + breadType + "\n" +
                "Toasted: " + toasted + "\n";
        if (meat != null) {
            sandwichInfo += "Meat:" + meat + "\n";
        }
        if (extraMeat) {
            sandwichInfo += "Extra Meat: Yes/no";
        }
        if (cheese != null) {
            sandwichInfo += "Cheese" + cheese + "\n";
        }
        if (extraMeat) {
            sandwichInfo += "Extra Cheese: Yes/no";
        }
        if (sauce != null) {
            sandwichInfo += "Sauce: " + sauce + "\n";
        }
        sandwichInfo += "\n Toppings: \n";

        for (RegularTopping topping : regularToppings) {
            sandwichInfo += "- " + topping + "\n";
        }
        return sandwichInfo;
    }

    public void addRegularTopping(RegularTopping regularTopping) {
        regularToppings.add(regularTopping);
    }

    public ArrayList<RegularTopping> getToppings() {
        return regularToppings;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void addTopping(RegularTopping regularTopping) {
        if (this.regularToppings.contains(regularTopping)) {
            return;
        }
        this.regularToppings.add(regularTopping);
    }

    public boolean hasTopping(RegularTopping regularTopping) {
        return this.regularToppings.contains(regularTopping);
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    @Override
    public double getTotal() {
        double total = 0;
        switch (size) {
            case FOUR -> total = 5.50;
            case EIGHT -> total = 7.00;
            case TWELVE -> total = 8.50;
        }
        if (meat != null) {
            switch (size) {
                case FOUR -> total += 1.00;
                case EIGHT -> total += 2.00;
                case TWELVE -> total += 3.00;
            }
            if (extraMeat) {
                switch (size) {
                    case FOUR -> total += 0.50;
                    case EIGHT -> total += 0.75;
                    case TWELVE -> total += 1.00;
                }
            }
        }
        if (cheese != null) {
            switch (size) {
                case FOUR -> total += 0.75;
                case EIGHT -> total += 1.50;
                case TWELVE -> total += 2.25;
            }
            if (extraCheese) {
                switch (size) {
                    case FOUR -> total += 0.30;
                    case EIGHT -> total += 0.60;
                    case TWELVE -> total += 0.90;
                }
            }
        }
        return total;
    }
}



