package tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Shuang on 2017/2/12.
 */
public class BinaryTreeTest extends TestCase {
  @Test
  public void testIsFullTest() {
    BinaryTreeNode l1 = new BinaryTreeNode();
    BinaryTreeNode ll1 = new BinaryTreeNode();
    BinaryTreeNode ll2 = new BinaryTreeNode();
    l1.setLeaf(ll1, ll2);
    BinaryTreeNode r1 = new BinaryTreeNode();
    BinaryTreeNode rr1 = new BinaryTreeNode();
    BinaryTreeNode rr2 = new BinaryTreeNode();
    r1.setLeaf(rr1, rr2);

    BinaryTreeNode root = new BinaryTreeNode();
    root.setLeaf(l1, r1);

    BinaryTree tree = new BinaryTree(root);
    assert tree.isFull() == true;

    l1.setLeaf(null, ll2);
    assert tree.isFull() == false;

    root.setLeaf(null, r1);
    assert tree.isFull() == false;
  }

  @Test
  public void testIsCompleteTest() {
    BinaryTreeNode l1 = new BinaryTreeNode();
    BinaryTreeNode ll1 = new BinaryTreeNode();
    BinaryTreeNode ll2 = new BinaryTreeNode();
    l1.setLeaf(ll1, ll2);
    BinaryTreeNode r1 = new BinaryTreeNode();
    BinaryTreeNode rr1 = new BinaryTreeNode();
    BinaryTreeNode rr2 = new BinaryTreeNode();
    r1.setLeaf(rr1, rr2);

    assert new BinaryTree(r1).isComplete() == true;
    r1.setLeaf(null, rr2);
    assert new BinaryTree(r1).isComplete() == false;

    BinaryTreeNode root = new BinaryTreeNode();
    root.setLeaf(l1, r1);

    BinaryTree tree = new BinaryTree(root);
    assert tree.isComplete() == true;

    root.setLeaf(null, r1);
    assert tree.isComplete() == true;

    l1.setLeaf(null, ll2);
    assert tree.isComplete() == false;
  }
}
