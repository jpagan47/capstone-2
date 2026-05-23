import java.util.Scanner;

public class UserInterface {
    private Scanner myScanner = new Scanner(System.in);
    private Order currentOrder;

    public UserInterface() {

    }

    public void display() {
        homeScreen();
    }

    private void homeScreen() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    1) New Order
                    0) Exit
                    """);
            int userInput = Integer.parseInt(myScanner.nextLine());
            switch (userInput) {
                case 1:
                    currentOrder = new Order();
                    orderScreen();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.err.println("Invalid entry please try again ");
            }
        }


    }

    private void orderScreen() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    5) Cancel Order
                    """);
            int userInput1 = Integer.parseInt(myScanner.nextLine());
            switch (userInput1) {
                case 1:
                    System.out.println("""
                            Which type bread would you like?
                            1) White
                            2) Wheat
                            3) Rye
                            4) Wrap
                            """);
                    int breadInput = Integer.parseInt(myScanner.nextLine());
                    BreadType selectedBread = null;
                    switch (breadInput) {
                        case 1:
                            selectedBread = BreadType.WHITE;
                            break;
                        case 2:
                            selectedBread = BreadType.WHEAT;
                            break;
                        case 3:
                            selectedBread = BreadType.RYE;
                            break;
                        case 4:
                            selectedBread = BreadType.WRAP;
                            break;
                        default:
                            System.err.println("Invalid Input please try again!");
                    }
                    SandwichSize sandwichSize = null;
                    System.out.println("""
                            Which Sandwich size would you like?
                            1) Small (4")
                            2) Medium (8")
                            3) Large (12")
                            """);
                    int selectSize = Integer.parseInt(myScanner.nextLine());
                    switch (selectSize) {
                        case 1:
                            sandwichSize = SandwichSize.FOUR;
                            break;
                        case 2:
                            sandwichSize = SandwichSize.EIGHT;
                            break;
                        case 3:
                            sandwichSize = SandwichSize.TWELVE;
                            break;
                        default:
                            System.err.println("Invalid Input please try again!");
                    }
                    System.out.println("""
                            Would you like your Sandwich toasted?
                            1) Yes
                            2) No
                            """);
                    int toastedInput = Integer.parseInt(myScanner.nextLine());
                    boolean isToasted = toastedInput == 1;

                    Sandwich sandwich = new Sandwich(sandwichSize, selectedBread, isToasted);
                    promptForTopping(sandwich, "Steak", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "Ham", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "Salami", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "Roast Beef", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "Chicken", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "Bacon", ToppingCategory.MEAT, true);
                    promptForTopping(sandwich, "American Cheese", ToppingCategory.CHEESE, true);
                    promptForTopping(sandwich, "Provolone Cheese", ToppingCategory.CHEESE, true);
                    promptForTopping(sandwich, "Cheddar Cheese", ToppingCategory.CHEESE, true);
                    promptForTopping(sandwich, "Swiss Cheese", ToppingCategory.CHEESE, true);
                    promptForTopping(sandwich, "Lettuce", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Peppers", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Onions", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Tomatoes", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Jalapenos", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Cucumbers", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Pickles", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Guacamole", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Mushrooms", ToppingCategory.REGULAR, false);
                    promptForTopping(sandwich, "Mayo", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Mustard", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Ketchup", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Ranch", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Thousand Islands", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Vinaigrette", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "au jus on the side", ToppingCategory.SAUCE, false);
                    promptForTopping(sandwich, "Sauce on the side", ToppingCategory.SAUCE, false);

                    //Assigning values to my Sandwich, using all the user inputs
                    currentOrder.addSandwich(sandwich);
                    System.out.println("\nSandwich added to your order!\n");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    currentOrder = null;
                    running = false;
                    break;
            }

        }

    }

    //Making a method to prompt the user topping by topping to reduce chance of user error
    private void promptForTopping(Sandwich sandwich, String toppingName, ToppingCategory category, boolean isPremium) {
        System.out.println(" Would you like " + toppingName + " ? (Y)es / (N)o");
        String userInput = myScanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            sandwich.addTopping(new Topping(toppingName, category, isPremium, false));
            if (isPremium) {
                promptForExtraToppings(sandwich, toppingName, category, isPremium);
            }
        }
    }

    private void promptForExtraToppings(Sandwich sandwich, String toppingName, ToppingCategory category, boolean isPremium) {
        System.out.println("Would you like Extra " + toppingName + " ? (Y)es / (N)o ");
        String userInput = myScanner.nextLine();
        if (userInput.equalsIgnoreCase("y")) {
            sandwich.addTopping(new Topping(toppingName, category, isPremium, true));
        }
    }
}
