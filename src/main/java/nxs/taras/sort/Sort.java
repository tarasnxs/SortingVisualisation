package nxs.taras.sort;

public interface Sort {
    boolean doSortIteration(int[] array);

    default void swapElements(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
