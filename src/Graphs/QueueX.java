package Graphs;

public class QueueX {

    private final int SIZE = 20;
    private int[] array;
    private int front;
    private int rear;

    public QueueX() {
        array = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int i) {
        if(rear == SIZE-1) {
            rear = -1;
        }
        array[++rear] = i;
    }

    public int remove() {
        int temp = array[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return ( rear+1==front || front+SIZE-1==rear );
    }
}
