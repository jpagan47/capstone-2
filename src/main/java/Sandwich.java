import java.util.ArrayList;

public class Sandwich implements Product{
    private SandwichSize size;
    private BreadType breadType;
    private Boolean toasted;
    private ArrayList<Topping> toppings ;

    public Sandwich(SandwichSize size,BreadType breadType, Boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }


    @Override
    public double getTotal() {
        return 0;
    }
}
