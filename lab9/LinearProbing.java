class S3olution {

    public int find(int size, HashTable mytable, String word) {

        // fill this in so as to minimize collisions
        // takes in the HashTable object and the word to be found
        // the only thing you can do with the HashTable object is call "check"
        // this method should return the slot in the hashtable where the word is

        int hash = hashFunction(size, word);

        while (!mytable.check(hash, word)) {
            // Linear probing to find the next available slot
            hash = (hash + 1) % size;
        }

        return hash;

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

            while (hashtable[hash] != "") {
                // Linear probing to find the next available slot
                hash = (hash + 1) % size;
            }
            hashtable[hash] = word;
        }
        return hashtable;

    }

    private int hashFunction(int size, String word) {
        int hash = 0;
        for (char c : word.toCharArray()) {
            hash += (int) c;
        }
        return hash % size;
    }
}

/*
 * 6217 - 166507
 * 6199 - 166845
 * 6151 - 166859
 * 769
 * 67
 */