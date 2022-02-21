package algoExpert.medium;

import algoExpert.utils.BinaryTree;
import org.junit.Before;
import org.junit.Test;

public class BSTConstructionTest {

    private BSTConstruction bstConstruction;
    private BinaryTree<Integer> rootNode;

    @Before
    public void setup() {
        bstConstruction = new BSTConstruction();
        rootNode = new BinaryTree<>(10);
        BinaryTree<Integer> root_left = new BinaryTree<>(7);
        BinaryTree<Integer> root_right = new BinaryTree<>(20);
        BinaryTree<Integer> root_left_left = new BinaryTree<>(3);
        BinaryTree<Integer> root_left_right = new BinaryTree<>(8);
        BinaryTree<Integer> root_right_left = new BinaryTree<>(15);
        BinaryTree<Integer> root_right_right = new BinaryTree<>(25);
        BinaryTree<Integer> root_right_right_right = new BinaryTree<>(50);
        BinaryTree<Integer> root_right_left_left = new BinaryTree<>(12);

        root_right_left.setLeft(root_right_left_left);
        root_right_right.setRight(root_right_right_right);
        root_right.setLeft(root_right_left);
        root_right.setRight(root_right_right);
        root_left.setRight(root_left_right);
        root_left.setLeft(root_left_left);
        rootNode.setLeft(root_left);
        rootNode.setRight(root_right);
    }

    @Test
    public void search_right() {
        System.out.println(15 + " is at " + bstConstruction.search(rootNode, 15) + " position");
    }

    @Test
    public void search_left() {
        System.out.println(3 + " is at " + bstConstruction.search(rootNode, 3) + " position");
    }

    @Test
    public void search_rootNode() {
        System.out.println(10 + " is at " + bstConstruction.search(rootNode, 10) + " position");
    }

    @Test
    public void search_notFound() {
        System.out.println(1000 + " is at " + bstConstruction.search(rootNode, 1000) + " position");
    }

    @Test
    public void insert() {
        System.out.println(bstConstruction.insert(rootNode, 100).toString());
    }

    @Test
    public void delete() {
        bstConstruction.delete(rootNode, 10);
    }
}