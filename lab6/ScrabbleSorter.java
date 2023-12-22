import java.util.*;

public class scrabbleSorter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arrayLength = Integer.parseInt(input.nextLine());
        String[] wordsArray = new String[arrayLength];

        if (arrayLength >= 0 && arrayLength <= 100) {
            for (int i = 0; i < wordsArray.length; i++) {
                wordsArray[i] = input.nextLine();
            }

            int[] wordScores = new int[arrayLength];
            for (int i = 0; i < wordsArray.length; i++) {
                wordScores[i] = wordScore(wordsArray[i]);
            }

            arraySort(wordScores, wordsArray);

            for (int i = 0; i < wordsArray.length; i++) {
                System.out.println(wordsArray[i]);
            }
        } else {
            System.out.println("Invalid quantity of words");
        }
        // System.out.println(wordScore("one"));

    }

    /**
     * 
     * if the array has a lower score, it switches its place. If two words have the
     * same score it then compares them alphabetically to see if its greater than,
     * if it is, switch both the numbers in the score array and the words in
     * the words array
     * 
     * @param wordScores an array of the scores of each words
     * @param wordsArray an array of all the words to be sorted
     */
    public static void arraySort(int[] wordScores, String[] wordsArray) {
        for (int i = 0; i < wordScores.length; i++) {
            for (int j = 0; j < wordScores.length - 1; j++) {
                if (wordScores[j] == wordScores[j + 1]) {
                    if (wordsArray[j].compareTo(wordsArray[j + 1]) > 0) {
                        int temp = wordScores[j];
                        String tempString = wordsArray[j];
                        wordScores[j] = wordScores[j + 1];
                        wordsArray[j] = wordsArray[j + 1];
                        wordScores[j + 1] = temp;
                        wordsArray[j + 1] = tempString;
                    }
                }
                if (wordScores[j] > wordScores[j + 1]) {
                    int temp = wordScores[j];
                    String tempString = wordsArray[j];
                    wordScores[j] = wordScores[j + 1];
                    wordsArray[j] = wordsArray[j + 1];
                    wordScores[j + 1] = temp;
                    wordsArray[j + 1] = tempString;
                }
            }

        }
    }

    /**
     * It loops through all characters in the string, getting the score of each
     * character using the letterScore method
     * 
     * @param word to find the score off
     * @return the score of the word
     */
    public static int wordScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += letterScore(word.toLowerCase().charAt(i));
        }
        return score;
    }

    /**
     * Take in a character, compare it with if statements and return its correct
     * point score
     * 
     * @param c the character of the word
     * @return the score that character gives
     */
    public static int letterScore(char c) {

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'l' || c == 'n' || c == 's' || c == 't'
                || c == 'r')
            return 1;
        else if (c == 'd' || c == 'g')
            return 2;
        else if (c == 'b' || c == 'c' || c == 'm' || c == 'p')
            return 3;
        else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y')
            return 4;
        else if (c == 'k')
            return 5;
        else if (c == 'j' || c == 'x')
            return 8;
        else if (c == 'q' || c == 'z')
            return 10;
        else
            return 0;

    }

}