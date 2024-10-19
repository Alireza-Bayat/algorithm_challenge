package leet;


import utils.BinaryTree;

public class InvertBinaryTree {

    public static BinaryTree<Integer> invertTree(BinaryTree<Integer> root) {
        if (root == null){
            return null;
        }

        BinaryTree<Integer> right = invertTree(root.getRight());
        BinaryTree<Integer> left = invertTree(root.getLeft());
        root.setLeft(right);
        root.setRight(left);

        return root;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(2);
        BinaryTree<Integer> root_left = new BinaryTree<>(1);
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

        System.out.println(invertTree(tree).toString());
    }
}
