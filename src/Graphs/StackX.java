package Graphs;

public class StackX {

    private static int SIZE = 20;
    private int stack[];
    private int top;

    public StackX() {
        stack = new int[SIZE];
        top = -1;
    }

    public void push(int i) {
        stack[++top] = i;
    }

    public int pop() {
        return stack[top--];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return ( top == -1 );
    }
}
