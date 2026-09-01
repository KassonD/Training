package challenges.core_java;

public class calculator {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 3;
        char operator = '+';
        String again = "y";

        while (again.equals("y")) {
            double result = 0;
            boolean isValid = true;

            if (operator == '+') {
                result = num1 + num2;
            }
            else if (operator == '-') {
                result = num1 - num2;
            }
            else if (operator == '*') {
                result = num1 * num2;
            }
            else if (operator == '/') {
                if (num2 != 0) {
                    result = num1 / num2;
                }
                else {
                    System.out.println("Cannot divide by zero.");
                    isValid = false;
                }
            }
            else
                isValid = false;

            if (isValid)
                System.out.println("Result: " + result);

            again = "n";
        }

        System.out.println("Thank you for using the calculator.");
    }
}
