package leet;

import utils.BinaryTree;

public class ValidateBST {

    private static boolean isValidBST(BinaryTree<Integer> root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(BinaryTree<Integer> root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.getValue() > high || root.getValue() < low)
            return false;

        return validate(root.getLeft(), low, root.getValue()) && validate(root.getRight(), root.getValue(), high);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        BinaryTree<Integer> root_left = new BinaryTree<>(4);
        BinaryTree<Integer> root_right = new BinaryTree<>(8);
//        BinaryTree<Integer> root_left_left = new BinaryTree<>(3);
//        BinaryTree<Integer> root_left_right = new BinaryTree<>(4);
        BinaryTree<Integer> root_right_left = new BinaryTree<>(6);
        BinaryTree<Integer> root_right_right = new BinaryTree<>(9);
//        BinaryTree<Integer> root_right_right_right = new BinaryTree<>(1);

//        root_right_right.setRight(root_right_right_right);
        root_right.setLeft(root_right_left);
        root_right.setRight(root_right_right);
//        root_left.setRight(root_left_right);
//        root_left.setLeft(root_left_left);
        tree.setLeft(root_left);
        tree.setRight(root_right);

        System.out.println(isValidBST(tree));
    }
}
