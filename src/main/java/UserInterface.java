import java.util.Scanner;

public class UserInterface {
    private final Scanner myScanner = new Scanner(System.in);
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

                System.out.println("""
                        Would you like toppings on your sandwich?
                        1) Yes✅
                        2) No ❌
                        """);
                String userInput = myScanner.nextLine();
                switch (userInput) {
                    case "1":
                        System.out.println("""
                                Select your Protein...
                                
                                1) Steak
                                2) Ham
                                3) Salami
                                4) Roast Beef
                                5) Chicken
                                6) Bacon
                                7) None
                                
                                """);
                        String proteinType = myScanner.nextLine();
                        switch (proteinType) {
                            case "1":

                        }
                        break;
                    case "2":

                        break;

                }
//

            }
        }
    }
    public void exitScreen () {
        System.out.println("""
                                        ✰✰✰✰✰✰✰✰
                            .𖥔 ݁ ˖╭ ┆THANK YOU COME AGAIN! ╰⊹ ࣪
                                        ✦·┈๑⋅⋯ ⋯⋅๑┈·✦
                            """);
    }
}