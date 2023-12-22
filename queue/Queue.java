public class Queue {
    public int size;
    public long[] queueArray;
    public int head;
    public int tail;

    public Queue(int size) {
        queueArray = new long[size];
        head = -1;
        tail = -1;
    }

    public void enqueue(long value) {
        if 
        tail++;
        queueArray[tail] = value;

    }

    public void dequeue() {
        if (head != tail) {
            head++;
        } else {
            head = -1;
            tail = -1;
        }

    }

    public boolean isEmpty() {
        if (head == -1 && tail == -1) {
            return true;
        } else {
            return false;
        }
    }

    public long peak() {
        return queueArray[head];
    }
}