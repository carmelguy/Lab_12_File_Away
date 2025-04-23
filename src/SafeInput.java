import java.util.Scanner;

public class SafeInput {
    /**
     * Gets a string from the user with the specified prompt
     * @param pipe - Scanner instance to read from
     * @param prompt - user friendly prompt to display
     * @return - String input by the user
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine();
            if (retString.length() > 0) {
                done = true;
            } else {
                System.out.println("You must enter at least one character");
            }
        } while (!done);

        return retString;
    }

    /**
     * Gets an int from the user with the specified prompt and within the specified range
     * @param pipe - Scanner instance to read from
     * @param prompt - user friendly prompt to display
     * @param low - low value for the range
     * @param high - high value for the range
     * @return - int value input by the user
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine(); // Clear buffer
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("You must enter a value in range [" + low + "-" + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not: " + trash);
            }
        } while (!done);

        return retVal;
    }

    /**
     * Gets a yes or no from the user with the specified prompt
     * @param pipe - Scanner instance to read from
     * @param prompt - user friendly prompt to display
     * @return - boolean true for yes, false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = false;
        boolean done = false;
        String response = "";

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter Y or N");
            }
        } while (!done);

        return retVal;
    }
}