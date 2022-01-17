package algoExpert.easy;

import algoExpert.utils.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author alireza_bayat
 * created on 1/17/22
 */
public class BranchSumTest {

    BinaryTree rootNode;
    BranchSum branchSum;

    @Before
    public void setup() {
        branchSum = new BranchSum();
        rootNode = new BinaryTree(0);
        BinaryTree root_left = new BinaryTree(1);
        BinaryTree root_right = new BinaryTree(2);
        BinaryTree root_left_left = new BinaryTree(3);
        BinaryTree root_left_right = new BinaryTree(4);
        BinaryTree root_right_left = new BinaryTree(5);
        BinaryTree root_right_right = new BinaryTree(61);
        BinaryTree root_right_right_right = new BinaryTree(1);

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