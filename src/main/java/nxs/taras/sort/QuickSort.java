package nxs.taras.sort;

import nxs.taras.model.DataModel;
import nxs.taras.view.ControlPanel;
import nxs.taras.view.Graph;

public class QuickSort implements Sort {
    private DataModel dataModel;
    private ControlPanel controlPanel;
    private Graph graph;

    @Override
    public boolean doSortIteration(int[] array) {
        return false;
    }


    public void sort(DataModel dataModel, ControlPanel controlPanel, Graph graph) {
        this.dataModel = dataModel;
        this.controlPanel = controlPanel;
        this.graph = graph;

        for (int i = 0; i < dataModel.getArrayCount(); i++) {
            sort(dataModel.getArrayToSort(i), 0, dataModel.getArrayToSort(i).length - 1);
        }
    }

    public void sort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int middleValue = array[middle];

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

        if (low < j)
            sort(array, low, j);

        if (high > i)
            sort(array, i, high);
    }
}
