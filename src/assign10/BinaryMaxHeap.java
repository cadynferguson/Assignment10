package assign10;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.List;

public class BinaryMaxHeap<E extends Comparable<? super E>> implements PriorityQueue<E> {
    private E[] array;
    private int elementCount;
    private Comparator<? super E> cmp = Comparator.naturalOrder();

    public BinaryMaxHeap() {
        elementCount = 0;
        array = (E[]) new Object[10];
    }

    public BinaryMaxHeap(Comparator<? super E> cmp) {
        elementCount = 0;
        array = (E[]) new Object[10];
        this.cmp = cmp;
    }

    //THIS IS NOT DONE
    public BinaryMaxHeap(List<? extends E> list) {
        elementCount = 0;
        array = (E[]) new Object[10];
        for (E item : list) {
            add(item);
        }

    }

    public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
        elementCount = 0;
        this.cmp = cmp;
        array = (E[]) new Object[10];
    }

    private int parentIndex(int childIndex) {
        return (childIndex-1)/2;
    }

    private void swap(int index1, int index2) {
        E tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private void percolateUp(int currentIndex) {
        int parentIndex;
        while(currentIndex > 0) {
            parentIndex = parentIndex(currentIndex);
            if (cmp.compare(array[currentIndex], array[parentIndex]) > 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }
    }

    @Override
    public void add(E item) {
        if (elementCount+1 < array.length) {
            E[] tmpArray = (E[]) new Object[array.length*2];
            for (int i = 0; i < array.length; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
        }
        array[elementCount++] = item;
        percolateUp(elementCount-1);
    }

    @Override
    public E peek() throws NoSuchElementException {
        if (elementCount==0) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    private void percolateDown(int currentIndex) {
        int childIndexRight;
        int childIndexLeft;
        while ()
    }
    @Override
    public E extractMax() throws NoSuchElementException {
        if (elementCount==0) {
            throw new NoSuchElementException();
        }

        E returnVal = array[0];
        array[0] = array[elementCount-1];
        percolateDown(0);

        return returnVal;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
