import java.util.Scanner;

public class PinAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define a fixed 4-digit master PIN as a constant
        final String MASTER_PIN = "1234";
        int maxAttempts = 3;

        System.out.println("--- ATM Secure Login ---");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.next();

            // Check if PIN matches
            if (enteredPin.equals(MASTER_PIN)) {
                System.out.println("Access Granted");
                scanner.close();
                return; // Immediately terminate the program
            } else {
                int remaining = maxAttempts - attempt;
                
                // If it was the last attempt, the account gets locked
                if (remaining == 0) {
                    System.out.println("Account Locked due to too many failed attempts");
                } else {
                    System.out.println("Incorrect PIN. Remaining attempts: " + remaining);
                }
            }
        }
        
        scanner.close();
    }
}
