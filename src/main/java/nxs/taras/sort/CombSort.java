package nxs.taras.sort;

public class CombSort implements Sort {
    private int gap = 0;

    @Override
    public boolean doSortIteration(int[] array) {
        if (gap == 0)
            gap = array.length;
        boolean swapped = false;
        gap = newGap(gap);

        for(int i = 0; i < (array.length - gap); i++) {
            if(array[i] > array[i + gap]){
                swapped = true;
                swapElements(array, i, i + gap);
            }
        }
        if (gap <= 1 && !swapped) {
            gap = 0;
            return true;
        } else
            return false;
    }

    private int newGap(int gap) {
        gap = gap * 10 / 13;

        if(gap == 9 || gap == 10)
            gap = 11;

        return Math.max(gap, 1);
    }
}
