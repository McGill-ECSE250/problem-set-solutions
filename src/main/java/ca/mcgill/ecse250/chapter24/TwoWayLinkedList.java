package ca.mcgill.ecse250.chapter24;

import java.util.ListIterator;

public class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E> {
    private Node<E> head, tail;
    private int size;
    /** Create a default list */
    public TwoWayLinkedList() {
    }

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }

    @Override
    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node for e

        if (tail == null) {
            head = tail = newNode; // The only node in list
        }
        else {
            tail.next = newNode; // Link the new node with the last node
            tail = tail.next; // tail now points to the last node
        }

        size++; // Increase size
    }

    @Override /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e); // Insert first
        }
        else if (index >= size) addLast(e); // Insert last
        else { // Insert in the middle
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }

    /** Remove the head node and
     * return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) return null; // Nothing to delete
        else {
            Node<E> temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            size--; // Reduce size by 1
            if (head == null) tail = null; // List becomes empty
            return temp.element; // Return the deleted element
        }
    }


    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) return null; // Nothing to remove
        else if (size == 1) { // Only one element in the list
            Node<E> temp = head;
            head = tail = null; // list becomes empty
            size = 0;
            return temp.element;
        }
        else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }


    @Override /** Remove the element at the specified position in this
     * list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
     /** Return true if this list contains the element e */
    public boolean contains(Object e) {
        Node<E> tmp = head;
        do {
            if(tmp.element.equals(e)){
                return true;
            }
            tmp = tmp.next;
        } while(tmp.next != null);
        return false;
    }

    @Override /** Return the element at the specified index */
    public E get(int index) {
        var it = iterator();
        int i = 0;
        do {
            if (i == index) {
                return it.next();
            }
            i++;

        } while(it.hasNext());
        return null;
    }

    @Override /** Return the index of the head matching element
     * in this list. Return -1 if no match. */
    public int indexOf(Object e) {
        var it = iterator();
        int i = 0;
        do {
            if (it.next().equals(e)) {
                return i;
            }
            i++;

        } while(it.hasNext());
        return -1;
    }

    @Override /** Return the index of the last matching element
     * in this list. Return -1 if no match. */
    public int lastIndexOf(Object e) {
        var it = iterator();
        int lastIndex = -1;
        int i = 0;
        do {
            if (it.next().equals(e)) {
                lastIndex = i;
            }
            i++;

        } while(it.hasNext());
        return lastIndex;
    }

    @Override /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
        Node<E> tmp = head;
        int i = 0;
        do {
            if(i == index) {
                tmp.element = e;
            }
            tmp = tmp.next;
        } while(tmp.next != null);
        return e;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new TwoWayLinkedListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    private class TwoWayLinkedListIterator implements java.util.Iterator<E> {
        private Node<E> current = head; // Current index

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            var tmp = current.previous;
            current = current.next;
            current.previous = tmp;
            current.previous.next = current;
            size--;
        }
    }

    // This class is only used in LinkedList, so it is private.
    // This class does not need to access any
    // instance members of LinkedList, so it is defined static.
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;
        public Node(E element) {
            this.element = element;
        }
    }


}
