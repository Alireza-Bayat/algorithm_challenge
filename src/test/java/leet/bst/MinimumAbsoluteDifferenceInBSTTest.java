package leet.bst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utils.BinaryTree;

public class MinimumAbsoluteDifferenceInBSTTest {

    private MinimumAbsoluteDifferenceInBST minimumAbsoluteDifferenceInBST;

    @Before
    public void prepare() {
        minimumAbsoluteDifferenceInBST = new MinimumAbsoluteDifferenceInBST();
    }

    @Test
    public void getMinimumDifference() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(236);
        BinaryTree<Integer> root_left = new BinaryTree<>(104);
        BinaryTree<Integer> root_right = new BinaryTree<>(701);
        BinaryTree<Integer> root_left_right = new BinaryTree<>(227);
        BinaryTree<Integer> root_right_right = new BinaryTree<>(911);


        root_right.setRight(root_right_right);
        root_left.setRight(root_left_right);
        rootNode.setLeft(root_left);
        rootNode.setRight(root_right);

        Assert.assertEquals(9, minimumAbsoluteDifferenceInBST.getMinimumDifference(rootNode));
    }
}