package Graphs;

public class GraphDFS {

    private final int MAX_VERTICES = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int numVertices;
    private StackX stack;

    public GraphDFS() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices= 0;

        for(int i=0; i<MAX_VERTICES; i++) {
            for(int j=0; j<MAX_VERTICES; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        stack = new StackX();
    }

    public void addVertex(char label) {
        vertexList[numVertices++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    public int getAdjacentUnvisitedVertex(int v) {
        for(int i=0; i<numVertices; i++) {
            if(adjMatrix[v][i] == 1 && vertexList[i].isHasVisited() == false) {
                return i;
            }
        }
        return -1;
    }

    public void DFS() {
        vertexList[0].setHasVisited(true);
        displayVertex(0);
        stack.push(0);

        while( !stack.isEmpty() ) {
            int vertex = getAdjacentUnvisitedVertex(stack.peek());
            if(vertex == -1) {
                stack.pop();
            } else {
                vertexList[vertex].setHasVisited(true);
                displayVertex(vertex);
                stack.push(vertex);
            }
        }

        for(int i=0; i<numVertices; i++) {
            vertexList[i].setHasVisited(false);
        }
    }
}
