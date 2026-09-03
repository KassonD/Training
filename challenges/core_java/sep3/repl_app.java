package challenges.core_java.sep3;
import java.util.Scanner;
import java.util.Random;

public class repl_app {
    public static void main(String[] args) {
        String command = "";

        Scanner scan = new Scanner(System.in);

        System.out.printf("%nWelcome to my REPL App!%n%n");

        while (!command.equals("quit")) {
            System.out.print("> ");
            command = scan.nextLine();
            System.out.println("");
            
            switch (command) {
                case "add":
                    RunAdd(scan);
                    scan.nextLine();
                    break;
                case "subtract":
                    RunSubtract(scan);
                    scan.nextLine();
                    break;
                case "multiply":
                    RunMultiply(scan);
                    scan.nextLine();
                    break;
                case "divide":
                    RunDivide(scan);
                    scan.nextLine();
                    break;
                case "random":
                    RunRandom(scan);
                    scan.nextLine();
                    break;
                case "reverse":
                    RunReverse(scan);
                    break;
                case "quit":
                    break;
                case "help":
                    PrintCommands();
                    break;
                default:
                    System.out.print("Invalid command.");
                    break;
            }

            System.out.println("");
        }

        System.out.println("Goodbye!");
        scan.close();
    }

    public static void PrintCommands() {
        System.out.println("Available commands: ");
        System.out.println("  add");
        System.out.println("  subtract");
        System.out.println("  multiply");
        System.out.println("  divide");
        System.out.println("  random");
        System.out.println("  reverse");
        System.out.println("  quit");
    }

    public static void RunAdd(Scanner scan) {
        System.out.print("First number: ");
        double num1 = scan.nextDouble();
        System.out.print("Second number: ");
        double num2 = scan.nextDouble();
        System.out.printf("%nResult: %f%n", num1 + num2);
    }

    public static void RunSubtract(Scanner scan) {
        System.out.print("First number: ");
        double num1 = scan.nextDouble();
        System.out.print("Second number: ");
        double num2 = scan.nextDouble();
        System.out.printf("%nResult: %f%n", num1 - num2);
    }

    public static void RunMultiply(Scanner scan) {
        System.out.print("First number: ");
        double num1 = scan.nextDouble();
        System.out.print("Second number: ");
        double num2 = scan.nextDouble();
        System.out.printf("%nResult: %f%n", num1 * num2);
    }

    public static void RunDivide(Scanner scan) {
        System.out.print("First number: ");
        double num1 = scan.nextDouble();
        System.out.print("Second number: ");
        double num2 = scan.nextDouble();

        if (num2 != 0)
            System.out.printf("%nResult: %f%n", num1 / num2);
        else
            System.out.println("The second number can not be 0.");
    }

    public static void RunRandom(Scanner scan) {
        System.out.print("Minimum: ");
        int min = scan.nextInt();
        System.out.print("Maximum: ");
        int max = scan.nextInt();

        if (max > min) {
            Random random = new Random();
            int randomNum = random.nextInt(max - min) + min;
            System.out.printf("%nRandom number: %d%n", randomNum);
        }
        else
            System.out.println("The Maximum must be larger than the Minimum.");
    }

    public static void RunReverse(Scanner scan) {
        System.out.print("Enter text: ");
        String text = scan.nextLine();
        int length = text.length();

        char[] reverseCharacters = new char[length];
        for (int i = 0; i < length; i++) {
            int reverseIndex = length - 1 - i;
            reverseCharacters[i] = text.charAt(reverseIndex);
        }

        System.out.printf("%n%s%n", String.valueOf(reverseCharacters));
    }
}

/*
REPL App - Below shows the commands to implement and example output:

 

Welcome to my REPL App!

 

> help

 

Available commands:

  add

  subtract

  multiply

  divide

  random

  reverse

  quit

 

> add

First number: 10

Second number: 25

Result: 35

 

> reverse

Enter text: hello world

dlrow olleh

 

> random

Minimum: 1

Maximum: 100

Random number: 73

 

> quit

Goodbye!
*/
