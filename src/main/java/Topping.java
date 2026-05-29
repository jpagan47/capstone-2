public class Topping {
    private final String name;
    private final ToppingCategory category;
    private final boolean premium;
    private final boolean extra;

    //CONSTRUCTOR
    public Topping(String name, ToppingCategory category, boolean premium, boolean extra) {
        this.name = name;
        this.category = category;
        this.premium = premium;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", premium=" + premium +
                ", extra=" + extra +
                '}';
    }
}


