package ca.mcgill.ecse250.chapter24;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list

    /** Create a default list */
    protected MyAbstractList() {
    }

    /** Create a list from an array of objects */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override /** Add a new element at the end of this list */
    public void add(E e) {
        add(size, e);
    }

    @Override /** Return true if this list doesn't contain any elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override /** Return the number of elements in this list */
    public int size() {
        return size;
    }
    @Override
    public boolean addAll(MyList<E> otherList) {
        if (otherList.isEmpty()) {
            return false;
        }
        for (E e : otherList){
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(MyList<E> otherList) {
        boolean hasBeenModified = false;
        for (E e : otherList){
            if(remove(e)){
                hasBeenModified = true;
            }
        }
        return hasBeenModified;
    }

    @Override
    public boolean retainAll(MyList<E> otherList) {
        boolean hasBeenModified = false;
        for (E e : this){
            if(!otherList.contains(e)){
                remove(e); // always true since e is in this
                hasBeenModified = true;
            }
        }
        return hasBeenModified;
    }

    @Override /** Remove the first occurrence of the element e
     * from this list. Shift any subsequent elements to the left.
     * Return true if the element is removed. */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }
}