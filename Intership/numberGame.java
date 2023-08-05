import java.util.Random;
import java.util.Scanner;

public class numberGame {
    public static void main(String[] args) {
        playGames();
    }

    public static int generateRandomNumber(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    public static int getUserGuess() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your guess (Between 1 & 100): ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return getUserGuess();
        }
    }

    public static String evaluateGuess(int actualNumber, int userGuess) {
        if (userGuess == actualNumber) {
            return "Correct";
        } else if (userGuess < actualNumber) {
            return "TOO LOW";
        } else {
            return "TOO HIGH";
        }
    }

    public static void playGames() {
        int startRange = 1;  //Starting range 
        int endRange = 100;  //Ending Range
        int attemptsLimit = 10; // Total Number of attempts.  
        int score = 0; // Initial Score
        while (true) {
            int actualNumber = generateRandomNumber(startRange, endRange);
            System.out.println("\nI'm thinking of a number between 1 and 100. Can you guess what it is?");
            for (int attempt = 0; attempt < attemptsLimit; attempt++) {
                int userGuess = getUserGuess();
                String result = evaluateGuess(actualNumber, userGuess);
                if (result.equals("Correct")) {
                    score++;
                    System.out.printf("Congratulations! You guessed the correct number in %d attempts.%n", attempt + 1);
                    break;
                } else {
                    System.out.println(result);
                    if (attempt < attemptsLimit - 1) {
                        System.out.println("Try again!");
                    }
                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            if (!playAgain.toLowerCase().equals("yes")) {
                break;
            }
        }
        System.out.println("Your total score is: " + score);
    }
}