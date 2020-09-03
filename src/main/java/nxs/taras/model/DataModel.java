package nxs.taras.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class DataModel {
    public static final int ARRAY_SIZE = 768;
    protected int[][] dataArray;

    protected DataModel(int arrayCount, int arraySize) {
        dataArray = new int[arrayCount][arraySize];
        shuffleData();
    }

    public int[] getArrayToSort(int arrayIndex) {
        return dataArray[arrayIndex];
    }

    public void shuffleData() {
        ArrayList<Integer> nums = IntStream.range(0, ARRAY_SIZE).boxed().collect(Collectors.toCollection(ArrayList<Integer>::new));
        Collections.shuffle(nums);
        for (int i = 0; i < dataArray.length; i++) {
            for (int j = 0; j < dataArray[0].length; j++) {
                dataArray[i][j] = nums.get(j);
            }
            Collections.shuffle(nums);
        }
    }

    public int getArrayCount() {
        return dataArray.length;
    }

    public int[][] getDataArray() {
        return dataArray;
    }

    public abstract void paint(Graphics graph);
}
