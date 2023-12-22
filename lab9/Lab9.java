import java.util.*;
import java.io.*;

public class Lab9 {

    public static void main(String[] args) {
        File file = new File("HashTable.txt");

        int inputSize = 90000;
        String[] input = new String[inputSize];
        try {
            Scanner scan = new Scanner(file);

            for (int i = 0; i < inputSize; i++) {
                input[i] = scan.nextLine();
            }
            scan.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        int size = 99991;
        // int size = 2147483647 / 500;
        Solution mysolution = new Solution();
        String[] hashtable = mysolution.fill(size, input);
        HashTable mytable = new HashTable(hashtable);
        Solution mysolution2 = new Solution(); // prevents cheating
        for (int i = 0; i < inputSize; i++) {
            int rand = (int) (Math.random() * inputSize);
            String temp = input[i];
            input[i] = input[rand];
            input[rand] = temp;
        }
        int total = 0;
        for (int i = 0; i < inputSize; i++) {
            int slot = mysolution2.find(size, mytable, input[i]);
            if (!hashtable[slot].equals(input[i])) {
                System.out.println("error!");
            }
        }
        long status = mytable.gettotal();
        System.out.println("Collisions: " + status);
    }

}