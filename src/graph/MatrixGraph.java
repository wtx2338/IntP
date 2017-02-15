package graph;

/**
 * Created by swu on 15/02/2017.
 *
 * Graph implemented by Matrix
 */
public class MatrixGraph {
  GraphNode[] nodes;
  int[][] edges;

  public MatrixGraph(String[] nodes_input) {
    nodes = new GraphNode[nodes_input.length];
    for (int i = 0; i < nodes_input.length; i++) {
      nodes[i] = new GraphNode(nodes_input[i], i);
    }
    edges = new int[nodes_input.length][nodes_input.length];
  }

  public void addEdges(GraphNode from, GraphNode to, int distance) {
    edges[from.index][to.index] = distance;
  }

  public void deleteEdges(GraphNode from, GraphNode to) {
    edges[from.index][to.index] = 0;
  }
}
