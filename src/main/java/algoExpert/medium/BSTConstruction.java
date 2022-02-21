package algoExpert.medium;

import algoExpert.utils.BinaryTree;

/**
 * @author alireza_bayat
 * created on 2/21/22
 */
public class BSTConstruction {

    public String search(BinaryTree<Integer> rootNode, int targetValue) {
        return search(rootNode, targetValue, "rootNode");
    }

    //equality will be ignored in this case
    public BinaryTree<Integer> insert(BinaryTree<Integer> rootNode, int targetValue) {
        insert(rootNode, targetValue, rootNode);
        return rootNode;
    }

    public BinaryTree<Integer> delete(BinaryTree<Integer> rootNode, int targetValue) {

        return rootNode;
    }

    private String search(BinaryTree<Integer> rootNode, int target, String caption) {
        if (rootNode == null)
            return "not found";
        else if (rootNode.getValue() > target)
            return search(rootNode.getLeft(), target, caption + ",LEFT");
        else if (rootNode.getValue() < target)
            return search(rootNode.getRight(), target, caption + ",RIGHT");
        else if (rootNode.getValue() == target)
            return caption;
        else return "not found";
    }

    private void insert(BinaryTree<Integer> rootNode, int targetValue, BinaryTree<Integer> parentNode) {
        if (rootNode == null) {
            if (parentNode.getValue() > targetValue)
                parentNode.setLeft(new BinaryTree<>(targetValue));
            else if (parentNode.getValue() < targetValue)
                parentNode.setRight(new BinaryTree<>(targetValue));

        } else if (rootNode.getValue() > targetValue)
            insert(rootNode.getLeft(), targetValue, rootNode);
        else if (rootNode.getValue() < targetValue)
            insert(rootNode.getRight(), targetValue, rootNode);
    }

}
