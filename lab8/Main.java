public class Main {

    public static void main(String[] args) {
        // System.out.println("as");
        FileIO FileIO = new FileIO();
        PriorityQueue myPriorityQueue = new PriorityQueue(100);
        String[] array = FileIO.load("queue.txt");
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("INSERT")) {
                myPriorityQueue.push(extractValue(array[i]));
            } else if (array[i].contains("REMOVE")) {
                myPriorityQueue.pop();
            } else if (array[i].contains("PEEK")) {
                System.out.println(myPriorityQueue.peek());
            }
        }
    }

    public static String extractValue(String entry) {
        String value = entry.replaceAll("[INSERT\t]", "");
        return value;
    }
}