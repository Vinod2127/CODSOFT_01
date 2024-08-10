import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            totalRounds++;

            // Difficulty levels
            System.out.println("Choose difficulty level:");
            System.out.println("1. Easy (1-50)");
            System.out.println("2. Medium (1-100)");
            System.out.println("3. Hard (1-200)");
            System.out.print("Enter your choice (1/2/3): ");
            int difficulty = scanner.nextInt();
            int maxNumber = difficulty == 1 ? 50 : (difficulty == 2 ? 100 : 200);

            int numberToGuess = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + totalRounds + ": Guess the number between 1 and " + maxNumber + ".");

            while (attempts < 10 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        // Display game summary
        System.out.println("Game Over!");
        System.out.println("You played " + totalRounds + " rounds.");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Average attempts per round: " + (totalAttempts / (double) totalRounds));

        scanner.close();
    }
}
