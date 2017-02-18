package list_graph;

/**
 * Created by swu on 17/02/2017.
 */
public class ListGraphNode {
  ListGraphNode parent;
  public Integer index;
  public String value;
  public ListNodeStatus status;

  public ListGraphNode(String v) {
    value = v;
    status = ListNodeStatus.Unvisited;
  }

  public String toString() {
    if (parent != null)
      return value + " parent: " + parent.value + " ";
    else
      return value;
  }
}
