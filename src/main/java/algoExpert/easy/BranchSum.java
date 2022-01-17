package algoExpert.easy;

import algoExpert.utils.BinaryTree;

import java.util.ArrayList;

/**
 * @author alireza_bayat
 * created on 1/17/22
 */
public class BranchSum {

    public ArrayList<Integer> getBranchSum(BinaryTree binaryTree) {
        ArrayList<Integer> sums = new ArrayList<>();
        getBranchSum(binaryTree, sums, 0);
        return sums;
    }

    //time/space(worst case, unbalanced tree) complexity = O(n)
    private void getBranchSum(BinaryTree binaryTreeRootNode, ArrayList<Integer> sum, int branchSum) {
        if (binaryTreeRootNode == null)
            return;
        branchSum += binaryTreeRootNode.getValue();
        if (binaryTreeRootNode.getLeft() == null && binaryTreeRootNode.getRight() == null) {
            sum.add(branchSum);
            return;
        }

        getBranchSum(binaryTreeRootNode.getLeft(), sum, branchSum);
        getBranchSum(binaryTreeRootNode.getRight(), sum, branchSum);
    }
}
