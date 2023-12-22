class Solution {

    public int find(int size, HashTable mytable, String word) {

        // fill this in so as to minimize collisions
        // takes in the HashTable object and the word to be found
        // the only thing you can do with the HashTable object is call "check"
        // this method should return the slot in the hashtable where the word is

        int hash = hashFunction(size, word);
        int secondHash = secondHashFunction(size, word);

        for (int i = 0; i < size; i++) {
            int key = (hash + i * secondHash) % size;
            if (mytable.check(key, word)) {
                return key;
            }
        }

        return -1;

    }

    public String[] fill(int size, String[] array) {

        // takes in the size of the hashtable, and the array of Strings to be placed in
        // the hashtable
        // this should add all the words into the hashtable using some system
        // then it should return the hashtable array
        String[] hashtable = new String[size];
        // System.out.println(hashtable.length);
        for (int i = 0; i < size; i++) {
            hashtable[i] = "";
        }
        for (String word : array) {
            int hash = hashFunction(size, word);
            int secondHash = secondHashFunction(size, word);

            for (int i = 0; i < size; i++) {
                int key = (hash + i * secondHash) % size;
                if (hashtable[key] == "") {
                    hashtable[key] = word;
                    break;
                }
            }
        }

        return hashtable;

    }

    private int hashFunction(int size, String word) {
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash = (hash * 6217 + c) % size;
        }
        return hash;
    }

    private int secondHashFunction(int size, String word) {
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash = (hash * 6151 + c) % size;
        }
        return hash;
    }
}

/*
 * 6217 - 166507
 * 6199 - 166845
 * 6151 - 166859
 * 769
 * 67
 */