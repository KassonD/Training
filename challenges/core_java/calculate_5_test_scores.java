package challenges.core_java;
import java.util.Scanner;

/*
Scenario:

Ask for 5 test scores and calculate:​

Total​

Average​

Highest Score​

Lowest Score​

​

Then assign a letter grade.​

Expected output:

If the 5 test scores entered are: 100, 90, 60, 75, 20​

​

Then:​

​

Total: 345​

Average: 69​

Highest: 100​

Lowest: 20​

​

Your values were:​

100 – A​

90 – A​

60 – D​

75 – C​

20 - F​
 */

public class calculate_5_test_scores {
    private static final int SCORE_COUNT = 5;

    public static void main(String[] args) {
        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int[] scores = new int[SCORE_COUNT];
        char[] grades = new char[SCORE_COUNT];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < SCORE_COUNT; i++) {
            System.out.printf("Enter test score %d: ", i + 1);
            int score = scan.nextInt();
            scores[i] = score;
            total += score;

            if (score > highest)
                highest = score;

            if (score < lowest)
                lowest = score;

            if (score >= 90)
                grades[i] = 'A';
            else if (score >= 80)
                grades[i] = 'B';
            else if (score >= 70)
                grades[i] = 'C';
            else if (score >= 60)
                grades[i] = 'D';
            else
                grades[i] = 'F';
        }

        int average = total / SCORE_COUNT;

        System.out.printf("%nTotal: %d%n", total);
        System.out.printf("Average: %d%n", average);
        System.out.printf("Highest: %d%n", highest);
        System.out.printf("Lowest: %d%n%n", lowest);

        System.out.println("Your values were:");
        for (int i = 0; i < SCORE_COUNT; i++){
            System.out.printf("%d - %c%n", scores[i], grades[i]);
        }

        scan.close();
    }
}