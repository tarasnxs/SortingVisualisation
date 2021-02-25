package nxs.taras.sort;

import nxs.taras.model.DataModel;
import nxs.taras.view.ControlPanel;
import nxs.taras.view.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort extends RecursiveAction implements Sort{
    private DataModel dataModel;
    private ControlPanel controlPanel;
    private Graph graph;
    private int low;
    private int high;
    private int arrayIndex;

    public ParallelQuickSort() {

    }

    public ParallelQuickSort(DataModel dataModel, ControlPanel controlPanel, Graph graph, int low, int high, int arrayIndex) {
        this.dataModel = dataModel;
        this.controlPanel = controlPanel;
        this.graph = graph;
        this.low = low;
        this.high = high;
        this.arrayIndex = arrayIndex;
    }

    @Override
    protected void compute() {
        List<ParallelQuickSort> subTasks = new ArrayList<>();
        int[] array = dataModel.getArrayToSort(arrayIndex);

        if (array.length == 0)
            return;
        if (low >= high)
            return;

        //int middle = low + (high - low) / 2;
        int middleValue = findMiddleValue(array, low, high);

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < middleValue)
                i++;

            while (array[j] > middleValue)
                j--;

            if (i <= j) {
                swapElements(array, i, j);
                i++;
                j--;

                graph.repaint();
                try {
                    Thread.sleep(controlPanel.getSpeedSlider().getValue());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (low < j) {
            ParallelQuickSort parallelQuickSort = new ParallelQuickSort(dataModel, controlPanel, graph, low, j, arrayIndex);
            parallelQuickSort.fork();
            subTasks.add(parallelQuickSort);
        }

        if (high > i) {
            ParallelQuickSort parallelQuickSort = new ParallelQuickSort(dataModel, controlPanel, graph, i, high, arrayIndex);
            parallelQuickSort.fork();
            subTasks.add(parallelQuickSort);
        }

        for (ParallelQuickSort parallelQuickSort : subTasks)
            parallelQuickSort.join();
    }

    private int findMiddleValue(int[] array, int low, int high) {
        return (int) Arrays.stream(Arrays.copyOfRange(array, low, high)).average().orElse(0.0);
    }

    @Override
    public boolean doSortIteration(int[] array) {
        return false;
    }
}
