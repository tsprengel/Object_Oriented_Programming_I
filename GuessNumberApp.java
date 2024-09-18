import java.util.Scanner;

public class GuessNumberApp {
    
    private static void displayWelcome(int limit) {
        System.out.println("Guess the number!");
        System.out.println("I'm thinking of a number from 1 to " + limit + ".");
        System.out.println();
    }
    
    public static int getRandomInt(int limit) {
        double d = Math.random() * limit;   // d is >= 0.0 and < limit
        int i = (int) d;                    // convert double to int
        i++;                                // int is >= 1 and <= limit
        return i;
    }

    public static void main(String[] args) {
        final int LIMIT = 10;
        
        displayWelcome(LIMIT);
        int number = getRandomInt(LIMIT);

        Scanner sc = new Scanner(System.in);            
        int count = 1;
        int guess = 0;
        while (true) {
            System.out.print("Your guess: ");
            try {
                guess = Integer.parseInt(sc.nextLine());
                }
            catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid number - please enter a whole number from 1 to 10.");
                continue;
            }
            
            if (guess < 1 || guess > LIMIT) {
                System.out.println("ERROR: Invalid guess - please enter a whole number from 1 to 10.");
                continue;
            }
            
            if (guess < number) {
                System.out.println("Too low.");
            } else if (guess > number) {
                System.out.println("Too high.");
            } else {
                System.out.println("You guessed it in " + 
                                   count + " tries.\n");
                break;
            }            
            count++;
        }
        System.out.println("Bye!");
    }   
}
