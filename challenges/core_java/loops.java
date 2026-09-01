package challenges.core_java;

public class loops {
    public static void main(String[] args) {
        // For loop
        System.out.print("For loop:");
        for (int i = 1; i <= 5; i++)
            System.out.print(" " + i);

        // While loop
        System.out.print("\nWhile loop:");
        int numWhile = 1;
        while (numWhile <= 5) {
            System.out.print(" " + numWhile);
            numWhile++;
        }

        // Do while loop
        System.out.print("\nDo while loop:");
        int numDoWhile = 1;
        do {
            System.out.print(" " + numDoWhile);
            numDoWhile++;
        }
        while (numDoWhile <= 5);
    }   
}
