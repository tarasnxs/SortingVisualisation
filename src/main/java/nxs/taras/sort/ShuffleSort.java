package nxs.taras.sort;

public class ShuffleSort implements Sort {
    private boolean direction = false;

    @Override
    public boolean doSortIteration(int[] array) {
        boolean isSorted = true;
        if (direction)
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    swapElements(array, j, j+1);
                }
            }
        else
            for (int j = array.length - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    swapElements(array, j, j-1);
                }
            }
        direction = !direction;
        return isSorted;
    }
}
