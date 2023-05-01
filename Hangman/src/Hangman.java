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
        while (true) {
            getPlayerGuess(keyboardInput, word, currentGuess);
        }
    }
    private static void printCurrentState (String word, List < Character > currentGuess){
        for (int i = 0; i < word.length(); i++) {
            if (currentGuess.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }
    public static void getPlayerGuess(Scanner keyboardInput, String word, List<Character> currentGuess) {
        System.out.println("Please, enter a letter below:");
        String letterGuess = keyboardInput.nextLine();
        currentGuess.add(letterGuess.charAt(0)); // adding the first typed letter to the letter list
        printCurrentState(word, currentGuess);
    }
}
