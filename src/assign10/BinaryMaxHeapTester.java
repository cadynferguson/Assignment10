package assign10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryMaxHeapTester {
    BinaryMaxHeap<Integer> intBMH;
    ArrayList<Integer> values;
    BinaryMaxHeap<Integer> reverseBMH;

    @BeforeEach
    void setup() {
        values = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            values.add(i);
        }
        intBMH = new BinaryMaxHeap<>(values, Comparator.naturalOrder());
        reverseBMH = new BinaryMaxHeap<>(values, Comparator.reverseOrder());

    }
    @Test
    void testAdd() {
        intBMH.add(11);
        assertEquals(intBMH.extractMax(), 11);
        assertEquals(intBMH.extractMax(), 9);
        assertEquals(intBMH.extractMax(), 8);
        assertEquals(intBMH.extractMax(), 7);
    }
    @Test
    void testReverseAdd() {
        reverseBMH.add(-1);
        assertEquals(reverseBMH.extractMax(), -1);
        assertEquals(reverseBMH.extractMax(), 0);
        assertEquals(reverseBMH.extractMax(), 1);
        assertEquals(reverseBMH.extractMax(), 2);
    }
    @Test
    void testPeek() {
        assertEquals(intBMH.peek(), 9);
        assertEquals(reverseBMH.peek(), 0);
    }
    @Test
    void testClear() {
        intBMH.clear();
        assertEquals(intBMH.size(), 0);
        assertEquals(intBMH.isEmpty(), true);
    }
    @Test
    void testIsEmpty() {
        assertEquals(intBMH.isEmpty(), false);
        intBMH.clear();
        assertEquals(intBMH.isEmpty(), true);
    }
    @Test
    void testAddIncreasesSize() {
        intBMH.add(11);
        assertEquals(intBMH.size(), 11);
        reverseBMH.add(-1);
        assertEquals(reverseBMH.size(), 11);
    }
    @Test
    void testExtractDecreasesSize() {
        intBMH.extractMax();
        assertEquals(intBMH.size(), 9);
        reverseBMH.extractMax();
        assertEquals(reverseBMH.size(), 9);
    }
    @Test
    void testExtractMaxThrows() {
        assertThrows(NoSuchElementException.class, () -> {
            BinaryMaxHeap<Integer> emptyBMH = new BinaryMaxHeap<>(new ArrayList<Integer>(), Comparator.naturalOrder());
            emptyBMH.extractMax();
        });
    }
    @Test
    void testPeekThrows() {
        assertThrows(NoSuchElementException.class, () -> {
            BinaryMaxHeap<Integer> emptyBMH = new BinaryMaxHeap<>(new ArrayList<Integer>(), Comparator.naturalOrder());
            emptyBMH.peek();
        });
    }
    @Test
    void testAddingDuplicates() {
        intBMH.add(9);
        assertEquals(intBMH.extractMax(), 9);
        assertEquals(intBMH.extractMax(), 9);
        assertEquals(intBMH.extractMax(), 8);
        assertEquals(intBMH.extractMax(), 7);
    }
    @Test
    void testDoublingWorks() {
        BinaryMaxHeap<Integer> ints = new BinaryMaxHeap<>(new ArrayList<>(List.of(1,3,5,2,7,4)), Comparator.naturalOrder());
        for(int i = 0; i < 100; i++) {
            ints.add(i);
        }
        assertEquals(ints.size(), 106);
        assertEquals(ints.extractMax(), 99);
    }
    @Test
    void testToArrayNormal() {
        Object[] arr = intBMH.toArray();
        for(int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], 9-i);
        }
    }

    @Test
    void testSize() {
        assertEquals(intBMH.size(), 10);
        assertEquals(reverseBMH.size(), 10);
    }

    @Test
    void testBuildHeapConstructor() {
        BinaryMaxHeap<Integer> ints = new BinaryMaxHeap<>(new ArrayList<>(List.of(1,3,5,2,7,4)), Comparator.naturalOrder());


        assertEquals(ints.extractMax(), 7);
        assertEquals(ints.extractMax(), 5);
        assertEquals(ints.extractMax(), 4);
        assertEquals(ints.extractMax(), 3);
    }

}
