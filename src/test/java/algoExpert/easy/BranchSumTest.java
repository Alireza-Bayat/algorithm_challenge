package algoExpert.easy;

import utils.BinaryTree;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alireza_bayat
 * created on 1/17/22
 */
public class BranchSumTest {

    BinaryTree<Integer> rootNode;
    BranchSum branchSum;

    @Before
    public void setup() {
        branchSum = new BranchSum();
        rootNode = new BinaryTree<>(0);
        BinaryTree<Integer> root_left = new BinaryTree<>(1);
        BinaryTree<Integer> root_right = new BinaryTree<>(2);
        BinaryTree<Integer> root_left_left = new BinaryTree<>(3);
        BinaryTree<Integer> root_left_right = new BinaryTree<>(4);
        BinaryTree<Integer> root_right_left = new BinaryTree<>(5);
        BinaryTree<Integer> root_right_right = new BinaryTree<>(61);
        BinaryTree<Integer> root_right_right_right = new BinaryTree<>(1);

        root_right_right.setRight(root_right_right_right);
        root_right.setLeft(root_right_left);
        root_right.setRight(root_right_right);
        root_left.setRight(root_left_right);
        root_left.setLeft(root_left_left);
        rootNode.setLeft(root_left);
        rootNode.setRight(root_right);
    }

    @Test
    public void getBranchSum() {
        this.branchSum.getBranchSum(rootNode).forEach(System.out::println);
    }
}