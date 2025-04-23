import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInspector {
    public static void main(String[] args) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        // Set the starting directory to the src folder
        fileChooser.setCurrentDirectory(new File("src"));
        fileChooser.setDialogTitle("Select a text file to inspect");

        // Show the dialog and check if user selected a file
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();

            System.out.println("Reading file: " + fileName);
            System.out.println("Contents:");
            System.out.println("-------------------------------------------------");

            // Variables to track statistics
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;

                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);

                    // Update statistics
                    lineCount++;

                    // Count words using split
                    String[] words = line.split("\\s+");
                    wordCount += words.length;

                    // Count characters
                    charCount += line.length();
                }

                // Print summary report
                System.out.println("-------------------------------------------------");
                System.out.println("File Summary Report");
                System.out.println("-------------------------------------------------");
                System.out.println("File name: " + fileName);
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected or operation canceled.");
        }
    }
}