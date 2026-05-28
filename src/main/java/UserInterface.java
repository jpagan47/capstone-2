import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {
    private final Scanner myScanner = new Scanner(System.in);
    private Order currentOrder;
    private final ArrayList<String> meats = new ArrayList<>(Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon"));
    private final ArrayList<String> cheeses = new ArrayList<>(Arrays.asList("American", "Provolone", "Cheddar", "Swiss"));
    private final ArrayList<String> regularToppings = new ArrayList<>(Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
    private final ArrayList<String> sauces = new ArrayList<>(Arrays.asList("Mayo", "Mustard", "ketchup", "Ranch", "Thousand Islands", "Vinaigrette", "Au jus", "Sauce on the side"));

    public UserInterface() {

    }

    public void display() {
        homeScreen();
    }

    private void homeScreen() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    
                    𖡼.𖤣𖥧𖡼.𖤣𖥧    Jose's Deli    𖡼.𖤣𖥧𖡼.𖤣𖥧
                               🥤🥗🍔🍗🍟🥓
                                1) New Order
                                  0) Exit
                                  🥐🍰🧺☕️
                    """);
            try {
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
                        System.err.println("❌Invalid entry please try again❌ ");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("❌Please ENTER a valid number.❌");

            }

        }


    }

    private void orderScreen() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    1) Add Sandwich 🍞
                    2) Add Drink 🍷
                    3) Add Chips 🍟
                    4) Checkout 📠
                    5) Cancel Order ❌
                    """);
            try {
                int userInput1 = Integer.parseInt(myScanner.nextLine());
                switch (userInput1) {
                    case 1:
                        addingSandwich();
                        break;
                    case 2:
                        addingDrink();
                        break;
                    case 3:
                        addingChips();
                        break;
                    case 4:
                        //Verifying that the order has at least one item in it
                        if (currentOrder.getTotal() == 0) {
                            System.err.println("You must add at least one item from our menu!⚠");
                            break;
                        }
                        //Displaying the receipt before saving it to a new .txt file and then deleting it
                        System.out.println(currentOrder.getOrderSummary());
                        System.out.println("1) Yes, complete my order ✅");
                        System.out.println("2) No, cancel it ❌");
                        int confirm = Integer.parseInt(myScanner.nextLine());
                        switch (confirm) {
                            case 1:
                                //Saving my order to my receipt
                                ReceiptManager receiptManager = new ReceiptManager();
                                receiptManager.saveReceipt(currentOrder);
                                break;
                            case 2:
                                System.out.println("\nReturning to Main Menu.....\n");
                                break;
                        }
                        //Exiting the order and making a new empty order
                        currentOrder = new Order();
                        running = false;
                        break;
                    case 5:
                        currentOrder = new Order();
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid Selection please try again❌");

                }
            } catch (NumberFormatException nfe) {
                System.err.println("Please ENTER a valid number.❌");
            }

        }

    }

    private void addingChips() {
        Chips chips = new Chips();
        currentOrder.addChips(chips);
        System.out.println("Chips was added to your Order!✅\n");
    }

    private void addingDrink() {
        System.out.println("""
                What size drink would you like ?
                1) Small
                2) Medium
                3) Large
                """);
        try {
            int drinkSizeUserSelection = Integer.parseInt(myScanner.nextLine());
            DrinkSize drinkSize = null;
            switch (drinkSizeUserSelection) {
                case 1:
                    drinkSize = DrinkSize.SMALL;
                    System.out.println("\nDrink was added to your Order!✅\n");
                    break;
                case 2:
                    drinkSize = DrinkSize.MEDIUM;
                    System.out.println("\nDrink was added to your Order!✅\n");
                    break;
                case 3:
                    drinkSize = DrinkSize.LARGE;
                    System.out.println("\nDrink was added to your Order!✅\n");
                    break;

                default:
                    System.err.println("Invalid selection please try again!❌");
            }
            Drink drink = new Drink(drinkSize);
            currentOrder.addDrink(drink);


        } catch (NumberFormatException nfe) {
            System.err.println("Please ENTER a valid number.❌");
        }

    }

    private void addingSandwich() {

        {
            boolean running = true;
            while (running) {

                System.out.println("""
                        Which type bread would you like?
                        1) White
                        2) Wheat
                        3) Rye
                        4) Wrap
                        """);
                String breadInput = myScanner.nextLine();
                BreadType selectedBread;
                switch (breadInput) {
                    case "1":
                        selectedBread = BreadType.WHITE;
                        running = false;
                        break;
                    case "2":
                        selectedBread = BreadType.WHEAT;
                        running = false;
                        break;
                    case "3":
                        selectedBread = BreadType.RYE;
                        running = false;
                        break;
                    case "4":
                        selectedBread = BreadType.WRAP;
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid Input please try again!❌");
                        continue;
                }
                SandwichSize sandwichSize = null;

                running = true;
                while (running) {
                    System.out.println("""
                            Which Sandwich size would you like?
                            1) Small (4")
                            2) Medium (8")
                            3) Large (12")
                            """);
                    String selectSize = myScanner.nextLine();
                    switch (selectSize) {
                        case "1":
                            sandwichSize = SandwichSize.FOUR;
                            running = false;
                            break;
                        case "2":
                            sandwichSize = SandwichSize.EIGHT;
                            running = false;
                            break;
                        case "3":
                            sandwichSize = SandwichSize.TWELVE;
                            running = false;
                            break;
                        default:
                            System.err.println("Invalid Input please try again!❌");


                    }

                }
                System.out.println("""
                        Would you like your Sandwich toasted?
                        1) Yes✅
                        2) No ❌
                        """);
                int toastedInput = Integer.parseInt(myScanner.nextLine());
                boolean isToasted = toastedInput == 1;

                //Assigning values to my Sandwich, using all the user inputs
                Sandwich sandwich = new Sandwich(sandwichSize, selectedBread, isToasted);

                addingMeat(sandwich);
                addingCheese(sandwich);
                addingRegToppings(sandwich);
                addingSauces(sandwich);
                currentOrder.addSandwich(sandwich);

            }
        }
    }

    private void addingMeat(Sandwich sandwich) {
        //Printing out my List of Meats one by one
        printList(meats);
        String selectedMeat = myScanner.nextLine();
        switch (selectedMeat) {
            case "1":
                sandwich.setMeat(Meat.Steak);
                break;
            case "2":
                sandwich.setMeat(Meat.Ham);
                break;
            case "3":
                sandwich.setMeat(Meat.Salami);
                break;
            case "4":
                sandwich.setMeat(Meat.Roast_Beef);
                break;
            case "5":
                sandwich.setMeat(Meat.Chicken);
                break;
            case "6":
                sandwich.setMeat(Meat.Bacon);
                break;
            case "7":
                break;
            default:
                System.err.println("Invalid Input please try again!❌");
        }
    }

    private void addingCheese(Sandwich sandwich) {
        printList(cheeses);
        String selectedCheese = myScanner.nextLine();
        switch (selectedCheese) {
            case "1":
                sandwich.setCheese(Cheese.American);
                break;
            case "2":
                sandwich.setCheese(Cheese.Provolone);
                break;
            case "3":
                sandwich.setCheese(Cheese.Cheddar);
                break;
            case "4":
                sandwich.setCheese(Cheese.Swiss);
                break;
            default:
                System.err.println("Invalid Input please try again!❌");
        }
    }

    private void addingRegToppings(Sandwich sandwich) {
        printList(regularToppings);
        String selectedTopping = myScanner.nextLine();
        switch (selectedTopping) {
            case "1":
                sandwich.setRegularTopping(RegularTopping.LETTUCE);
                break;
            case "2":
                sandwich.setRegularTopping(RegularTopping.PEPPERS);
                break;
            case "3":
                sandwich.setRegularTopping(RegularTopping.ONIONS);
                break;
            case "4":
                sandwich.setRegularTopping(RegularTopping.TOMATOES);
                break;
            case "5":
                sandwich.setRegularTopping(RegularTopping.JALAPENOS);
                break;
            case "6":
                sandwich.setRegularTopping(RegularTopping.CUCUMBERS);
                break;
            case "7":
                sandwich.setRegularTopping(RegularTopping.PICKLES);
                break;
            case "8":
                sandwich.setRegularTopping(RegularTopping.GUACAMOLE);
                break;
            case "9":
                sandwich.setRegularTopping(RegularTopping.MUSHROOMS);
                break;
            default:
                System.err.println("Invalid Input please try again!❌");
        }
    }

    private void addingSauces(Sandwich sandwich) {
        printList(sauces);
        String selectSauces = myScanner.nextLine();
        switch (selectSauces) {
            case "1":
                sandwich.setSauce(Sauce.MAYO);
                break;
            case "2":
                sandwich.setSauce(Sauce.MUSTARD);
                break;
            case "3":
                sandwich.setSauce(Sauce.KETCHUP);
                break;
            case "4":
                sandwich.setSauce(Sauce.RANCH);
                break;
            case "5":
                sandwich.setSauce(Sauce.THOUSAND_ISLANDS);
                break;
            case "6":
                sandwich.setSauce(Sauce.VINAIGRETTE);
                break;
            case "7":
                sandwich.setSauce(Sauce.AU_JUS);
                break;
            case "8":
                sandwich.setSauce(Sauce.SIDE_OF_SAUCE);
                break;
            default:
                System.err.println("Invalid Input please try again!❌");
        }
    }

    public void printList(ArrayList<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ")" + items.get(i));

        }

    }

    public void exitScreen() {
        System.out.println("""
                            ✰✰✰✰✰✰✰✰
                .𖥔 ݁ ˖╭ ┆THANK YOU COME AGAIN! ╰⊹ ࣪
                            ✦·┈๑⋅⋯ ⋯⋅๑┈·✦
                """);
    }

}