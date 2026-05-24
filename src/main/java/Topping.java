public class Topping {
    private String name;
    private ToppingCategory category;
    private boolean premium;
    private boolean extra;

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", premium=" + premium +
                ", extra=" + extra +
                '}';
    }

    public Topping(String name, ToppingCategory category, boolean premium, boolean extra) {
        this.name = name;
        this.category = category;
        this.premium = premium;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public ToppingCategory getCategory() {
        return category;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isExtra() {
        return extra;
    }
}
