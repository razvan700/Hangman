import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\JavaApps\\Hangman\\Words_alpha.txt"));//adding required inputs
        Scanner keyboardInput = new Scanner(System.in);
        List<String> wordsList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordsList.add(scanner.nextLine());// add whole file in the list
        }

        Random randomizer = new Random(); // picking the word from the list
        String word = wordsList.get(randomizer.nextInt(wordsList.size()));
        System.out.println(word); // displaying the word

        List<Character> currentGuess = new ArrayList<>();

        printCurrentState(word, currentGuess); // printing out initial state
        int wrongTries = 0;
        while (true) {
            printHangman(wrongTries);
            if(wrongTries>=6){
                System.out.println("You lost!");
                break;
            }
            getPlayerGuess(keyboardInput, word, currentGuess);
            if(printCurrentState(word, currentGuess)){                          // winning situations
                System.out.println("You win!");
                break;
            }
            System.out.println("Please, enter a guess for the entire word:");
            if(keyboardInput.nextLine().equals(word)){
                System.out.println("You win!");
                break;
            }
            else{
                printCurrentState(word, currentGuess);
                System.out.println("Wrong word!");
                wrongTries++;
            }
        }

    }
    public static void printHangman(int wrongTries) {
        System.out.println("  ----------");
        System.out.println(" |          |");
        if (wrongTries >= 1) {
            System.out.println(" 0");
        }
        if (wrongTries >= 2) {
            System.out.print("\\ ");
            if (wrongTries >= 3)
                System.out.println("/");
            else
                System.out.println("");
        }
        if (wrongTries >= 4) {
            System.out.println(" |");
        }
        if (wrongTries >= 5) {
            System.out.print("/");
            if (wrongTries >= 6)
                System.out.println(" \\");
            else
                System.out.println("");
        }
    }

    private static boolean printCurrentState (String word, List < Character > currentGuess){ // prints out the current state of te word
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (currentGuess.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                count++;
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
        return (word.length() == count);
    }
    public static boolean getPlayerGuess(Scanner keyboardInput, String word, List<Character> currentGuess) {
        System.out.println("Please, enter a letter below:");
        String letterGuess = keyboardInput.nextLine();
        currentGuess.add(letterGuess.charAt(0)); // adding the first typed letter to the letter list
        return word.contains(letterGuess);
    }
}
