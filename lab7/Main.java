public class Main {
    public static void main(String[] args) {
        FileIO FileIO = new FileIO();
        String[] array = FileIO.load("stack.txt");
        Stack myStack = new Stack(100);
        try {

            for (int i = 0; i < array.length; i++) {
                // System.out.println(array[i]);
                if (array[i].contains("PUSH")) {
                    myStack.push(extractValue(array[i]));
                } else {
                    myStack.pop();
                }
            }
        } catch (Exception e) {
            System.out.println(e);

        }

        System.out.println(myStack.peek());
    }

    public static String extractValue(String entry) {
        String value = entry.replaceAll("[PUSH\t]", "");
        return value;
    }
}
