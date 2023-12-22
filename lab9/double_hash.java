// was to slow
class Solut3ion {

    public int find(int size, HashTable mytable, String word) {

        // fill this in so as to minimize collisions
        // takes in the HashTable object and the word to be found
        // the only thing you can do with the HashTable object is call "check"
        // this method should return the slot in the hashtable where the word is

        // String mytable = "";

        int input = word.length();
        int index = input % size;

        boolean found = false;
        if (mytable.check(index, word)) {
            return index;
        } else {
            int j = 1;
            int key = 55 - (input % 54);
            while ((!found)) {
                int hashIndex = (index + j * key) % size;
                if (mytable.check(hashIndex, word)) {
                    return hashIndex;
                }
                j++;
            }
        }
        return -1;

    }

    public String[] fill(int size, String[] array) {
        System.out.println(array.length);

        // takes in the size of the hashtable, and the array of Strings to be placed in
        // the hashtable
        // this should add all the words into the hashtable using some system
        // then it should return the hashtable array
        String[] hashtable = new String[size];
        // System.out.println(hashtable.length);
        for (int i = 0; i < size; i++) {
            hashtable[i] = "";
        }
        for (int i = 0; i < array.length; i++) {
            int input = array[i].length();
            int maxSize = hashtable.length;
            int index = input % maxSize;

            // boolean planted = false;

            if (hashtable[index] == "") {
                hashtable[index] = array[i];
            } else {
                int j = 1;
                int key = 8 - (input % 8);
                while (true) {
                    int hashIndex = (index + j * key) % maxSize;
                    if (hashtable[hashIndex] == "") {
                        hashtable[hashIndex] = array[i];
                        break;
                    }
                    j++;

                }
            }

        }

        return hashtable;

    }
}