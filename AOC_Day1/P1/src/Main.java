import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = ".../src/input.txt";
        int sum = 0;
        try {
            File file = new File(filePath);

            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(file);

            // Read and print each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int[] numbers = new int[line.length()];
                int index = 0;

                // Loop
                for (char character : line.toCharArray()) {
                    if (Character.isDigit(character)) {
                        // Checked digit is added to numbers[]
                        numbers[index++] = Character.getNumericValue(character);
                    }
                }
                // Resize numbers[] and passed into validNumber[]
                int[] validNumber = Arrays.copyOf(numbers, index);
                if (validNumber.length >= 2) {
                    int cordValue = validNumber[0] * 10 + validNumber[validNumber.length - 1];
                    System.out.printf(" I'm adding %d and %d, so: %d\n", validNumber[0], validNumber[validNumber.length - 1], cordValue );
                    System.out.printf(" Old sum: %d\n", sum);
                    sum += cordValue;
                    System.out.printf(" New sum: %d\n", sum);
                }
                else {
                    System.out.printf(" I'm adding %d%d\n", validNumber[0], validNumber[0]);
                    System.out.printf(" Old sum: %d\n", sum);
                    sum += numbers[0]* 10 + validNumber[0];
                    System.out.printf(" New sum: %d\n", sum);
                }
                }

            System.out.printf(" Answer: %d\n", sum);
            // Close the Scanner to release resources
            scanner.close();
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

