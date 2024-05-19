import java.util.Scanner;

public class SumOddEvenDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the long number as input
        System.out.print("Enter a long number: ");
        long number = scanner.nextLong();
        
        // Initialize sums for odd and even digits
        int sumOdd = 0;
        int sumEven = 0;
        
        // Process each digit of the number
        while (number != 0) {
            int digit = (int) (number % 10);
            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
            number /= 10;
        }
        
        // Output the results
        System.out.println(sumOdd + " " + sumEven);
        
        scanner.close();
    }
}
