public class Main {
    public static void main(String[] args) {
        FileIO FileIO = new FileIO();
        String[] array = FileIO.load("queue.txt");
        Queue myQueue = new Queue(100);
        for (int i = 0; i < array.length; i++) {
            System.out.print("Head: " + myQueue.head + " Tail: " + myQueue.tail + "\n");
            if (array[i].contains("INSERT")) {
                myQueue.enqueue(extractValue(array[i]));
                // System.out.println("INSERT");
            } else {
                myQueue.dequeue();
                // System.out.println("REMOVE");
            }
        }

        System.out.println(myQueue.peak());
    }

    public static String extractValue(String entry) {
        String value = entry.replaceAll("[INSERT\t]", "");
        return value;
    }
}