import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:\\JavaApps\\Hangman\\Words_alpha.txt"));
        List<String> wordsList = new ArrayList<>();
        while (scanner.hasNext()){
            wordsList.add(scanner.nextLine());
        }

        Random randomizer =new Random();
        String word = wordsList.get(randomizer.nextInt(wordsList.size()));
        System.out.println(word);
        List<Character> currentGuess = new ArrayList<>();

        for(int i=0;i< word.length();i++){                  //print current state for each guess
            if(currentGuess.contains(word.charAt(i)))
                System.out.print(word.charAt(i));
            else {
                System.out.print("-");
            }
        }

    }
}
