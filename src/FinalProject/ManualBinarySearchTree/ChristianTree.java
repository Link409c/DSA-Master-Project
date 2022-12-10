package FinalProject.ManualBinarySearchTree;

import java.util.Queue;

/**
 * Christian Tree is an interface designed for the programmer to manually implement a Binary Tree or
 * a Binary Search Tree. The programmer's Tree Class should contain a nested Node class to encapsulate
 * data, or one may be imported. Nodes using generics should have a data variable E, and references to
 * the left and right child nodes.
 * @param <E> the data encapsulated by the Tree's Nodes.
 */
public interface ChristianTree<E extends Comparable<E>> {

    /**
     * Inserts a new node containing the passed data in the correct position in the tree. This method is
     * the starter method, which if not inserting the node into an empty tree, will use recursion to move
     * through the tree, passing each node progressed to as the root of a new BST.
     * @param data the data to store in the node.
     */
    void insert(E data);

    /**
     * Recursively inserts each node past the highest root node into the Tree. Used for any tree that is
     * not empty. Using the compare method, each node's data variable is weighed against the passed data and moves
     * through the tree according to its value. If lower, it moves through the left subtree. If higher, it moves
     * through the right subtree. Because each node is the root of its own Binary Search Tree, recursive calls to the
     * method will execute as long as the root has children or until the correct position is reached.
     * @param data the data to be inserted
     * @param node the root of the next subtree to be traversed.
     */
    void insert(E data, BinarySearchTree.Node<E> node);

    /**
     * Removes a node from the tree containing the passed data. This method is the starter method, which will
     * recursively call one of the other two delete methods based on input, passing each node progressed to as
     * the root of a new BST.
     * @param data the data to search the tree for.
     * @return returns the removed Node if found, or null if not.
     */
    BinarySearchTree.Node<E> remove(E data);

    /**
     * Remove is used to remove a node from the tree. Three cases can occur: the node to be removed is
     * a leaf; the node to be removed has one child; the node to be removed has 2 children. Each case has a
     * separate operation in order to keep the tree correctly sorted after removing the target node. The method
     * will return a node with each recursive call until a null value is reached, which the node to be removed
     * is set as.
     * @param data the data to search for and delete its node.
     * @return returns the Node object for recursion.
     */
    BinarySearchTree.Node<E> remove(E data, BinarySearchTree.Node<E> node);

    /**
     * traverse Tree is the initial method call used to traverse the BST. within this method, helper
     * methods will be used for the different traversal types (inOrder, preOrder, postOrder, depthFirst,
     * breadthFirst).
     * @param choice the input to determine which traversal method to use.
     */
    void traverseTree(int choice);

    /**
     * in Order Traversal visits nodes of a tree in the Left - Root - Right order. In a properly sorted BST this
     * should produce elements which are sorted in order as the method name describes.
     */
    void inOrderTraversal(BinarySearchTree.Node<E> root);

    /**
     * pre Order Traversal visits nodes of a tree in the Root - Left - Right order and displays the data.
     */
    void preOrderTraversal(BinarySearchTree.Node<E> root);

    /**
     * post Order Traversal visits nodes of a tree in the Left - Right - Root order and displays the data.
     */
    void postOrderTraversal(BinarySearchTree.Node<E> root);

    /**
     * depth First Traversal visits each node of a tree ordered by their subtrees. The method will traverse all
     * nodes of each subtree in the Binary Tree until it reaches a leaf. Then, it will backtrack to the previous node
     * and continue on the remaining subtree whose root is that node's opposite child (if it exists). This process will
     * repeat until all of the leaves of the tree have been visited.
     */
    void depthFirstTraversal(BinarySearchTree.Node<E> root);

    /**
     * breadth First Traversal visits each node of a tree ordered by their level. The method, starting at the root,
     * will add all nodes in that level of the tree to a queue before returning the root's data, and then repeating
     * this process for each child of the root.
     */

    void breadthFirstTraversal(BinarySearchTree.Node<E> root);

    /**
     * search Tree is the initial method call used to search the Binary Tree for a value. This method
     * recursively calls either the BFS or DFS depending on user input.
     * @param target the value to search the tree for.
     * @param choice the user input.
     * @return returns true if value is found, false if not.
     */
    boolean searchTree(E target, int choice);
    /**
     * breadth First Search uses the same traversal order as the BFT method in order to find a value in the
     * Binary Tree.
     * @param root the node to start searching at.
     * @param target the value to search for.
     * @return returns true if the value was found, false if not.
     */
    boolean depthFirstSearch(BinarySearchTree.Node<E> root, E target);

    /**
     * depth First Search uses the same traversal order as the DFT method in order to find a value in the
     * Binary Tree.
     * @param root the node to start searching at.
     * @param target the value to search for.
     * @return returns true if the value was found, false if not.
     */
    boolean breadthFirstSearch(BinarySearchTree.Node<E> root, E target);

    /**
     * calculate Height method finds the height of the tree by traversing through its subtrees. Each subtree is
     * visited starting at the root until a leaf is found. The heights of each branch of the tree are then
     * compared and the largest one is returned. This is the starter method for recursive calls for traversal.
     * @return returns the height of the tree.
     */
    int calculateHeight();

    /**
     * recursive calculate height method traverses each branch of a binary tree to determine height.
     * @param node the node acting as the root for this recursive call.
     * @return returns 0 if the node is null; otherwise returns the result of traversal through each
     *         largest sub tree.
     */
    int calculateHeight(BinarySearchTree.Node<E> node);

    /**
     * get Max finds the largest node in the Tree as specified by the comparator.
     * @param root the root of the BST.
     * @return returns the largest data value in the tree.
     */
    E getMax(BinarySearchTree.Node<E> root);

    /**
     * get Min finds the smallest node in the Tree as specified by the comparator.
     * @param root the root of the BST.
     * @return returns the smallest data value in the tree.
     */
    E getMin(BinarySearchTree.Node<E> root);

    /**
     * is Empty determines whether or not the Tree is empty (has no nodes).
     * @return returns true if the root is null; false otherwise.
     */
    boolean isEmpty();
}
