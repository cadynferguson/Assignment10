package assign10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import timing.ArrayListGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeltaSorterTester {
    private ArrayList<Integer> smallIntArray;
    private int smallDelta;
    private ArrayList<Integer> mediumIntArray;
    private int mediumDelta;
    private ArrayList<Integer> smallIntArrayRev;

    private ArrayList<String> smallStringArray;


    @BeforeEach
    void beforeEach() {

        smallDelta = 2;
        smallIntArray = ArrayListGenerator.generateDescendingDeltaSortedArrayList(10, smallDelta);

        mediumDelta = 10;
        mediumIntArray = ArrayListGenerator.generateDescendingDeltaSortedArrayList(100, mediumDelta);

        smallStringArray = new ArrayList<>();
        for (int i = 0; i < smallIntArray.size(); i++) {
            smallStringArray.add(smallIntArray.get(i).toString());
        }


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

    @Test
    void sortCmpTestMedium() {
        Collections.reverse(mediumIntArray);
        DeltaSorter.sort(mediumIntArray, mediumDelta, (i1, i2) -> i2 - i1);
        for (int i = 0; i< mediumIntArray.size(); i++) {
            assertEquals(i + 1, mediumIntArray.get(i));
        }
    }

    @Test
    void sortCmpTestSmall() {
        Collections.reverse(smallIntArray);
        DeltaSorter.sort(smallIntArray, smallDelta, (i1, i2) -> i2 - i1);
        for (int i = 0; i< smallIntArray.size(); i++) {
            assertEquals(i + 1, smallIntArray.get(i));
        }
    }

    @Test
    void sortTestSmallString() {
        DeltaSorter.sort(smallStringArray, smallDelta);
        assertEquals("9", smallStringArray.get(0));
    }
}
