package timing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayListGenerator {
    public static ArrayList<Integer> generateNearlyAscendingArray(int problemSize) {
        ArrayList<Integer> array = generateAscendingArray(problemSize);
        slightlyShuffleArray(array);
        return array;
    }
    /**
     * Generates an ArrayList of problemSize random integers in nearly ascending order, with each element unique.
     *
     * @implNote calls generateAscendingArrayListWithoutDuplicates and then swaps a small number of random pairs of nearby elements
     * @param problemSize - size of the list
     */
    public static ArrayList<Integer> generateNearlyAscendingArrayListWithoutDuplicates(int problemSize) {
        ArrayList<Integer> list = generateAscendingArrayListWithoutDuplicates(problemSize);
        Random random = new Random();
        int swaps = Math.max(1, problemSize / 1000);
        for (int i = 0; i < swaps; i++) {
            int idx1 = random.nextInt(problemSize);
            int idx2 = random.nextInt(problemSize);
            Collections.swap(list, idx1, idx2);
        }

        return list;
    }

    /**
     * Generates an ArrayList of problemSize random integers in a permuted order, with each element unique.
     *
     * @implNote calls generateAscendingArrayListWithoutDuplicates and then shuffles the contents of the list
     * @param problemSize - size of the list
     */
    public static ArrayList<Integer> generatePermutedArrayListWithoutDuplicates(int problemSize) {
        ArrayList<Integer> list = generateAscendingArrayListWithoutDuplicates(problemSize);
        Collections.shuffle(list);
        return list;
    }

    /**
     * Generates an ArrayList of problemSize random integers in ascending order, with each element unique.
     *
     * @param problemSize - size of the list
     */
    private static ArrayList<Integer> generateAscendingArrayListWithoutDuplicates(int problemSize) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rng = new Random();
        int currentElement = rng.nextInt(20);
        for(int i = 0; i < problemSize; i++) {
            list.add(currentElement);
            currentElement += rng.nextInt(1, 10);
        }
        return list;
    }
    private static void slightlyShuffleArray(ArrayList<Integer> array) {
        // Choose a random number of pairs to swap, between 5 and 19
        Random rng = new Random();
        int swapCount = 5 + rng.nextInt(15);
        for(int i = 0; i < swapCount; i++) {
            // Choose a random index, excluding the final 11 indices
            int idx1 = rng.nextInt(array.size() - 11);
            // Choose an index between 1 and 10 to the right of idx1
            int idx2 = idx1 + 1 + rng.nextInt(10);
            // Swap the entries at those two indices
            swapArrayElements(array, idx1, idx2);
        }
    }
    private static void swapArrayElements(ArrayList<Integer> array, int idx1, int idx2) {
        int tmp = array.get(idx1);
        array.set(idx1, array.get(idx2));
        array.set(idx2, tmp);
    }
    public static ArrayList<Integer> generateDescendingArray(int problemSize) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = problemSize; i > 0; i--) {
            array.add(i);
        }
        return array;
    }
    public static ArrayList<Integer> generatePermutedArray(int problemSize) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < problemSize; i++) {
            array.add((int)(Math.random() * 100000));
        }
        return array;
    }
    public static ArrayList<Integer> generateAscendingArray(int problemSize) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < problemSize; i++) {
            array.add(i);
        }
        return array;
    }

    public static ArrayList<Integer> generateDescendingArrayList(int problemSize) {
        ArrayList<Integer> array = new ArrayList<>(problemSize);
        for(int i = problemSize - 1; i >= 0; i--) {
            array.set(i, i);
        }
        return array;
    }
    private static void swapArrayListElements(ArrayList<Integer> array, int idx1, int idx2) {
        int tmp = array.get(idx1);
        array.set(idx1, array.get(idx2));
        array.set(idx2, tmp);
    }
    /**
     * Generates an ArrayList of problemSize random integers in a descending, delta-sorted order.
     *
     * @implNote calls generateDescendingArray and then shuffles sub-lists of size delta + 1.
     * @param problemSize - size of the list
     * @param delta - parameter for delta sorting
     */
    public static ArrayList<Integer> generateDescendingDeltaSortedArrayList(int problemSize, int delta) {
        ArrayList<Integer> list = generateDescendingArray(problemSize);
        Random rng = new Random();
        for(int start = 0; start < problemSize; start += delta + 1) {
            int end = Math.min(start + delta + 1, problemSize);
            for(int i = start; i < end; i++)
                swapArrayListElements(list, i, rng.nextInt(start, end));
        }
        return list;
    }

}
