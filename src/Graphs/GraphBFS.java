package Graphs;

import javax.management.QueryEval;

public class GraphBFS {

    private final int MAX_VERTICES = 20;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int numVertices;
    private QueueX q;

    public GraphBFS() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices= 0;

        for(int i=0; i<MAX_VERTICES; i++) {
            for(int j=0; j<MAX_VERTICES; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        q = new QueueX();
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
        q.insert(0);
        int v2;

        while( !q.isEmpty() ) {
            int v1 = q.remove();
            while( (v2 = getAdjacentUnvisitedVertex(v1)) != -1) {
                vertexList[v2].setHasVisited(true);
                displayVertex(v2);
                q.insert(v2);
            }
        }

        for(int i=0; i<numVertices; i++) {
            vertexList[i].setHasVisited(false);
        }
    }
}
