import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> {
    Node<T> rootNode;
    public BinarySearchTree() {
        rootNode = null;
    }
    public void add(T value) {
        rootNode = add(value, rootNode);
    }
    private Node<T> add(T newValue, Node<T> node) {
        if (node == null)
            node = new Node<T>(newValue);
        else if (newValue.compareTo(node.value) >= 0)
            node.rightNode = add(newValue, node.rightNode);
        else
            node.leftNode = add(newValue, node.leftNode);
        return node;
    }
    private Node<T> find(T value, Node<T> node) {
        if (node == null)
            return node;
        int comparison = value.compareTo(node.value);
        if (comparison == 0)
            return node;
        return (comparison > 0) ? find(value, node.rightNode) : find(value, node.leftNode);
    }
    public Node<T> find(T value) {
        return find(value, rootNode);
    }
    class Node<T extends Comparable<T>> {
        T value;
        Node<T> leftNode, rightNode;
        public Node() {
            this(null);
        }
        public Node(T t) {
            value = t;
            leftNode = null;
            rightNode = null;
        }
    }
}