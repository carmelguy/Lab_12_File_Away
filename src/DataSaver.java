import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        boolean keepGoing = true;
        int idCounter = 1;

        System.out.println("CSV Data Entry Program");
        System.out.println("=====================");

        // Loop to collect data records
        while (keepGoing) {
            // Get user data
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");

            // Format ID with leading zeros
            String idNumber = String.format("%06d", idCounter);
            idCounter++;

            String email = SafeInput.getNonZeroLenString(scanner, "Enter Email");
            int birthYear = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 1900, 2025);

            // Create CSV record
            String record = String.format("%s, %s, %s, %s, %d",
                    firstName, lastName, idNumber, email, birthYear);

            // Add to ArrayList
            records.add(record);

            // Ask if user wants to add another record
            keepGoing = SafeInput.getYNConfirm(scanner, "Do you want to add another record?");
        }

        // Get the file name from user
        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter file name (without extension)");
        fileName = fileName + ".csv";

        // Write data to CSV file
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            // Write each record to the file
            for (String record : records) {
                writer.println(record);
            }

            System.out.println("Data successfully saved to src/" + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}