package ca.mcgill.ecse250.chapter25;

import java.util.Scanner;

/**
 * CHAPTER 25: BINARY SEARCH TREES
 */
public class Chapter25 {

    public static void main(String[] args) {
    }

    static void exercise_25_01() {
        BST<Integer> bst = getGenericTreeNonFullBST();
        bst.breadthFirstTraversal();
        System.out.println("height: " + bst.height());
    }

    static void exercise_25_03() {
        BST<Integer> notFull = getGenericTreeNonFullBST();
        System.out.println("should be false: " + notFull.isFullBST());
        BST<Integer> fullBST = getGenericTreeFullBST();
        System.out.println("should be true: " + fullBST.isFullBST());

    }

    private static BST<Integer> getGenericTreeNonFullBST() {
        BST<Integer> bst = new BST<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(5);
        bst.insert(30);
        bst.insert(2);
        bst.insert(4);
        bst.insert(25);
        bst.insert(35);
        return bst;
    }
    private static BST<Integer> getGenericTreeFullBST() {
        BST<Integer> bst = new BST<>(Integer::compareTo);
        bst.insert(10);
        bst.insert(5);
        bst.insert(30);
        bst.insert(2);
        bst.insert(6);
        bst.insert(25);
        bst.insert(35);
        return bst;
    }


    static void exercise_25_06() {
        BST<Integer> bst1 = getGenericTreeNonFullBST();
        System.out.println("Number of leaves in generic non full: " + bst1.getNumberOfLeaves());

        BST<Integer> bst2 = getGenericTreeFullBST();
        System.out.println("Number of leaves in generic full: " + bst2.getNumberOfLeaves());
    }

    static void exercise_25_07() {
        BST<Integer> bst1 = getGenericTreeNonFullBST();
        System.out.println("Number ofn nonleaf nodes in generic non full: " + bst1.getNumberofNonLeaves());

        BST<Integer> bst2 = getGenericTreeFullBST();
        System.out.println("Number of nonleaf nodes in generic full: " + bst2.getNumberofNonLeaves());
    }

    static void exercise_25_09() {
        {
            BST<Integer> bst1 = getGenericTreeNonFullBST();
            BST<Integer> bst2 = getGenericTreeFullBST();
            System.out.println("full vs non full bst:" + bst1.equals(bst2));
        }
        {
            BST<Integer> bst1 = getGenericTreeFullBST();
            BST<Integer> bst2 = getGenericTreeFullBST();
            System.out.println("full vs full bst:" + bst1.equals(bst2));
        }
        {
            BST<Integer> bst1 = getGenericTreeNonFullBST();
            BST<Integer> bst2 = getGenericTreeNonFullBST();
            System.out.println("non full vs non full bst:" + bst1.equals(bst2));
        }
        {
            BST<Integer> bst1 = getGenericTreeNonFullBST();
            BST<Integer> bst2 = bst1.clone();
            System.out.println("non full vs cloned non full bst:" + bst1.equals(bst2));
        }
        {
            BST<Integer> bst1 = getGenericTreeFullBST();
            BST<Integer> bst2 = bst1.clone();
            System.out.println("full vs cloned full bst:" + bst1.equals(bst2));
        }


    }

    static void exercise_25_14() {
        // modified the BTS file using find "e.compareTo(" and replace "comparator.compare(e, ", added new field Comparator<? super E> comparator and BST(Comparator<? super E> comparator) constructor
    }

    private static final byte NUM_OF_INTEGERS = 10;
    static void exercise_25_15() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter 10 integers:" );
        String[] numAsStringArr = inputScanner.nextLine().split(" ");
        BST<Integer> bst = new BST<>(Integer::compareTo);
        for (int i = 0; i < NUM_OF_INTEGERS; i++) {
            bst.insert(Integer.parseInt(numAsStringArr[i]));
        }
        bst.delete(Integer.parseInt(numAsStringArr[0]));
        // we start with 1 since we removed index 0 from tree, so it will always return null
        for (int i = 1; i < NUM_OF_INTEGERS; i++) {
            BST.TreeNode<Integer> node = bst.getNode(Integer.parseInt(numAsStringArr[i]));
            if(node != null && bst.isLeaf(node.element)){
                System.out.println(bst.getPath(node.element));
            }
        }

    }

}
