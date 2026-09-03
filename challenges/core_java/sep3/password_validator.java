package challenges.core_java.sep3;
import java.util.Scanner;

public class password_validator {
    public static void main(String[] args) {
        boolean isValid = false;
        Scanner scan = new Scanner(System.in);

        while (!isValid) {
            System.out.printf("Enter a password: ");
            String password = scan.nextLine();
            System.out.println("");
            isValid = validate(password);
            System.out.println("");
        }

        System.out.println("Password accepted!");
        scan.close();
    }

    public static boolean validate(String password) {
        boolean containsMinCharacters = password.length() >= 8;
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        boolean containsNumber = false;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (character >= 'A' && character <= 'Z')
                containsUppercase = true;
            if (character >= 'a' && character <= 'z')
                containsLowercase = true;
            if (character >= '0' && character <= '9')
                containsNumber = true;
        }

        if (!containsMinCharacters)
            System.out.println("- Must be at least 8 characters");
        if (!containsUppercase)
            System.out.println("- Must contain an uppercase letter");
        if (!containsLowercase)
            System.out.println("- Must contain a lowercase letter");
        if (!containsNumber)
            System.out.println("- Must contain a number");

        return containsMinCharacters && containsUppercase && containsLowercase && containsNumber;
    }
}

/*
Password Validator

 

Ask the user to create a password.

 

The password must:

 

Be at least 8 characters

Contain at least one uppercase letter

Contain at least one lowercase letter

Contain at least one number

 

Output:

Password accepted!

 

OR (based on failed requirements)

 

Password rejected:

- Must contain an uppercase letter

- Must contain a number
*/
