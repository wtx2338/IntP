package tree;

/**
 * Created by Shuang on 2017/2/12.
 */
public class BinaryTreeNode {
  BinaryTreeNode left;
  BinaryTreeNode right;
  BinaryTreeNode parent;
  boolean isLeaf = true;
  String value;

  public BinaryTreeNode() {
    super();
    left = null;
    right = null;
    parent = null;
    isLeaf = true;
    value = "";
  }

  public BinaryTreeNode(String v) {
    super();
    left = null;
    right = null;
    parent = null;
    isLeaf = true;
    value = v;
  }

  public void setLeft(BinaryTreeNode l) {
    if (l != null) {
      this.left = l;
      this.left.parent = this;
    }
    isLeaf = false;
  }

  public void setRight(BinaryTreeNode r) {
    if (r != null) {
      this.right = r;
      this.right.parent = this;
    }
    isLeaf = false;
  }
}
