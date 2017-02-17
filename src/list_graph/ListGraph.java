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
    edges = new ArrayList(capacity);
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

  public String toString() {
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < edges.size(); i++) {
      builder.append(nodes.get(i));
      builder.append(edges.get(i).toString());
      builder.append("\n");
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    ListGraphNode a = new ListGraphNode("A");
    ListGraphNode b = new ListGraphNode("B");
    ListGraphNode c = new ListGraphNode("C");
    ListGraphNode d = new ListGraphNode("D");
    ListGraphNode e = new ListGraphNode("E");
    ListGraph graph = new ListGraph(10);
    graph.addNode(a);
    graph.addNode(b);
    graph.addNode(c);
    graph.addNode(d);
    graph.addNode(e);

    graph.addEdge(a, b);
    graph.addEdge(a, e);
    graph.addEdge(b, e);
    graph.addEdge(e, e);

    System.out.println(graph);
  }
}
