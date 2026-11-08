package ca.mcgill.ecse250.chapter24;

import ca.mcgill.ecse250.chapter06.Chapter06;

/**
 * CHAPTER 24: IMPLEMENTING LISTS, STACKS, AND QUEUES
 */
public class Chapter24 {

    public static void main(String[] args) {
    }

    static void exercise_24_01() {
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("Tom");
        list1.add("George");
        list1.add("Peter");
        list1.add("Jean");
        list1.add("Jane");
        MyArrayList<String> list2 = new MyArrayList<>();
        list1.add("Tom");
        list1.add("George");
        list1.add("Michael");
        list1.add("Michelle");
        list1.add("Daniel");
        list1.addAll(list2);
        System.out.println("List2: "+ list2);
        System.out.println("List1: "+ list1);
        list1.removeAll(list2);
        System.out.println("List2: "+ list2);
        System.out.println("List1: "+ list1);
        list1.retainAll(list2);
        System.out.println("List2: "+ list2);
        System.out.println("List1: "+ list1);
    }


    static void exercise_24_02() {
        MyLinkedList<Integer> e = new MyLinkedList<>();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(2);
        e.add(3);
        System.out.println("First element: " + e.get(0)); // should print 1
        System.out.println("index of 2: " + e.indexOf(2)); // should be 1
        System.out.println("Last index of 2: " + e.lastIndexOf(2)); // should be 3
        e.set(0, 4);
        System.out.println("First element: " + e.get(0)); // should be 4
        System.out.println("contains 1?: " + e.contains(1)); // should return false
    }

    static void exercise_24_03() {
        TwoWayLinkedList<String> list1 = new TwoWayLinkedList<>();
        list1.add("Tom");
        list1.add("George");
        list1.add("Peter");
        list1.add("Jean");
        list1.add("Jane");
        list1.add("Michael");
        list1.add("Michelle");
        list1.add("Daniel");
        java.util.ListIterator<String> it = list1.iterator();
        java.util.ListIterator<String> it2 = list1.listIterator(2);
        it2.add("new Node");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("_____________________________________");
        while (it2.hasPrevious()) {
            System.out.println(it2.previous());
        }

    }

    private final static byte NUMBER_OF_PRIMES = 50;
    static void exercise_24_04() {
        GenericStack<Integer> primeStack = new GenericStack<>();
        for (int i = 0; i < NUMBER_OF_PRIMES; i++) {
            if(Chapter06.isPrime(i)){
                primeStack.push(i);
            }
        }
        for (int i = 0; i < primeStack.getSize(); i++) {
            System.out.println(primeStack.pop());
        }
    }
}
