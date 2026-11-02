package ca.mcgill.ecse250.chapter25;

import com.sun.source.tree.Tree;

import java.nio.file.Path;
import java.util.*;

public class BST<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected Comparator<? super E> comparator;
    /** Create a default binary search tree */
    public BST(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /** Create a binary search tree from an array of objects */
    public BST(E[] objects, Comparator<? super E> comparator) {
        this.comparator = comparator;
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    /** Return true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            if (comparator.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (comparator.compare(e, current.element) > 0) {
                current = current.right;
            }
            else // element matches current.element
                return true; // Element is found
        }

        return false;
    }

    /** Insert element e into the binary search tree.
     * Return true if the element is inserted successfully. */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (comparator.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (comparator.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (comparator.compare(e, parent.element) < 0) {
                parent.left = createNewNodeWithParent(e, parent);
            } else{
                parent.right = createNewNodeWithParent(e, parent);
            }

        }

        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    protected TreeNode<E> createNewNodeWithParent(E e, TreeNode<E> parent) {
        TreeNode<E> returnedNode = new TreeNode<>(e);
        returnedNode.parent = parent;
        return returnedNode;
    }

     /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

     /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

     /** Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /** This inner class is static, because it does not access
     any instance members defined in its outer class */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        protected TreeNode<E> parent;
        public TreeNode(E e) {
            element = e;
        }

        public int height() {
            if(this.left == null && this.right == null){
                return 0;
            } else if(this.left == null){
                return 1 + right.height();
            } else if(this.right == null){
                return 1 + left.height();
            }
            return Math.max(1 + this.left.height(), 1 + this.right.height());
        }

        public void breathFirstTraversal() {
            Queue<TreeNode<E>> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode<E> node = queue.poll();
                System.out.print(node.element + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }

        /** Returns the number of leaf nodes from this node*/
        public int getNumberOfLeaves() {
            if(this.left == null && this.right == null){
                return 1;
            } else if(this.left == null){
                return this.right.getNumberOfLeaves();
            } else if(this.right == null){
                return this.left.getNumberOfLeaves();
            }
            return this.right.getNumberOfLeaves() + this.left.getNumberOfLeaves();
        }
    }

     /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /** Returns the root of the tree */
    public TreeNode<E> getRoot() {
        return root;
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (comparator.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (comparator.compare(e, current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

     /**
      *  an element from the binary search tree.
     * Return true if the element is deleted successfully.
     * Return false if the element is not in the tree. */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (comparator.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (comparator.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else {
                if (comparator.compare(e, parent.element) < 0) {
                    parent.left = current.right;
                    parent.left.parent = parent;
                }
                else {
                    parent.right = current.right;
                    parent.right.parent = parent;
                }
            }
        }
        else {
            // Case 2: The current node has a left child.
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent.
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost){
                parentOfRightMost.right = rightMost.left;
                if (parentOfRightMost.right != null) {
                    parentOfRightMost.right.parent = parentOfRightMost;
                }
            }
            else {
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
                if (parentOfRightMost.left != null){
                    parentOfRightMost.left.parent = parentOfRightMost;
                }
            }
        }

        size--;
        return true; // Element deleted successfully
    }

     /** Obtain an iterator. Use inorder. */
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    /** Displays the nodes in a breadth-first traversal */
    public void breadthFirstTraversal(){
        root.breathFirstTraversal();
    }

    /** Returns true if the tree is a full binary tree */
    boolean isFullBST(){
        return getSize() == Math.pow(2, height() + 1) - 1;
    }
    /** Returns the number of leaf nodes */
    public int getNumberOfLeaves(){
        return root.getNumberOfLeaves();
    }
    @Override
    public BST<E> clone(){
        BST<E> returnedBST = new BST<>(comparator);
        TreeNode<E> current = root;
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            returnedBST.insert(current.element);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return returnedBST;
    }
    public boolean equals(BST<E> other){
        Queue<TreeNode<E>> queueThis = new LinkedList<>();
        Queue<TreeNode<E>> queueOther = new LinkedList<>();
        TreeNode<E> currentThis = root;
        TreeNode<E> currentOther = other.root;
        queueThis.add(currentThis);
        queueOther.add(currentOther);
        while (!queueThis.isEmpty() && !queueOther.isEmpty()) {
            currentThis = queueThis.poll();
            currentOther = queueOther.poll();
            if (!currentThis.element.equals(currentOther.element)) {
                return false;
            }
            if (currentThis.left != null) {
                queueThis.add(currentThis.left);
            }
            if (currentThis.right != null) {
                queueThis.add(currentThis.right);
            }
            if (currentOther.left != null) {
                queueOther.add(currentOther.left);
            }
            if (currentOther.right != null) {
                queueOther.add(currentOther.right);
            }
        }
        // if one is still non empty then they are not equal
        return queueThis.isEmpty() == queueOther.isEmpty();
    }
    /** Returns the number of nonleaf nodes */
    public int getNumberofNonLeaves(){
        return getSize() - root.getNumberOfLeaves();
    }
    /** Returns the height of this binary tree */
    public int height(){
        return root.height();
    }
    /** Returns the node for the specified element.
     * Returns null if the element is not in the tree. */
    public TreeNode<E> getNode(E element){
        TreeNode<E> current = root;
        while (current != null) {
            if (current.element.equals(element)) {
                return current;
            }
            else if (comparator.compare(element, current.element) < 0) {
                current = current.left;
            } else{
                current = current.right;
            }
        }
        return null;
    }
    /** Returns true if the node for the element is a leaf */
    public boolean isLeaf(E element){
        TreeNode<E> node = getNode(element);
        return node == null || (node.left == null && node.right == null);
    }
    /** Returns the path of elements from the specified element
     * to the root in an array list. */
    public ArrayList<E> getPath(E e){
        Stack<E> stack = new Stack<>();
        TreeNode<E> current = root;
        while (current != null) {
            stack.add(current.element);
            if (current.element.equals(e)) {
                break;
            } else if (comparator.compare(e, current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            return null;
        }
        ArrayList<E> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
        return path; // no element means no path found
    }
    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /** Inorder traversal from the root*/
        private void inorder() {
            inorder(root);
        }

        /** Inorder traversal from a subtree */
        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

         /** More elements for traversing? */
        public boolean hasNext() {
            if (current < list.size())
                return true;

            return false;
        }

         /** Get the current element and move to the next */
        public E next() {
            return list.get(current++);
        }

         /** Remove the current element */
        public void remove() {
            delete(list.get(current)); // Delete the current element
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    /** Remove all elements from the tree */
    public void clear() {
        root = null;
        size = 0;
    }
}

