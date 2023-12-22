public class Stack {
    public int maxSize;
    public String[] stackArray;
    public int top;

    public Stack(int size) {
        stackArray = new String[size];
        maxSize = size - 1;
        top = -1;
    }

    /**
     * Increase the top and write new value into stack
     * 
     * @param value to be added to the stack
     */
    public void push(String value) {
        if (!isFull()) {
            top++;
            stackArray[top] = value;
        }

    }

    /**
     * Doesnt delete it but allows it to be overwritten
     * Don't pop a value off the stack, or increment the stack pointer past it,
     * until you no longer need to have that value there.
     * 
     * @return one level down on the stack
     */
    public void pop() {
        if (top > -1) {
            top--;
        }
    }

    /**
     * Gets the value that top currently represents
     * 
     * @return the number on top of the stack
     */
    public String peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void makeEmpty() {
        top = -1;
    }

    public boolean isFull() {
        return (top == maxSize);
    }

}