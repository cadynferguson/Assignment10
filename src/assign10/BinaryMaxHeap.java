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
        array = (E[]) new Comparable[10];
    }

    public BinaryMaxHeap(Comparator<? super E> cmp) {
        elementCount = 0;
        array = (E[]) new Comparable[10];
        this.cmp = cmp;
    }

    //THIS IS NOT DONE
    public BinaryMaxHeap(List<? extends E> list) {
        elementCount = 0;
        array = (E[]) new Comparable[10];

        elementCount = list.size();
        buildHeap(list);

    }

    public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
        this.cmp = cmp;
        array = (E[]) new Comparable[10];

        elementCount = list.size();
        buildHeap(list);
        for(E item : array)
            System.out.println(item);

    }

    private void buildHeap(List<? extends E> items) {
        for(int i = 0; i < items.size(); i++) {
            array[i] = items.get(i);
        }

        for(int i = (items.size() - 1)/ 2; i >= 0; i--) {
            percolateDown(i);
        }
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
            E[] tmpArray = (E[]) new Comparable[array.length*2];
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
        int childIndexLeft = (2 * currentIndex) + 1;
        int childIndexRight = (2 * currentIndex) + 2;
        int largest = currentIndex;
        if(childIndexLeft < elementCount && cmp.compare(array[childIndexLeft], array[largest]) > 0)
            largest = childIndexLeft;
        if(childIndexRight < elementCount && cmp.compare(array[childIndexRight], array[largest]) > 0)
            largest = childIndexRight;

        if(largest != currentIndex) {
            swap(currentIndex, largest);
            percolateDown(largest);
        }
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
        return elementCount;
    }

    @Override
    public boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public void clear() {
        array = (E[]) new Comparable[10];
    }

    @Override
    public Comparable[] toArray() {
        E[] returnArray = (E[]) new Comparable[elementCount];
        for(int i = 0; i < elementCount; i++) {
            returnArray[i] = array[i];
        }

        return returnArray;
    }
}
