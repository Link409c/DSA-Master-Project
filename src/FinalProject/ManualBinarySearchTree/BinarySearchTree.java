package FinalProject.ManualBinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements ChristianTree<E>{

    /**
     * Node subclass allows for generic implementation of the BST. Each Node holds data
     * and has a left and right reference similar to the linked list. However, in this
     * implementation they are considered "children" of the "parent" root node. The
     * comparable interface allows the tree to be sorted based on the values of its data
     * variables.
     * @param <E> the data encapsulated in the Node Object.
     */
    public static class Node<E extends Comparable<E>>{
        private E data;

        private Node<E> left;

        private Node<E> right;

        /**
         * Checks whether this node is a leaf.
         * @return returns true if both children are null, false if not.
         */
        public boolean isLeaf(){
            return (getLeft() == null && getRight() == null);
        }

        //getters and setters

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node(){}

        public Node(E data){
            this.data = data;
            this.left = this.right = null;
        }

    }

    @Override
    public void insert(E data) {
        //if tree is empty, insert the node at the root
        if(isEmpty()){
            Node<E> toInsert = new Node<>(data);
            setRoot(toInsert);
        }
        //else, recursively call insert
        /* passing the root node to the recursive call will step one level down the tree
         * each time the method executes */
        else{
            insert(data, getRoot());
        }
    }
    @Override
    public void insert(E data, Node<E> node) throws DataDuplicateException {
        /* This is the step I missed on the Final. Instead of just checking the left and right
         * children of the passed root node, I also needed to compare each node's data to move
         * in the correct direction down the tree. Without this comparison, the node is only
         * inserted at the first non-balanced level of the tree.
         */
        //if data is weighted higher, go right
        if (data.compareTo(node.getData()) > 0) {
            //if the right child is null, insert node here
            if(node.getRight() == null){
                Node<E> toInsert = new Node<>(data);
                node.setRight(toInsert);
            }
            else {
                //else continue recursion in the right subtree
                insert(data, node.getRight());
            }
        }
        //else if data is weighted lower, go left
        else if(data.compareTo(node.getData()) < 0) {
            //if left child is null, insert node here
            if(node.getLeft() == null) {
                Node<E> toInsert = new Node<>(data);
                node.setLeft(toInsert);
            }
            else {
                //else continue recursion in the left subtree
                insert(data, node.getLeft());
            }
        }
        //else if data comparison is equal,
        else if(data.compareTo(node.getData()) == 0){
            //do not insert the data, as the BST should only contain one instance of the data
            throw new DataDuplicateException();
        }
    }

    @Override
    public Node<E> remove(E data) {
        if(!isEmpty()){
            return remove(data, getRoot());
        }
        else{
            return null;
        }
    }

    @Override
    public Node<E> remove(E data, Node<E> node) {
        //if root is null, return null
        if(node != null) {
            //compare data for traversals
            //if data is weighted higher, go right
            if (data.compareTo(node.getData()) > 0) {
                //recursively visit the right subtree
                node.setRight(remove(data, node.getRight()));
            }
            //else if data is weighted lower, go left
            else if(data.compareTo(node.getData()) < 0) {
                //recursively visit the left subtree
                node.setLeft(remove(data, node.getLeft()));
            }
            //if data is equal this is the node to remove
            else if(data.compareTo(node.getData()) == 0) {
                //if node is a leaf, simply remove it
                if (node.isLeaf()) {
                    return node;
                }
                //else if node has one child, set the parent node to the child node and remove the child
                else if (node.getLeft() == null) {
                    //if no left child, return right child
                    return node.getRight();
                }
                else if (node.getRight() == null) {
                    //vice versa for right child
                    return node.getLeft();
                }
                //else if node has 2 children,
                //find the highest value and set it as the node's data
                node.setData(getMax(node.getLeft()));
                //now remove the leaf that has that same value as in line 132
                node.setLeft(remove(node.getData(), node.getLeft()));
            }
        }else{
            //null value is used in setter calls to "delete" the appropriate node
            return null;
        }
        return node;
    }

    public boolean searchTree(E target, int choice){
        boolean found = false;
        switch(choice){
            case 1 -> {
                found = breadthFirstSearch(getRoot(), target);
            }
            case 2 -> {
                found = depthFirstSearch(getRoot(), target);
            }
        }
        return found;
    }

    @Override
    public boolean depthFirstSearch(Node<E> node, E target) {
        //if node is not null
        if(node != null) {
            //compare the root data to the target
            //if target is found return true
            if(target.compareTo(node.getData()) == 0){
                return true;
            }
            //else continue to its children
            if(!node.isLeaf()) {
                //if no right child go left
                if(node.getRight() == null) {
                    return depthFirstSearch(node.getLeft(), target);
                }
                else {
                    //else go right
                    return depthFirstSearch(node.getRight(), target);
                }
            }

        }
        return false;
    }

    @Override
    public boolean breadthFirstSearch(Node<E> node, E target) {
        //following the bft algorithm,
        Queue<Node<E>> treeQueue = new LinkedList<>();
        if(node != null) {
            //insert the root node into a queue
            treeQueue.add(node);
            //while the queue is not empty,
            while(!treeQueue.isEmpty()) {
                //remove a node from the queue and visit it.
                Node<E> polled = treeQueue.poll();
                //compare the target to this node's data
                //if equal, return true
                if(target.compareTo(polled.getData()) == 0){
                    return true;
                }
                //otherwise place references to its left and right subtrees in the queue
                if(polled.getLeft() != null) {
                    treeQueue.add(polled.getLeft());
                }
                if(polled.getRight() != null) {
                    treeQueue.add(polled.getRight());
                }
            }
        }
        return false;
    }

    @Override
    public void traverseTree(int choice) {
        switch(choice){
            case 1 -> {
                inOrderTraversal(getRoot());
            }
            case 2 -> {
                preOrderTraversal(getRoot());
            }
            case 3 -> {
                postOrderTraversal(getRoot());
            }
            case 4 -> {
                depthFirstTraversal(getRoot());
            }
            case 5 -> {
                breadthFirstTraversal(getRoot());
            }
        }
    }

    @Override
    public void inOrderTraversal(Node<E> node) {
        //if the node is not null
        if(node != null) {
            //recursively visit the left and right children
            //get the root data between recursive calls
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData());
            inOrderTraversal(node.getRight());
        }
    }

    @Override
    public void preOrderTraversal(Node<E> node) {
        //if the node is not null
        if(node != null) {
            //get the root data first
            //recursively visit the left and right children
            System.out.print(node.getData());
            inOrderTraversal(node.getLeft());
            inOrderTraversal(node.getRight());
        }
    }

    @Override
    public void postOrderTraversal(Node<E> node) {
        //if the node is not null
        if(node != null) {
            //recursively visit the left and right children
            //get the root data last
            inOrderTraversal(node.getLeft());
            inOrderTraversal(node.getRight());
            System.out.print(node.getData());
        }
    }

    @Override
    public void depthFirstTraversal(Node<E> node) {
        //if node is not null
        if(node != null) {
            //get the root data
            System.out.print(node.getData() + " ");
            //then get the data of its left child
            if(!node.isLeaf()) {
                //continue until a leaf is found
                depthFirstTraversal(node.getLeft());
                //repeat with the right children of the root until a leaf is found
                depthFirstTraversal(node.getRight());
            }
        }
    }

    @Override
    public void breadthFirstTraversal(Node<E> node) {
        //following the example algorithm given in the project doc,
        Queue<Node<E>> treeQueue = new LinkedList<>();
        if(node != null) {
            //insert the root node into a queue
            treeQueue.add(node);
            //while the queue is not empty,
            while(!treeQueue.isEmpty()) {
                //remove a node from the queue and visit it.
                Node<E> polled = treeQueue.poll();
                System.out.print(polled.getData() + " ");
                //place references to its left and right subtrees in the queue
                if(polled.getLeft() != null) {
                    treeQueue.add(polled.getLeft());
                }
                if(polled.getRight() != null) {
                    treeQueue.add(polled.getRight());
                }
            }
        }
    }

    @Override
    public int calculateHeight() {
        //no nodes, no height
        if (isEmpty()) {
            return 0;
        }
        //if only root, one level
        else if (getRoot().isLeaf()) {
            return 1;
        } else {
            //otherwise, traverse each subtree until a leaf is found
            //method return value updates height with each traversal
            return 1 + calculateHeight(getRoot());
        }
    }

    @Override
    public int calculateHeight(Node<E> node) {
        //if passed node is null, its parent is a leaf, and this is the end of the branch
        if(node == null){
            return 0;
        }
        //otherwise, recursively traverse the branches
        else{
            //old code 12/7/22
            /*
            //call the method on the left and right child
            //store the values in variables
            int leftBranch = calculateHeight(node.getLeft());
            int rightBranch = calculateHeight(node.getRight());
            //compare them to find the larger subtree
            if(leftBranch < rightBranch){
                //return the largest subtree
                return rightBranch;
            }
            else{
                return leftBranch;
            }
             */
            //new code 12/9/22
            return Math.max(calculateHeight(node.getLeft()), calculateHeight(node.getRight()));
        }
    }

    @Override
    public E getMax(Node<E> root) {
        //if tree is empty return null
        if(isEmpty()){
            return null;
        }
        //loop through each right node until reaching a leaf
        while(!root.getRight().isLeaf()){
            root = root.getRight();
        }
        //this is the largest value
        return root.getData();
    }

    @Override
    public E getMin(Node<E> root) {
        //if tree is empty return null
        if(isEmpty()){
            return null;
        }
        //loop through each left node until reaching a leaf
        while(!root.getLeft().isLeaf()){
            root = root.getLeft();
        }
        //this is the smallest value
        return root.getData();
    }

    @Override
    public boolean isEmpty() {
        return getRoot() == null;
    }

    private Node<E> root;

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }
}
