package challenges.core_java.sep3;
import java.util.Scanner;

public class word_analyzer {
    public static void main(String[] args) {
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int spaceCount = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = scan.nextLine();
        int characterCount = word.length();
        System.out.println("");

        for (int i = 0; i < characterCount; i++) {
            char character = Character.toLowerCase(word.charAt(i));

            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
                vowelCount++;
            else if(character >= 'a' && character <= 'z')
                consonantCount++;
            else if (character >= '0' && character <= '9')
                digitCount++;
            else if (character == ' ')
                spaceCount++;
        }

        System.out.printf(
            "Characters: %d%nVowels: %d%nConsonants: %d%nDigits: %d%nSpaces: %d%n",
            characterCount, vowelCount, consonantCount, digitCount, spaceCount
        );

        scan.close();
    }
}

/*
Ask the user to enter a word and output the following (example):

 

Characters: 17

Vowels: 5

Consonants: 10

Digits: 0

Spaces: 2
 */