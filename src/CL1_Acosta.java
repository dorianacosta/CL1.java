/* Dorian James Acosta
[CS1101] Comprehensive Lab 1
This work is to be done individually. It is not permitted to.
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted to share code, upload
this assignment online in any form, or view/receive/
modifying code written by anyone else. This assignment is part.
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
import java.io.File;
import java.util.Scanner;

public class CL1_Acosta {
    public static void main(String[] args){


        //Initialization.
        try{
            File file= new File("albums.txt");
            Scanner fileReader= new Scanner(file);
            Scanner scanner= new Scanner(System.in);
            System.out.println("What is your name?");
            String name= scanner.nextLine();
            System.out.println("Welcome to Miner Disco "+name+"!");
            String choice = "";
            String yerd="";
            String word="";
            String twin="";
            double tax=.0825;
            double totalPrice=0.0;
            int cart =1;
            do{


                //Main Menu.
                System.out.println("Please select an option 1-5.");
                System.out.println("----");
                System.out.println("1. Order");
                System.out.println("----");
                System.out.println("2. View Order");
                System.out.println("----");
                System.out.println("3. Clear Cart Contents");
                System.out.println("----");
                System.out.println("4. Checkout");
                System.out.println("----");
                System.out.println("5. Exit Miner Disco");
                System.out.println("----");
                choice= scanner.nextLine();


                //Order.
                if (choice.equals("1")) {
                    double copiesPrice=1;
                    double price=1;
                    System.out.println("Which album would you like to purchase?");
                    System.out.println("Please select an option 6-11.");
                    System.out.println("----");
                    System.out.println("6. Rock");
                    System.out.println("----");
                    System.out.println("7. Pop");
                    System.out.println("----");
                    System.out.println("8. Hip-Hop");
                    System.out.println("----");
                    System.out.println("9. Electronic");
                    System.out.println("----");
                    System.out.println("10. Rap");
                    System.out.println("----");
                    System.out.println("11. Exit");
                    System.out.println("----");
                    choice = scanner.nextLine();
                    String genre = "";
                    if (choice.equals("6")) {
                        genre = "Rock";
                    }
                    if (choice.equals("7")) {
                        genre = "Pop";
                    }
                    if (choice.equals("8")) {
                        genre = "Hip-Hop";
                    }
                    if (choice.equals("9")) {
                        genre = "Electronic";
                    }
                    if (choice.equals("10")) {
                        genre = "Rap";
                    }
                    if (choice.equals("11")) {
                        System.out.println("Going back to the main menu!");
                        continue;
                        }
                    while (fileReader.hasNextLine()) {
                        String currentTitle = fileReader.next();
                        String currentGenre = fileReader.next();
                        price = fileReader.nextDouble();


                        if (currentGenre.equals(genre)) {
                            System.out.println("----");
                            System.out.println("Title:"+" "+currentTitle + " " +"Genre:"+" "+ currentGenre + " "+"Price:"+" "+"$"+ price);
                        }
                    }
                    System.out.println("What album would you like to purchase?");
                    String album = scanner.nextLine();

                    fileReader = new Scanner(file);
                    boolean albumFound = false;
                    while (fileReader.hasNextLine()) {
                        String currentTitle = fileReader.next();
                        String currentGenre = fileReader.next();
                        price = fileReader.nextDouble();
                        if (currentTitle.equals(album)) {
                            System.out.println("----");
                            System.out.println("Title:"+" "+currentTitle + " " +"Genre:"+" "+ currentGenre + " "+"Price:"+" "+"$"+ price);
                            System.out.println("----");
                            albumFound = true;
                        }
                    }
                    int copies = 1;
                    if (albumFound) {
                        System.out.println("----");
                        System.out.println("How many copies would you like?");
                        System.out.println("----");
                        copies= scanner.nextInt();
                        copiesPrice = price * copies;
                    }
                    if (!albumFound) {
                        System.out.println("----");
                        System.out.println("Sorry that album is not available");
                        System.out.println("----");
                    }
                    totalPrice += copiesPrice;
                    cart*=copies;
                    scanner.nextLine();
                }


                // What is in the order.
                if (choice.equals("2")) {
                    System.out.println("Here is what is in your order:");
                    System.out.println("------Cart------");
                    System.out.println("Number of items: " + cart);
                    System.out.println("Total: $" + totalPrice);
                    System.out.println("----");
                    }


                //Clear Order.
                if (choice.equals("3")) {
                    System.out.println("Would you like to clear your order"+" "+ name+"?");
                    System.out.println("----");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println("----");
                    yerd= scanner.nextLine();
                    if (yerd.equals("1")){
                        cart = 0;
                        totalPrice = 0.0;
                        System.out.println("------Cart------");
                        System.out.println("Number of items: " + cart);
                        System.out.println("Total: $" + totalPrice);
                        System.out.println("----");
                        System.out.println("Cart has been cleared"+" "+name+"!");
                        continue;
                    }
                    if (yerd.equals("2")){
                        System.out.println("------Cart------");
                        System.out.println("Number of items: " + cart);
                        System.out.println("Total: $" + totalPrice);
                        System.out.println("----");
                        System.out.println("Cart has not been cleared"+" "+name+".");
                        System.out.println("Going Back to the menu!");
                    }
                }


                //Checkout.
                if  (choice.equals("4")) {
                    System.out.println("Would you like to checkout"+" "+ name+"?");
                    System.out.println("----");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.println("----");
                    word= scanner.nextLine();
                    if (word.equals("1")){
                        double sum=totalPrice*tax;
                        double finalPrice=sum+totalPrice;
                        System.out.println("------Cart------");
                        System.out.println("Number of items: " + cart);
                        System.out.println("Total: $" + finalPrice);
                        System.out.println("----");
                        System.out.println(name+" "+"would you like pick up or delivery?");
                        System.out.println("----");
                        System.out.println("1. Pick up");
                        System.out.println("2. Delivery");
                        System.out.println("----");
                        twin=scanner.nextLine();
                        if(twin.equals("1")){
                            System.out.println("Enter 16 digit credit card number");
                            String cardNumber=scanner.next();

                            if (cardNumber.length() == 16){
                                System.out.println("Payment approved!");
                                System.out.println("Thank you! See you again soon"+" "+name+"!");
                                System.out.println("------Receipt------");
                                System.out.println("Number of items: " + cart);
                                System.out.println("Subtotal (before tax): $" + totalPrice);
                                System.out.println("Tax (8.25%):"+sum);
                                System.out.println("Total: $" + finalPrice);
                                return;
                            }
                            else{
                                System.out.println("Enter a valid 16 digit credit card");
                                System.out.println("----");
                                System.out.println("Payment was not approved.");
                                System.out.println("----");
                                System.out.println("Please try again.");
                            }
                            System.out.println("----");
                        }
                        if(twin.equals("2")) {
                            System.out.println("Delivery includes a $7.00 delivery fee.");
                            System.out.println("Would you like to add a tip?");
                            System.out.println("----");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            System.out.println("----");
                            String daveBlunts = scanner.nextLine();
                            if (daveBlunts.equals("1")) {
                                System.out.println("How much would you like to tip"+" "+ name+"?");
                                System.out.println("Enter tip percentage (Ex: Enter 15 For 15%): ");
                                double tipPercentage = scanner.nextDouble();
                                double tipAmount = (totalPrice * tipPercentage) / 100;
                                scanner.nextLine();
                                System.out.println("Enter 16 digit credit card number");
                                String cardNumber2 = scanner.next();
                                if (cardNumber2.length() == 16) {
                                    double i = 7.0;
                                    double tipTip=totalPrice+tipAmount;
                                    double fee = tipTip + i;
                                    double feeFee = fee * tax;
                                    double finalFee = fee + feeFee;

                                    System.out.println("Payment approved!");
                                    System.out.println("Thank you! See you again soon" + " " + name + "!");
                                    System.out.println("------Receipt------");
                                    System.out.println("Number of items: " + cart);
                                    System.out.println("Subtotal (before tax): $" + totalPrice);
                                    System.out.println("Delivery Fee: $7.00");
                                    System.out.println("Tip:"+"$"+tipAmount);
                                    System.out.println("Tax (8.25%):" + feeFee);
                                    System.out.println("Total: $" + finalFee);
                                    System.out.println("----");
                                    return;
                                }
                                else {
                                    System.out.println("Enter a valid 16 digit credit card");
                                    System.out.println("----");
                                    System.out.println("Payment was not approved.");
                                    System.out.println("----");
                                    System.out.println("Please try again.");
                                }
                            }
                            if (daveBlunts.equals("2")) {
                                System.out.println("Enter 16 digit credit card number");
                                String cardNumber3 = scanner.next();
                                if (cardNumber3.length() == 16) {
                                    double i = 7.0;
                                    double fee = totalPrice + i;
                                    double feeFee = fee * tax;
                                    double finalFee = fee + feeFee;

                                    System.out.println("Payment approved!");
                                    System.out.println("Thank you! See you again soon" + " " + name + "!");
                                    System.out.println("------Receipt------");
                                    System.out.println("Number of items: " + cart);
                                    System.out.println("Subtotal (before tax): $" + totalPrice);
                                    System.out.println("Delivery Fee: $7.00");
                                    System.out.println("Tip: $0");
                                    System.out.println("Tax (8.25%):" + feeFee);
                                    System.out.println("Total: $" + finalFee);
                                    System.out.println("----");
                                    return;
                                }
                                else {
                                    System.out.println("Enter a valid 16 digit credit card");
                                    System.out.println("----");
                                    System.out.println("Payment was not approved.");
                                    System.out.println("----");
                                    System.out.println("Please try again.");
                                }
                            }
                        }
                    }
                    if (word.equals("2")){
                        System.out.println("------Cart------");
                        System.out.println("Number of items: " + cart);
                        System.out.println("Total: $" + totalPrice);
                        System.out.println("----");
                        System.out.println("Exiting checkout.");
                        System.out.println("See you soon"+" "+name+"!");
                    }
                }

                //Exit.
            }while(!choice.equals("5"));
            System.out.println("----");
            System.out.println ("Thank you for shopping with us!");
            System.out.println("----");
            System.out.println ("Have a great day"+" "+name+"!");
            System.out.println("----");
        }
        catch(Exception e){
            System.out.println("----");
            System.out.println("Error: "+e);
            System.out.println("----");
        }
    }
}