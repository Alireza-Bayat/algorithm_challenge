package algoExpert.easy;

import algoExpert.utils.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindClosestValueInBSTTest {


    BinaryTree<Integer> rootNodeBST;
    FindClosestValueInBST findClosestValueInBST;

    @Before
    public void setup() {
        findClosestValueInBST = new FindClosestValueInBST();
        rootNodeBST = new BinaryTree<>(10);
        BinaryTree<Integer> root_left = new BinaryTree<>(8);
        BinaryTree<Integer> root_right = new BinaryTree<>(15);
        BinaryTree<Integer> root_left_left = new BinaryTree<>(3);
        BinaryTree<Integer> root_left_right = new BinaryTree<>(6);
        BinaryTree<Integer> root_right_left = new BinaryTree<>(11);
        BinaryTree<Integer> root_right_right = new BinaryTree<>(16);
        BinaryTree<Integer> root_right_right_right = new BinaryTree<>(20);

        root_right_right.setRight(root_right_right_right);
        root_right.setLeft(root_right_left);
        root_right.setRight(root_right_right);
        root_left.setRight(root_left_right);
        root_left.setLeft(root_left_left);
        rootNodeBST.setLeft(root_left);
        rootNodeBST.setRight(root_right);
    }

    @Test
    public void findClosestValueInBST() {
        Assert.assertEquals(20, findClosestValueInBST.findClosestValueInBSTRecursive(rootNodeBST, 21));
        Assert.assertEquals(20, findClosestValueInBST.findClosestValueInBSTIterative(rootNodeBST, 21));
    }

    @Test
    public void findClosestValueInBST_lessThanRoot() {
        Assert.assertEquals(3, findClosestValueInBST.findClosestValueInBSTRecursive(rootNodeBST, 2));
        Assert.assertEquals(3, findClosestValueInBST.findClosestValueInBSTIterative(rootNodeBST, 2));
    }

    @Test
    public void findClosestValueInBST_equalToRoot() {
        Assert.assertEquals(11, findClosestValueInBST.findClosestValueInBSTRecursive(rootNodeBST, 11));
        Assert.assertEquals(11, findClosestValueInBST.findClosestValueInBSTIterative(rootNodeBST, 11));
    }
}