package nxs.taras.controller;

import nxs.taras.model.ColorDataModel;
import nxs.taras.model.DataModel;
import nxs.taras.sort.BubbleSort;
import nxs.taras.sort.Sort;

public class MainController {
    private SortAlgorithms sortAlgorithms;
    private Sort currentSortAlgorithm;
    private DataModel currentDataModel;


    public MainController() {
        sortAlgorithms = new SortAlgorithms();
        currentDataModel = new ColorDataModel(1);
        try {
            currentSortAlgorithm = sortAlgorithms.getSortAlgorithm(BubbleSort.class.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentSortAlgorithm(String className) {
        try {
            currentSortAlgorithm = sortAlgorithms.getSortAlgorithm(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentDataModel(DataModel dataModel) {
        currentDataModel = dataModel;
    }

    public DataModel getCurrentDataModel() {
        return currentDataModel;
    }

    public SortAlgorithms getSortAlgorithms() {
        return sortAlgorithms;
    }

    public Sort getCurrentSortAlgorithm() {
        return currentSortAlgorithm;
    }
}
