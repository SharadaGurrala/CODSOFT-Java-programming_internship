import java.util.Random;
import java.util.Scanner;

public class NumberGuessing{
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();

        int round=1;
        boolean playAgain=true;
        int totalScore =0;

        while(playAgain){
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;
            System.out.println("Round "+round+ "\n");
            int numberToGuess = random.nextInt(100)+1;
            while(attempts<maxAttempts && !hasGuessedCorrectly){
                System.out.println("Enter your guess (attempt" +(attempts+1)+"):");
                int guess = scanner.nextInt();
                attempts++;

                if(guess > numberToGuess){
                    System.out.println("guess low please\n");
                }
                else if(guess < numberToGuess){
                    System.out.println("guess high please\n");
                }
                else{
                    System.out.println("your guess is right, congrats\n");
                    hasGuessedCorrectly = true;
                    totalScore +=(maxAttempts-attempts+1);

                }
            }
        
        
                
            
                if(!hasGuessedCorrectly){
                    System.out.println("sorry! you've used all your attempts. The number was "+numberToGuess);
                }

                System.out.println("your score in this round "+(hasGuessedCorrectly?(maxAttempts-attempts+1):0));
                System.out.println("your total score is "+totalScore);

                System.out.println("want to play again? (yes/no)\n");
                playAgain = scanner.next().equalsIgnoreCase("yes");
                round++;
            
            }

                System.out.println("Thanks for playing, and your final score is "+totalScore+"\n");
                scanner.close();
                





                

            
        



    }
}