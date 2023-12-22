class PriorityQueue {
    String[] prioQueue;
    int top;
    int bottom;
    int maxSize;

    public PriorityQueue(int size) {
        prioQueue = new String[size];
        maxSize = size - 1;
        top = -1;
        bottom = 0;
    }

    /**
     * First check if the prio queue is empty, if it is, add value to pos 0,
     * If not then for every value that i != 0 AND the vowelcount of the value is
     * less that that entry in the array OR that the vowel counts are the same but
     * lexigraphically that entry in the array comes before the value, push that
     * item up in the array by one creating an empty space
     * 
     * once the desired spot is reached, add the value to the blank spot which is in
     * i+1 and then increase the top
     * 
     * @param value the string to be added to the priority queue
     */
    public void push(String value) {
        int vowelCountOfWord = countVowels(value);

        if (!isFull()) {
            if (top == -1) {
                prioQueue[0] = value;
                top++;
            } else {
                int i;
                for (i = top; i >= 0 && (vowelCountOfWord < countVowels(prioQueue[i]) ||
                        (vowelCountOfWord == countVowels(prioQueue[i]) && prioQueue[i].compareTo(value) < 0)); i--) {
                    prioQueue[i + 1] = prioQueue[i];

                }
                prioQueue[i + 1] = value;
                top++;
            }
        }
    }

    /**
     * If the prio queue isnt empty (the top is -1), reduce the top by one, allowing
     * it to be overwritten
     */
    public void pop() {
        if (top != -1) {
            top--;
        }
    }

    /**
     * @return the current top of the prio queue
     */
    public String peek() {
        return prioQueue[top];
    }

    /**
     * Check each character in the value to see if it is a vowel, if it is, increase
     * count by one
     * 
     * @param value to be added to the prio queue
     * @return count the amount of vowels in the string
     */
    public int countVowels(String value) {
        int count = 0;
        String s1 = value.toLowerCase();
        for (int i = 0; i < value.length(); i++) {
            if (s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o'
                    || s1.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean isFull() {
        return (maxSize == top);
    }
}