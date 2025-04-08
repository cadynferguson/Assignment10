package assign10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryMaxHeapTester {
    @Test
    void testBuildHeapConstructor() {
        BinaryMaxHeap<Integer> ints = new BinaryMaxHeap<>(new ArrayList<>(List.of(1,3,5,2,7,4)), Comparator.naturalOrder());


        assertEquals(ints.extractMax(), 7);
        assertEquals(ints.extractMax(), 5);
        assertEquals(ints.extractMax(), 4);
        assertEquals(ints.extractMax(), 3);

    }

}
