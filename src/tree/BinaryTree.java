package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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

  public boolean isComplete() {
    if (root.isLeaf) {
      return true;
    } else {
      return root.left != null
          && root.right != null
          && subTreeLeft().isComplete()
          && subTreeRight().isComplete();
    }
  }

  public void preO() {
    if (root == null) {
      System.out.print("* ");
    } else if (root.isLeaf) {
      System.out.print(root.value + " ");
    } else {
      System.out.print(root.value + " ");
      new BinaryTree(root.left).preO();
      new BinaryTree(root.right).preO();
    }
  }

  public void inOrder() {
    if (root == null) {
      System.out.print("* ");
    } else if (root.isLeaf) {
      System.out.print(root.value + " ");
    } else {
      new BinaryTree(root.left).inOrder();
      System.out.print(root.value + " ");
      new BinaryTree(root.right).inOrder();
    }
  }

  public void postO() {
    if (root == null) {
      System.out.print("* ");
    } else if (root.isLeaf) {
      System.out.print(root.value + " ");
    } else {
      new BinaryTree(root.left).postO();
      new BinaryTree(root.right).postO();
      System.out.print(root.value + " ");
    }
  }

  public void levelO() {
    Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<>();
    queue.add(this.root);
    while(!queue.isEmpty()) {
      BinaryTreeNode node = queue.remove();
      System.out.print(node.value);
      if(node.left != null) {
        queue.add(node.left);
      }
      if(node.right != null) {
        queue.add(node.right);
      }
    }
  }

  public static void main(String [] args) {
    BinaryTreeNode A = new BinaryTreeNode("A");
    BinaryTreeNode B = new BinaryTreeNode("B");
    BinaryTreeNode C = new BinaryTreeNode("C");
    BinaryTreeNode D = new BinaryTreeNode("D");
    BinaryTreeNode E = new BinaryTreeNode("E");
    BinaryTreeNode F = new BinaryTreeNode("F");

    A.setLeft(B);
    A.setRight(C);
    B.setLeft(D);
    B.setRight(E);
    C.setLeft(F);
    new BinaryTree(A).levelO();
    System.out.println("");
  }
}
