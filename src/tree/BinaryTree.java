package tree;

/**
 * Created by Shuang on 2017/2/12.
 */
public class BinaryTree {
  BinaryTreeNode root;

  public BinaryTree(BinaryTreeNode r) {
    root = r;
  }

  public BinaryTree subTreeLeft() {
    return new BinaryTree(root.left);
  }

  public BinaryTree subTreeRight() {
    return new BinaryTree(root.right);
  }

  public boolean isFull() {
    if (root.isLeaf) {
      return true;
    } else {
      return root.left != null
          && root.right != null
          && subTreeLeft().isFull()
          && subTreeRight().isFull();
    }
  }


  public boolean isComplete() {
    if (root.isLeaf) {
      return new BinaryTree(root.parent).isFull();
    } else {
      return subTreeLeft().isComplete()
          && subTreeRight().isComplete();
    }
  }
}
