package list_graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by swu on 17/02/2017.
 */
public class ListGraph {
  ArrayList<ListGraphNode> nodes;
  ArrayList<LinkedList<ListGraphNode>> edges;

  public ListGraph(int capacity) {
    nodes = new ArrayList(capacity);
  }

  public void addNode(ListGraphNode n) {
    n.index = nodes.size();
    nodes.add(n);
    edges.add(new LinkedList());
  }

  public void addEdge(ListGraphNode from, ListGraphNode to) {
    LinkedList<ListGraphNode> edges_for_from = edges.get(from.index);
    if (!edges_for_from.contains(to)) {
      edges_for_from.push(to);
    }
  }
}
