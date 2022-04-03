package algoExpert.easy;

import utils.BinaryTree;

/**
 * @author alireza_bayat
 * created on 1/18/22
 */
public class FindClosestValueInBST {

    // time complexity O(log(n)) | space complexity O(log(n)) cause of stack call back and frame passes
    //worst case time O(n) in un-balanced tree
    public int findClosestValueInBSTRecursive(BinaryTree<Integer> binaryTree, int target) {
        //root node value would be the closest for the starting point
        return findClosestValueInBSTHelperRecursive(binaryTree, target, binaryTree.getValue());
    }

    // time complexity O(log(n)) | space complexity O(1)
    //worst case time O(n) in un-balanced tree
    public int findClosestValueInBSTIterative(BinaryTree<Integer> binaryTree, int target) {
        return findClosestValueInBSTHelperIterative(binaryTree, target, binaryTree.getValue());
    }

    private int findClosestValueInBSTHelperRecursive(BinaryTree<Integer> tree, int target, int closest) {
        if (tree == null)
            return closest;

        int currentNodeClosestDifference = Math.abs(closest - target);
        int closestDifference = Math.abs(tree.getValue() - target);
        if (closestDifference < currentNodeClosestDifference)
            closest = tree.getValue();

        if (target > tree.getValue())
            return findClosestValueInBSTHelperRecursive(tree.getRight(), target, closest);
        else if (target < tree.getValue())
            return findClosestValueInBSTHelperRecursive(tree.getLeft(), target, closest);
        else
            return closest;
    }

    public int findClosestValueInBSTHelperIterative(BinaryTree<Integer> tree, int target, int closest) {
        while (tree != null) {
            int currentNodeClosestDifference = Math.abs(closest - target);
            int closestDifference = Math.abs(tree.getValue() - target);
            if (closestDifference < currentNodeClosestDifference)
                closest = tree.getValue();

            if (target > tree.getValue())
                tree = tree.getRight();
            else if (target < tree.getValue())
                tree = tree.getLeft();
            else {
                closest = tree.getValue();
                break;
            }
        }
        return closest;
    }
}
