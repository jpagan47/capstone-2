import EnumFolder.BreadType;
import EnumFolder.RegularTopping;

import java.util.ArrayList;

public class Sandwich implements Product {
    private final SandwichSize size;
    private Meat meat;
    private boolean extraMeat;
    private Cheese cheese;
    private boolean extraCheese;
    private final BreadType breadType;
    private final boolean toasted;
    //Storing all my sauces in this list
    private final ArrayList<Sauce> sauces = new ArrayList<>();
    private Sauce sauce;
    //Store all my toppings in this list
    private final ArrayList<RegularTopping> regularToppings;

    //CONSTRUCTOR
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
            sandwichInfo += "Extra Meat: Yes\n";
        }
        if (cheese != null) {
            sandwichInfo += "Cheese: " + cheese + "\n";
        }
        if (extraMeat) {
            sandwichInfo += "Extra Cheese: Yes\n";
        }
        if (sauce != null) {
            sandwichInfo += "Sauce: \n" + sauce;
        }
        sandwichInfo += "\nToppings: \n";

        for (RegularTopping topping : regularToppings) {
            sandwichInfo += "- " + topping + "\n";
        }
        if (!sauces.isEmpty()) {
            sandwichInfo += "Sauces:\n";
            for (Sauce sauce : sauces) {
                sandwichInfo += "- " + sauce.toString().replace("_", " ") + "\n";
            }
        }
        return sandwichInfo;
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

    public boolean addRegularTopping(RegularTopping regularTopping) {
        if(regularToppings.contains(regularTopping)){
            return false;
        }
        regularToppings.add(regularTopping);
        return true;
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

    public boolean addSauce(Sauce sauce) {
        if (sauces.contains(sauce)){
            return false;
        }
        sauces.add(sauce);
        return true;
    }

}



