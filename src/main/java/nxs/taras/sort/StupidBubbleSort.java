package nxs.taras.sort;

public class StupidBubbleSort implements Sort {
    @Override
    public boolean doSortIteration(int[] array) {
        boolean isSorted = true;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j+1]) {
                isSorted = false;
                swapElements(array, j, j+1);
                break;
            }
        }
        return isSorted;
    }
}
