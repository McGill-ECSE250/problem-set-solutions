package ca.mcgill.ecse250.chapter24;

import java.util.ListIterator;
import java.util.NoSuchElementException;

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
        if (size == 0) {
            head = newNode;
        } else {
            newNode.next = head; // link the new node with the head
            head.previous = newNode;
            head = newNode; // head points to the new node
        }

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
            newNode.previous = tail;
            tail = tail.next; // tail now points to the last node
        }

        size++; // Increase size
    }

    @Override
    public boolean add(E e){
        addLast(e);
        return true;
    }
    @Override /** Add a new element at the specified index
     * in this list. The index of the head element is 0 */
    public void add(int index, E e) {
        validateCursorPosition(index);
        if (index == 0) {
            addFirst(e); // Insert first
        } else if (index == size){
            addLast(e); // Insert last
        } else { // Insert in the middle
            Node<E> current = getNode(index);
            Node<E> temp = current.previous;
            current.previous = new Node<E>(e);
            current.previous.next = current;
            (current.previous).previous = temp;
            temp.next = current.previous;
            size++;
        }
    }

    private void validateIndex(int index) {
        if (!isIndexInBound(index)) {
            throw new IndexOutOfBoundsException();
        }
    }
    private void validateCursorPosition(int pos){
        if (!isCursorInBound(pos)) throw new IndexOutOfBoundsException();
    }

    private boolean isCursorInBound(int pos) {
        return pos >= 0 && pos <= size;
    }
    private boolean isIndexInBound(int index) {
        return index >= 0 && index < size;
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
            else head.previous = null;
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

            Node<E> temp = tail;
            tail = tail.previous;
            tail.next = null;
            temp.previous = null; // in case we for some reason have the removed tail referenced again
            size--;
            return temp.element;
        }
    }


    @Override /** Remove the element at the specified position in this
     * list. Return the element that was removed from the list. */
    public E remove(int index) {
        validateIndex(index);
        if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node<E> current = getNode(index);
            current.previous.next = current.next;
            current.next.previous = current.previous;

            //removing links just in case we reference it again somewhere
            current.previous = null;
            current.next = null;

            size--;
            return current.element;
        }
    }

    private Node<E> getNode(int index) {
        validateIndex(index);
        Node<E> current;
        if (size / 2 < index) {
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        } else {
            current = tail;
            for (int i = 0; i < (size - index - 1); i++)
                current = current.previous;
        }
        return current;
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
        return indexOf(e) != -1;
    }

    @Override /** Return the element at the specified index */
    public E get(int index) {
        Node<E> node = getNode(index);
        return node != null ? node.element : null;
    }

    @Override /** Return the index of the head matching element
     * in this list. Return -1 if no match. */
    public int indexOf(Object e) {
        ListIterator<E> it = iterator();
        int i = 0;
        while(it.hasNext()) {
            E element = it.next();
            if ((e == null && element == null) || element.equals(e)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override /** Return the index of the last matching element
     * in this list. Return -1 if no match. */
    public int lastIndexOf(Object e) {
        int i = size - 1;
        ListIterator<E> it = listIterator(size);
        int lastIndex = -1;
        while(it.hasPrevious()) {
            E element = it.previous();
            if ((e == null && element == null) || element.equals(e)) {
                lastIndex = i;
            }
            i--;

        }
        return lastIndex;
    }

    @Override /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
        Node<E> node = getNode(index);
        E replacedElement = node.element;
        node.element = e;
        return replacedElement;
    }

    @Override /** Override iterator() defined in Iterable */
    public java.util.ListIterator<E> iterator() {
        return new TwoWayLinkedListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return new TwoWayLinkedListIterator(index);
    }

    private class TwoWayLinkedListIterator implements java.util.ListIterator<E> {
        private Node<E> current = head; // Current index
        private Node<E> returned = null;
        private int index = 0;

        public TwoWayLinkedListIterator(){

        }

        public TwoWayLinkedListIterator(int index){
            validateCursorPosition(index);
            this.index = index;
            if (index == size) {
                current = null;
                return;
            }
            current = getNode(index);
        }
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException(); // According to java documentation of java.util.ListIterator<E>.next()
            E e = current.element;
            returned = current;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return (index > 0);
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException(); // According to java documentation of java.util.ListIterator<E>.previous()

            if(current == null){
                current = tail;
            } else {
                current = current.previous;
            }
            returned = current;
            index--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            if(returned == null) throw new IllegalStateException();
            if (returned == current) {
                TwoWayLinkedList.this.remove(index);
            } else {
                TwoWayLinkedList.this.remove(index - 1);
                index--;
            }
            returned = null;
        }

        @Override
        public void set(E e) {
            if(returned == null) throw new IllegalStateException();
            returned.element = e;
        }

        @Override
        public void add(E e) {
            TwoWayLinkedList.this.add(index, e);
            returned = null;
            index++;
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
