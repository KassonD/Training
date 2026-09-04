package challenges.core_java.sep4;
import java.util.Scanner;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class DatetimeAPI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Date: " + currentDate);
        System.out.println("Year: " + currentDate.getYear());
        System.out.println("Month: " + Month.of(currentDate.getMonthValue()));
        System.out.println("Day: " + currentDate.getDayOfMonth());

        // Age
        System.out.print("\nEnter your birth date: ");
        LocalDate birthDate = LocalDate.parse(scan.nextLine());
        int age = Period.between(birthDate, currentDate).getYears();
        System.out.printf("You are %d years old.%n", age);

        // Birthday
        System.out.print("\nEnter your birthday: ");
        LocalDate birthDay = LocalDate.parse(scan.nextLine());
        LocalDate nextBirthday = birthDay.withYear(currentDate.getYear());

        if (nextBirthday.isBefore(currentDate))
            nextBirthday = nextBirthday.plusYears(1);

        long daysUntilBirthday = ChronoUnit.DAYS.between(currentDate, nextBirthday);
        System.out.println("Days until your birthday: " + daysUntilBirthday);

        scan.close();
    }
}
