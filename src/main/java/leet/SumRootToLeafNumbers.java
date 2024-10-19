package leet;

import utils.BinaryTree;

public class SumRootToLeafNumbers {

    private static int sumNumbers(BinaryTree<Integer> root) {
        return sum(root, 0);
    }

    private static int sum(BinaryTree<Integer> root, int sum) {
        if (root == null) {
            return 0;
        } else {
            sum = sum * 10;
            int val = root.getValue() + sum;
            int left = sum(root.getLeft(), val);
            int right = sum(root.getRight(), val);

            int result = left + right;
            return result == 0 ? val : result;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        BinaryTree<Integer> root_left = new BinaryTree<>(2);
        BinaryTree<Integer> root_right = new BinaryTree<>(3);
//        BinaryTree<Integer> root_left_left = new BinaryTree<>(3);
//        BinaryTree<Integer> root_left_right = new BinaryTree<>(4);
//        BinaryTree<Integer> root_right_left = new BinaryTree<>(3);
//        BinaryTree<Integer> root_right_right = new BinaryTree<>(7);
//        BinaryTree<Integer> root_right_right_right = new BinaryTree<>(1);

//        root_right_right.setRight(root_right_right_right);
//        root_right.setLeft(root_right_left);
//        root_right.setRight(root_right_right);
//        root_left.setRight(root_left_right);
//        root_left.setLeft(root_left_left);
        tree.setLeft(root_left);
        tree.setRight(root_right);

        System.out.println(sumNumbers(tree));

    }
}
