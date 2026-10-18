package ca.mcgill.ecse250.chapter23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;

/**
 * CHAPTER 23: SORTING
 */
public class Chapter23  {

    public static void main(String[] args) {
        exercise_23_13();
    }

    static void exercise_23_01() {

    }
    public static <E extends Comparable<E>> void bubbleSortComparable(E[] list){
        boolean swapped = false;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static <E> void bubbleSortComparator(E[] list, Comparator<? super E> comparator){
        boolean swapped = false;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i - 1; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    static void exercise_23_02() {

    }
    public static <E extends Comparable<E>> void mergeSortComparable(E[] list) {
        if (list.length > 1) {
            E[] firstHalf = (E[]) (new Comparable[list.length / 2]);
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSortComparable(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) (new Comparable[secondHalfLength]);
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSortComparable(secondHalf);

            mergeComparable(firstHalf, secondHalf, list);
        }

    }
    public static <E extends Comparable<E>> void mergeComparable(E[] list1, E[] list2, E[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static <E> void mergeSortComparator(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            E[] firstHalf = (E[]) (new Object[list.length / 2]);
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSortComparator(firstHalf, comparator);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) (new Object[secondHalfLength]);
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSortComparator(secondHalf, comparator);

            mergeComparator(firstHalf, secondHalf, list, comparator);
        }

    }
    public static <E> void mergeComparator(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if ( comparator.compare(list1[current1], list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }


    static void exercise_23_03() {

    }
    public static <E extends Comparable<E>> void quickSortComparable(E[] list) {
        quickSortComparable(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSortComparable(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partitionComparable(list, first, last);
            quickSortComparable(list, first, pivotIndex - 1);
            quickSortComparable(list, pivotIndex + 1, last);
        }
    }

    /** Partition the array list[first..last] */
    public static <E extends Comparable<E>> int partitionComparable(E[] list, int first, int last) {
        E pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && (list[low].compareTo(pivot) <= 0)) {
                low++;
            }

            // Search backward from right
            while (low <= high && (list[high].compareTo(pivot) > 0)) {
                high--;
            }

            // Swap two elements in the list
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && (list[high].compareTo(pivot) >= 0)) {
            high--;
        }

        // Swap pivot with list[high]
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
    public static <E> void quickSortRevised(E[] list, Comparator<? super E> comparator) {
        quickSortComparator(list, 0, list.length - 1, comparator);
    }

    public static <E> void quickSortComparator(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partitionComparator(list, first, last, comparator);
            quickSortComparator(list, first, pivotIndex - 1, comparator);
            quickSortComparator(list, pivotIndex + 1, last, comparator);
        }
    }

    /** Partition the array list[first..last] */
    public static <E> int partitionComparator(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && comparator.compare(list[low], pivot) <= 0) {
                low++;
            }

            // Search backward from right
            while (low <= high && comparator.compare(list[high], pivot) > 0) {
                high--;
            }

            // Swap two elements in the list
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(list[high], pivot) >= 0) {
            high--;
        }

        // Swap pivot with list[high]
        if (comparator.compare(pivot, list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
    static void exercise_23_04() {

    }
    public static void quickSortRevised(int[] list) {
        quickSortRevised(list, 0, list.length - 1);
    }

    public static void quickSortRevised(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partitionRevised(list, first, last);
            quickSortRevised(list, first, pivotIndex - 1);
            quickSortRevised(list, pivotIndex + 1, last);
        }
    }

    /** Partition the array list[first..last] */
    public static int partitionRevised(int[] list, int first, int last) {
        int pivot = getMedian(list[first], list[first + (last - first) / 2], list[last]); // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot) {
                low++;
            }

            // Search backward from right
            while (low <= high && list[high] > pivot) {
                high--;
            }

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot) {
            high--;
        }

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    private static int getMedian(int a, int b, int c) {
        int median;
        if ((a > b && a < c) || (a > c && a < b)) {
            median = a;
        } else if ((b > a && b < c) || (b < a && b > c)) {
            median = b;
        } else {
            median = c;
        }
        return median;
    }

    static void exercise_23_05() {

    }
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        HeapComparable<E> heap = new HeapComparable<>();
        // compare two children swap with the larger child create a Heap 880 Chapter 23 Sorting
        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
    public static <E> void heapSort(E[] list, Comparator< ? super E> comparator) {
        // Create a Heap of integers
        HeapComparator<E> heapComparator = new HeapComparator<>(comparator);
        // compare two children swap with the larger child create a Heap 880 Chapter 23 Sorting
        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heapComparator.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heapComparator.remove();
    }
    static void exercise_23_08() {

    }
    public static <E extends Comparable<E>> void sort(E[] list){
        heapSort(list);
    }

    // Do not do heap sort or radix sort
    private static final byte NUMBER_OF_ITERATIONS = 6;
    private static final int SIZE_JUMPS = 50000;
    static void exercise_23_13() {
        System.out.println("Array Size || Selection Sort | BubbleSort | MergeSort | QuickSort");
        System.out.println("__________________________________________________________________");

        for (int i = 1; i <= NUMBER_OF_ITERATIONS; i++){
            int arraySize = SIZE_JUMPS * i;
            //Build random Array
            Integer[] array = new Integer[arraySize];
            for (int j = 0; j < arraySize; j++){
                array[j] = new Random().nextInt(Integer.MIN_VALUE,Integer.MAX_VALUE);
            }
            long executionTimeSelectionSort;
            {
                Integer[] cleanTestArray = Arrays.copyOf(array, arraySize);
                long startTime = System.currentTimeMillis();
                selectionSort(cleanTestArray);
                long endTime = System.currentTimeMillis();
                executionTimeSelectionSort = endTime - startTime;
            }

            long executionTimeBubbleSort;
            {
                Integer[] cleanTestArray = Arrays.copyOf(array, arraySize);
                long startTime = System.currentTimeMillis();
                bubbleSortComparable(cleanTestArray);
                long endTime = System.currentTimeMillis();
                executionTimeBubbleSort = endTime - startTime;
            }

            long executionTimeMergeSort;
            {
                Integer[] cleanTestArray = Arrays.copyOf(array, arraySize);
                long startTime = System.currentTimeMillis();
                mergeSortComparable(cleanTestArray);
                long endTime = System.currentTimeMillis();
                executionTimeMergeSort = endTime - startTime;
            }

            long executionTimeQuickSort;
            {
                Integer[] cleanTestArray = Arrays.copyOf(array, arraySize);
                long startTime = System.currentTimeMillis();
                quickSortComparable(cleanTestArray);
                long endTime = System.currentTimeMillis();
                executionTimeQuickSort = endTime - startTime;
            }
            System.out.printf( "%-11d|| %-15d| %-11d| %-10d| %d%n", arraySize, executionTimeSelectionSort, executionTimeBubbleSort, executionTimeMergeSort, executionTimeQuickSort);
        }
        /* an example of one of my outputs:

        Array Size || Selection Sort | BubbleSort | MergeSort | QuickSort
        __________________________________________________________________
        50000      || 2436           | 9085       | 35        | 19
        100000     || 9918           | 40639      | 73        | 36
        150000     || 19086          | 73945      | 85        | 62
        200000     || 60094          | 131022     | 60        | 62
        250000     || 44048          | 150639     | 64        | 36
        300000     || 52191          | 209894     | 95        | 48

        */
    }

    private static <E extends Comparable<E> >void selectionSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            E min = list[i];
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(min) < 0) {
                    min = list[j];
                    minIndex = j;
                }
            }

            list[minIndex] = list[i];
            list[i] = min;
        }
    }


}
