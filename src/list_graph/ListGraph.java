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

  private LinkedList<ListGraphNode> getLinkedNodes(ListGraphNode n) {
    return edges.get(n.index);
  }

  /**
   * For the BFS(Breadth-first search)
   * The main ideal of the queue implementation is based on FIFO queue
   * The visit is similar with tree visit, just flag the node visited to avoid double visit
   * @param from
   */
  public void BFS(ListGraphNode from) {
    for (ListGraphNode n : this.nodes) {
      n.status = ListNodeStatus.Unvisited;
    }
    LinkedList<ListGraphNode> queue = new LinkedList<ListGraphNode>();
    from.status = ListNodeStatus.Visiting;
    queue.add(from);
    while(queue.size() > 0) {
      ListGraphNode current = queue.removeFirst();
      LinkedList<ListGraphNode> linked_to_current = this.getLinkedNodes(current);
      for (ListGraphNode n : linked_to_current) {
        if (n.status == ListNodeStatus.Unvisited) {
          n.parent = current;
          n.status = ListNodeStatus.Visiting;
          queue.add(n);
        }
      }
      current.status = ListNodeStatus.Visited;
    }
  }

  /**
   * For the DFS(Depth-first search)
   * Similar with BFS, but instead use a FIFO tree, this time we are using a FILO stack
   * @param from
   */
  public void DFS(ListGraphNode from) {
    for (ListGraphNode n : this.nodes) {
      n.status = ListNodeStatus.Unvisited;
    }
    LinkedList<ListGraphNode> stack = new LinkedList<ListGraphNode>();
    from.status = ListNodeStatus.Visiting;
    stack.add(from);
    while(stack.size() > 0) {
      ListGraphNode current = stack.removeLast();
      LinkedList<ListGraphNode> linked_to_current = this.getLinkedNodes(current);
      for (ListGraphNode n : linked_to_current) {
        if (n.status == ListNodeStatus.Unvisited) {
          n.parent = current;
          n.status = ListNodeStatus.Visiting;
          stack.add(n);
        }
      }
      current.status = ListNodeStatus.Visited;
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
    ListGraphNode f = new ListGraphNode("F");
    ListGraphNode g = new ListGraphNode("G");
    ListGraph graph = new ListGraph(10);
    graph.addNode(a);
    graph.addNode(b);
    graph.addNode(c);
    graph.addNode(d);
    graph.addNode(e);
    graph.addNode(f);
    graph.addNode(g);

    graph.addEdge(a, b);
    graph.addEdge(a, d);
    graph.addEdge(a, g);
    graph.addEdge(b, c);
    graph.addEdge(c, f);
    graph.addEdge(d, b);
    graph.addEdge(d, e);
    graph.addEdge(g, f);

    System.out.println(graph);

    graph.BFS(a);
    for (ListGraphNode n : graph.nodes) {
      System.out.println(n);
    }

    graph.DFS(a);
    for (ListGraphNode n : graph.nodes) {
      System.out.println(n);
    }
  }
}
