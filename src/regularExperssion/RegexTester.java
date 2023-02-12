package regularExperssion;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class RegexTester {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to the Regex Tester");

        // Loop until user decides to stop
        boolean done = false;
        while (!done) {
            String regex = getRegex();
            Pattern pattern = Pattern.compile(regex);
            done = matchString(pattern);
        }
    }

    /**
     * Prompts user to enter a regex and returns the valid regex entered.
     * Continues to prompt until a valid regex is entered.
     *
     * @return the valid regex entered by the user
     */
    private static String getRegex() {
        System.out.println("Enter regex: ");
        String regex = scanner.nextLine();
        while (!validateRegex(regex)) {
            System.out.println("Invalid regex, enter again: ");
            regex = scanner.nextLine();
        }
        return regex;
    }

    /**
     * Validates the given regex by trying to compile it.
     * Returns true if the regex is valid, false otherwise.
     *
     * @param regex the regex to validate
     * @return true if the regex is valid, false otherwise
     */
    private static boolean validateRegex(String regex) {
        try {
            Pattern.compile(regex);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * Matches the given pattern against strings entered by the user.
     * Continuously prompts user for input strings and reports if they match the pattern.
     * Stops when user enters an empty string.
     *
     * @param pattern the pattern to match against
     * @return true if user decides to stop, false otherwise
     */
    private static boolean matchString(Pattern pattern) {
        System.out.println("Enter string: ");
        String input = scanner.nextLine();
        while (input.length() != 0) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
            } else {
                System.out.println("Does not match");
            }
            System.out.println("Enter another string or press Enter to continue: ");
            input = scanner.nextLine();
        }
        System.out.println("Another regx? (Y/N) ");
        String reply = scanner.nextLine();
        return !reply.equalsIgnoreCase("Y");
    }
}
