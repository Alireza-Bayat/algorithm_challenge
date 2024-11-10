package leet.bst;

import utils.BinaryTree;

/**
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 * INPUT: [236,104,701,null,227,null,911]
 * OUTPUT: 9
 */
public class MinimumAbsoluteDifferenceInBST {

    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(BinaryTree<Integer> root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(BinaryTree<Integer> node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.getValue() - prev));
        }
        prev = node.getValue();
        inOrderTraversal(node.getRight());
    }
}
