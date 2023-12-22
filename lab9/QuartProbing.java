class Soluti7on {

    public int find(int size, HashTable mytable, String word) {
        // System.out.println("Finding");

        // fill this in so as to minimize collisions
        // takes in the HashTable object and the word to be found
        // the only thing you can do with the HashTable object is call "check"
        // this method should return the slot in the hashtable where the word is

        int index = generateHashKey(word, size);
        int startIndex = index;
        int j = 1;

        while (!mytable.check(index, word)) {
            index = getIndex(startIndex, j, size);
            j++;
        }

        return index;

    }

    public String[] fill(int size, String[] array) {
        System.out.println();

        // takes in the size of the hashtable, and the array of Strings to be placed in
        // the hashtable
        // this should add all the words into the hashtable using some system
        // then it should return the hashtable array

        String[] hashtable = new String[size];
        for (int i = 0; i < size; i++) {
            hashtable[i] = "";
        }
        for (String word : array) {
            int index = generateHashKey(word, size);
            int startIndex = index;
            int j = 0;
            while (!hashtable[index].isEmpty()) {
                index = getIndex(startIndex, j, size);
                j++;
            }
            hashtable[index] = word;
            // hashtable[index] = array[i];

        }
        return hashtable;

    }

    // 151909
    // 151782
    // 151357 - 3.6000368
    // 151355 - 3.60003681
    // public int getIndex(int startIndex, int j, int size) {
    // return (int) ((startIndex + Math.pow(j, 4) * 3.60003681) % size);
    // }

    public int getIndex(int startIndex, int j, int size) {
        return (int) ((startIndex + Math.pow(j, 4)) % size);
    }

    // public int getIndex(int startIndex, int j, int size) {
    // int offset = (int) (Math.pow(j, 4) * 3.60003681) * ((j % 31 == 5) ? 1 : -1);
    // int index = (startIndex + offset) % size;
    // return (index < 0) ? (index + size) : index; //
    // }

    public int generateHashKey(String word, int size) {
        int hash = 0;
        // int slot = word.length();
        // word += word.substring(5);
        for (int i = 0; i < word.length(); i++) {
            hash = (int) ((hash * 6217 + word.charAt(i)) % size);
        }
        return hash;
    }

    // public int generateAsciiHashKey(String word, int size) {
    // int hash = 0;
    // for (int i = 0; i < word.length(); i++) {
    // hash += (int) word.charAt(i);
    // }
    // return hash;
    // }

    /*
     * 6217 - 166507
     * 6199 - 166845
     * 6151 - 166859
     * 769
     * 67
     */

    /*
     * Different attempt with quad probing
     * 
     */
    // public int getIndex(int index, int j, int size) {
    // return (int) (index * j * j * 5) % size;
    // }

    // private int generateHashKey(String word, int size) {
    // int hash = 0;
    // for (char c : word.toCharArray()) {
    // hash = (hash * 31 + c) % size;
    // }
    // return hash;
    // }

}
