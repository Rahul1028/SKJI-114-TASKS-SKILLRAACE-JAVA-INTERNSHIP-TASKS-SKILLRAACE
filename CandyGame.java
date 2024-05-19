import java.util.Scanner;

public class CandyGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Read the input number
            System.out.print("Enter an integer from the candy group: ");
            long number = scanner.nextLong();
            
            // Calculate and print the number of occurrences of digit '4'
            int count = countOccurrencesOfFour(number);
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }

    /**
     * Method to count the number of occurrences of the digit '4' in a number.
     *
     * @param number The input number.
     * @return The count of digit '4' in the number.
     */
    public static int countOccurrencesOfFour(long number) {
        int count = 0;
        
        // Convert the number to a positive value if it is negative
        number = Math.abs(number);
        
        // Process each digit of the number
        while (number != 0) {
            long digit = number % 10;
            if (digit == 4) {
                count++;
            }
            number /= 10;
        }
        
        return count;
    }
}

