# Jose's Deli Capstone 2

## Project Description

Jose's Deli is a Java console-based ordering application for a custom deli sandwich shop. The application allows users to create a new order, add sandwiches, drinks, and chips, customize sandwiches with meats, cheese, toppings, sauces, and checkout with a saved receipt.

This project was built as part of Capstone 2: The Deli. The goal of the project was to practice object-oriented programming, user input validation, collections, enums, file writing, and real-world application flow.

## The Rough Draft
![Screenshot 2026-05-29 044828.png](src/main/images/Screenshot%202026-05-29%20044828.png)![Screenshot 2026-05-29 044842.png](src/main/images/Screenshot%202026-05-29%20044842.png)
## Features

- Create a new customer order
- Add custom sandwiches
- Select bread type
- Select sandwich size
- Choose toasted or not toasted
- Add meat and cheese
- Choose extra meat or extra cheese
- Add multiple regular toppings
- Add multiple sauces
- Prevent duplicate toppings and sauces
- Add drinks and chips
- Add signature sandwiches
- View order summary before checkout
- Save receipt to a text file
- Cancel an order
- Input validation for menu selections

## Technologies Used

- Java
- IntelliJ IDEA
- Object-Oriented Programming
- ArrayList
- Enums
- FileWriter/BufferedWriter
- Git/GitHub

## Signature Sandwiches

The application includes premade signature sandwich options such as:

- BLT
- Philly Cheese Steak
- Chicken Bacon Ranch
- Veggie Delight
- Italian Sub
- Spicy Steak Supreme

These allow the customer to quickly select a premade sandwich instead of building one from scratch.

## How To Run

1. Open the project in IntelliJ IDEA.
2. Make sure the project SDK is set to Java.
3. Run the `Program.java` file.
4. Follow the console menu prompts.
5. When checkout is completed, a receipt will be saved in the receipts folder.

## User Menu Examples!![Screenshot 2026-05-29 042936.png](src/main/images/Screenshot%202026-05-29%20042936.png)
![Screenshot 2026-05-29 042923.png](src/main/images/Screenshot%202026-05-29%20042923.png)
## Interesting Code!!
![Screenshot 2026-05-29 043022.png](src/main/images/Screenshot%202026-05-29%20043022.png)
## Challenges Faced
One of the biggest challenges during this project was realizing that my original approach was becoming far too repetitive and difficult to maintain. Early in development, I relied heavily on large switch statements and repetitive code blocks for handling toppings, sauces, meats, and user selections. As the project grew, it became clear that continuing with that structure would make the application harder to scale and debug.
I had to completely pivot my design approach and rethink how the application should store and manage data. Instead of continuing with repetitive setter methods and overwritten values, I implemented `ArrayList` collections to support multiple toppings and sauces, helper methods to reduce duplicated logic, and reusable validation methods to improve the user experience. This change significantly improved the readability, scalability, and maintainability of the project.
Another major challenge was input validation and receipt formatting. Since the application is fully console-based, I needed to carefully handle invalid inputs, repeated topping selections, and formatting issues without crashing the application. I also improved the receipt system to properly display sandwich customizations such as extra meat, extra cheese, multiple sauces, and signature sandwiches in a clean and readable way.
This project taught me the importance of refactoring, abstraction, and building software that is maintainable instead of simply making it “work.”
---
## Future Improvements
In the future, I would like to continue expanding the project with additional features and improvements such as:
- A graphical user interface (GUI)
- Customer names and order tracking
- Ability to remove toppings after selection
- Combo meal options
- Additional signature sandwiches
- Database integration for menu storage
- Order history and saved customer orders
- Improved receipt formatting
- Online ordering support
- Mobile-friendly version of the application
  I would also like to further improve the object-oriented design by creating more reusable components and potentially introducing inheritance for signature sandwich templates.
---
## Author
### Jose Pagan