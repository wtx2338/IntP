package tree;

/**
 * Created by Shuang on 2017/2/12.
 */
public class BinaryTreeNode {
  BinaryTreeNode left;
  BinaryTreeNode right;
  BinaryTreeNode parent;
  boolean isLeaf = true;
  int value;

  public void setLeaf(BinaryTreeNode l, BinaryTreeNode r) {
    if (l != null) {
      this.left = l;
      this.left.parent = this;
    } else {
      this.left = null;
    }
    if (r != null) {
      this.right = r;
      this.right.parent = this;
    } else {
      this.right = null;
    }
    isLeaf = false;
  }
}
