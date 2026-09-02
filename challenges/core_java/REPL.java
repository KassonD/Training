package challenges.core_java;
import java.util.Scanner;

public class REPL {
    public static void main(String[] args) {
        int option = 0;
        double balance = 0;
        boolean optionIsValid = true;;

        Scanner scan = new Scanner(System.in);

        while (option != 4) {
            if (optionIsValid) {
                System.out.println("-------------------");
                System.out.println("Options: ");
                System.out.println("1. Check balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.println("-------------------");
            }
            else {
                System.out.println("That is not a valid option.");
            }

            System.out.print("> ");
            option = scan.nextInt();

            optionIsValid = true;
            switch (option) {
                case 1:
                    System.out.printf("%nBalance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.printf("%nEnter deposit amount: $");
                    balance += scan.nextDouble();                    
                        
                    break;

                case 3:
                    System.out.printf("%nEnter withdraw amount: $");
                    double difference = balance - scan.nextDouble();

                    if (difference >= 0)
                        balance = difference;
                    else
                        System.out.println("You don't have enough money.");
                    
                    break;

                case 4:
                    System.out.printf("%nExiting...%n");
                    break;
            
                default:
                    optionIsValid = false;
                    break;
            }
        }

        scan.close();
    }
}
