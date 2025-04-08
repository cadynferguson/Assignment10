package assign10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import timing.ArrayListGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeltaSorterTester {
    private ArrayList<Integer> smallIntArray;
    private int smallDelta;
    private ArrayList<Integer> mediumIntArray;
    private int mediumDelta;
    @BeforeEach
    void beforeEach() {

        smallDelta = 2;
        smallIntArray = ArrayListGenerator.generateDescendingDeltaSortedArrayList(10, smallDelta);

        mediumDelta = 10;
        mediumIntArray = ArrayListGenerator.generateDescendingDeltaSortedArrayList(100, mediumDelta);

    }

    @Test
    void sortTestSmall() {
        DeltaSorter.sort(smallIntArray, smallDelta);
        for (int i = 0; i< smallIntArray.size(); i++) {
            assertEquals(smallIntArray.size() - i, smallIntArray.get(i));
        }
    }

    @Test
    void sortTestMedium() {
        DeltaSorter.sort(mediumIntArray, mediumDelta);
        for (int i = 0; i< mediumIntArray.size(); i++) {
            assertEquals(mediumIntArray.size() - i, mediumIntArray.get(i));
        }
    }
}
