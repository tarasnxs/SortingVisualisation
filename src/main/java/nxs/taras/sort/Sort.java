package nxs.taras.sort;

public interface Sort {
    boolean doSortIteration(int[] array);

    default void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
