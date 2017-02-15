package graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by swu on 15/02/2017.
 *
 * Graph implemented by Adjacency List
 */
public class Graph {
  ArrayList<GraphNode> nodes;
  ArrayList<LinkedList<GraphNode>> edges;

  public Graph(int nbNodes, String[] nodes_input) {
    nodes = new ArrayList<>(nbNodes);
    edges = new ArrayList<>(nbNodes);
    for (int i = 0; i < nbNodes; i++) {
      nodes.add(new GraphNode(nodes_input[i], i));
      edges.add(new LinkedList<>());
    }
  }

  public void addEdge(GraphNode from, GraphNode to) {
    LinkedList<GraphNode> list = edges.get(from.index);
    if (!list.contains(to)) list.push(to);
  }

  public void deleteEdge(GraphNode from, GraphNode to) {
    LinkedList<GraphNode> list = edges.get(from.index);
    list.remove(to);
  }
}
