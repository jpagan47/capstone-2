import EnumFolder.BreadType;
import EnumFolder.DrinkSize;
import EnumFolder.RegularTopping;

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

            String userInput = myScanner.nextLine();
            switch (userInput) {
                case "1":
                    currentOrder = new Order();
                    orderScreen();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.err.println("❌Invalid entry please try again❌ ");
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
                    6) Add Signature Sandwich
                    """);
            String userInput1 = myScanner.nextLine();
            switch (userInput1) {
                case "1":
                    addingSandwich();
                    break;
                case "2":
                    addingDrink();
                    break;
                case "3":
                    addingChips();
                    break;
                case "4":
                    //Verifying that the order has at least one item in it
                    if (currentOrder.getTotal() == 0) {
                        System.err.println("You must add at least one item from our menu!⚠");
                        break;
                    }
                    //Displaying the receipt before saving it to a new .txt file and then deleting it
                    System.out.println(currentOrder.getOrderSummary());
                    System.out.println("1) Yes, complete my order ✅");
                    System.out.println("2) No, cancel it ❌");
                    String confirm = myScanner.nextLine();
                    switch (confirm) {
                        case "1":
                            //Saving my order to my receipt
                            ReceiptManager receiptManager = new ReceiptManager();
                            receiptManager.saveReceipt(currentOrder);
                            break;
                        case "2":
                            System.out.println("\nReturning to Main Menu.....\n");
                            break;
                    }
                    //Exiting the order and making a new empty order
                    currentOrder = new Order();
                    running = false;
                    break;
                case "5":
                    currentOrder = new Order();
                    running = false;
                    break;
                case "6":
                    addingSignatureSandwich();
                    break;
                default:
                    System.err.println("Invalid Selection please try again❌");

            }

        }

    }

    private void addingChips() {
        Chips chips = new Chips();
        currentOrder.addChips(chips);
        System.out.println("Chips was added to your Order!✅\n");
    }

    private void addingDrink() {
        DrinkSize drinkSize = null;
        boolean running = true;
        while (running) {
            System.out.println("""
                    What size drink would you like ?
                    1) Small
                    2) Medium
                    3) Large
                    """);
            String drinkSizeUserSelection = myScanner.nextLine();
            switch (drinkSizeUserSelection) {
                case "1":
                    drinkSize = DrinkSize.SMALL;
                    running = false;
                    break;
                case "2":
                    drinkSize = DrinkSize.MEDIUM;
                    running = false;
                    break;
                case "3":
                    drinkSize = DrinkSize.LARGE;
                    running = false;
                    break;
                default:
                    System.err.println("Invalid selection please try again!❌");
            }
        }
        //Making a "Drink" object then passing the size value to it
        Drink drink = new Drink(drinkSize);
        currentOrder.addDrink(drink);
        System.out.println("\nDrink was added to your Order!✅\n");
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
                //Initializing SandwichSize so I can assign a value ot it in the switch/case
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

                boolean isToasted = false;
                boolean askingToasted = true;
                while (askingToasted) {
                    System.out.println("""
                            Would you like your Sandwich toasted?
                            1) Yes✅
                            2) No ❌
                            """);

                    String toastedInput = myScanner.nextLine();
                    switch (toastedInput) {
                        case "1":
                            isToasted = true;
                            askingToasted = false;
                            break;
                        case "2":
                            isToasted = false;
                            askingToasted = false;
                            break;
                        default:
                            System.err.println("Invalid Input please try again!❌");
                    }
                }
                //Assigning values to my Sandwich, using all the user inputs
                Sandwich sandwich = new Sandwich(sandwichSize, selectedBread, isToasted);

                addingMeat(sandwich);
                addingCheese(sandwich);
                addingRegToppings(sandwich);
                addingSauces(sandwich);
                currentOrder.addSandwich(sandwich);
                running = false;
                System.out.println("\n Sandwich was added to your order! \n");
            }
        }
    }

    private void addingMeat(Sandwich sandwich) {
        //Printing out my List of Meats one by one
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("Please select Base Protein:");
            printList(meats);
            System.out.println("7)No Meat");
            System.out.println("\n");
            String selectedMeat = myScanner.nextLine();
            switch (selectedMeat) {
                case "1":
                    sandwich.setMeat(Meat.Steak);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "2":
                    sandwich.setMeat(Meat.Ham);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "3":
                    sandwich.setMeat(Meat.Salami);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "4":
                    sandwich.setMeat(Meat.Roast_Beef);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "5":
                    sandwich.setMeat(Meat.Chicken);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "6":
                    sandwich.setMeat(Meat.Bacon);
                    sandwich.setExtraMeat(askForExtra());
                    running = false;
                    break;
                case "7":
                    running = false;
                    break;
                default:
                    System.err.println("Invalid Input please try again!❌");
            }
        }

    }

    private void addingCheese(Sandwich sandwich) {
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("Please select Cheese:");
            printList(cheeses);
            System.out.println("5) NO Cheese");
            System.out.println("\n");
            String selectedCheese = myScanner.nextLine();

            switch (selectedCheese) {
                case "1":
                    sandwich.setCheese(Cheese.American);
                    sandwich.setExtraCheese(askForExtra());
                    running = false;
                    break;
                case "2":
                    sandwich.setCheese(Cheese.Provolone);
                    sandwich.setExtraCheese(askForExtra());
                    running = false;
                    break;
                case "3":
                    sandwich.setCheese(Cheese.Cheddar);
                    sandwich.setExtraCheese(askForExtra());
                    running = false;
                    break;
                case "4":
                    sandwich.setCheese(Cheese.Swiss);
                    sandwich.setExtraCheese(askForExtra());
                    running = false;
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.err.println("Invalid Input please try again!❌");
            }
        }

    }

    private void addingRegToppings(Sandwich sandwich) {
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("Please select your Toppings: ");
            printList(regularToppings);
            System.out.println("10)Done");
            System.out.println("\n");
            String selectedTopping = myScanner.nextLine();
            switch (selectedTopping) {
                case "1":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.LETTUCE));
                    break;
                case "2":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.PEPPERS));
                    break;
                case "3":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.ONIONS));
                    break;
                case "4":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.TOMATOES));
                    break;
                case "5":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.JALAPENOS));
                    break;
                case "6":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.CUCUMBERS));
                    break;
                case "7":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.PICKLES));
                    break;
                case "8":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.GUACAMOLE));
                    break;
                case "9":
                    printSelectionMessage(sandwich.addRegularTopping(RegularTopping.MUSHROOMS));
                    break;
                case "10":
                    running = false;
                    break;
                default:
                    System.err.println("Invalid Input please try again!❌");
            }

        }

    }

    private void addingSauces(Sandwich sandwich) {
        boolean running = true;
        while (running) {
            System.out.println("\n");
            System.out.println("Please select your Sauces: ");
            printList(sauces);
            System.out.println("9)Done");
            System.out.println("\n");
            String selectSauces = myScanner.nextLine();
            switch (selectSauces) {
                case "1":
                    printSelectionMessage(sandwich.addSauce(Sauce.MAYO));
                    break;
                case "2":
                    printSelectionMessage(sandwich.addSauce(Sauce.MUSTARD));
                    break;
                case "3":
                    printSelectionMessage(sandwich.addSauce(Sauce.KETCHUP));
                    break;
                case "4":
                    printSelectionMessage(sandwich.addSauce(Sauce.RANCH));
                    break;
                case "5":
                    printSelectionMessage(sandwich.addSauce(Sauce.THOUSAND_ISLANDS));
                    break;
                case "6":
                    printSelectionMessage(sandwich.addSauce(Sauce.VINAIGRETTE));
                    break;
                case "7":
                    printSelectionMessage(sandwich.addSauce(Sauce.AU_JUS));
                    break;
                case "8":
                    printSelectionMessage(sandwich.addSauce(Sauce.SIDE_OF_SAUCE));
                    break;
                case "9":
                    running = false;
                    break;
                default:
                    System.err.println("Invalid Input please try again!❌");
            }
        }

    }

    //Helper Method to check if user in inputting the same value more than once
    private void printSelectionMessage(boolean added) {
        if (added) {
            System.out.println("Added✅");
        } else {
            System.err.println("You already added this");
        }
    }

    //Helper method to ask the user if the would like to add Extra portion
    private boolean askForExtra() {
        System.out.println("""
                Would you like Extra ?
                1) Yes
                2) No
                
                """);
        String userInput = myScanner.nextLine();
        return userInput.equals("1");
    }

    //Helper Method to print my Array list of items, loops one by one
    public void printList(ArrayList<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ")" + items.get(i));

        }

    }
    //BONUS pre-defined sandwiches for the user ot select
    private void addingSignatureSandwich() {
        System.out.println("""
           Which signature sandwich would you like?
           1) BLT
           2) Philly Cheese Steak
           3) Chicken Bacon Ranch
           4) Veggie Delight
           5) Italian Sub
           6) Spicy Steak Supreme
           """);
        String choice = myScanner.nextLine();
        Sandwich sandwich = null;
        switch (choice) {
            case "1":
                // BLT
                sandwich = new Sandwich(SandwichSize.EIGHT, BreadType.WHITE, true);
                sandwich.setMeat(Meat.Bacon);
                sandwich.setCheese(Cheese.Cheddar);
                sandwich.addRegularTopping(RegularTopping.LETTUCE);
                sandwich.addRegularTopping(RegularTopping.TOMATOES);
                sandwich.addSauce(Sauce.RANCH);
                break;
            case "2":
                // Philly Cheese Steak
                sandwich = new Sandwich(SandwichSize.EIGHT, BreadType.WHITE, true);
                sandwich.setMeat(Meat.Steak);
                sandwich.setCheese(Cheese.American);
                sandwich.addRegularTopping(RegularTopping.PEPPERS);
                sandwich.addSauce(Sauce.MAYO);
                break;
            case "3":
                // Chicken Bacon Ranch
                sandwich = new Sandwich(SandwichSize.EIGHT, BreadType.WHITE, true);
                sandwich.setMeat(Meat.Chicken);
                sandwich.setCheese(Cheese.Provolone);
                sandwich.addRegularTopping(RegularTopping.LETTUCE);
                sandwich.addRegularTopping(RegularTopping.TOMATOES);
                sandwich.addSauce(Sauce.RANCH);
                break;
            case "4":
                // Veggie Delight
                sandwich = new Sandwich(SandwichSize.EIGHT, BreadType.WHEAT, false);
                sandwich.setCheese(Cheese.Swiss);
                sandwich.addRegularTopping(RegularTopping.LETTUCE);
                sandwich.addRegularTopping(RegularTopping.TOMATOES);
                sandwich.addRegularTopping(RegularTopping.CUCUMBERS);
                sandwich.addRegularTopping(RegularTopping.PEPPERS);
                sandwich.addRegularTopping(RegularTopping.ONIONS);
                sandwich.addSauce(Sauce.VINAIGRETTE);
                break;
            case "5":
                // Italian Sub
                sandwich = new Sandwich(SandwichSize.TWELVE, BreadType.WHITE, true);
                sandwich.setMeat(Meat.Salami);
                sandwich.setCheese(Cheese.Provolone);
                sandwich.addRegularTopping(RegularTopping.LETTUCE);
                sandwich.addRegularTopping(RegularTopping.ONIONS);
                sandwich.addRegularTopping(RegularTopping.PICKLES);
                sandwich.addSauce(Sauce.VINAIGRETTE);
                break;
            case "6":
                // Spicy Steak Supreme
                sandwich = new Sandwich(SandwichSize.TWELVE, BreadType.RYE, true);
                sandwich.setMeat(Meat.Steak);
                sandwich.setCheese(Cheese.Cheddar);
                sandwich.addRegularTopping(RegularTopping.JALAPENOS);
                sandwich.addRegularTopping(RegularTopping.PEPPERS);
                sandwich.addRegularTopping(RegularTopping.ONIONS);
                sandwich.addSauce(Sauce.MAYO);
                break;
            default:
                System.err.println("Invalid Input please try again!❌");
                return;
        }
        currentOrder.addSandwich(sandwich);
        System.out.println("Signature sandwich added to your order!✅");
    }
    //Proper Exit screen
    public void exitScreen() {
        System.out.println("""
                            ✰✰✰✰✰✰✰✰
                .𖥔 ݁ ˖╭ ┆THANK YOU COME AGAIN! ╰⊹ ࣪
                            ✦·┈๑⋅⋯ ⋯⋅๑┈·✦
                """);
    }

}