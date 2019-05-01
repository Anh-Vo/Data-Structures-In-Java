package Graphs;

public class Vertex {

    private char label;
    private boolean hasVisited;

    public Vertex(char label) {
        this.label = label;
        hasVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }
}
