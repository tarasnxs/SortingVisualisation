package nxs.taras.view;

import nxs.taras.controller.MainController;
import nxs.taras.model.BlackWhiteDataModel;
import nxs.taras.model.ColorDataModel;
import nxs.taras.model.DataModel;
import nxs.taras.sort.ParallelQuickSort;
import nxs.taras.sort.QuickSort;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ForkJoinPool;

public class ControlPanel extends JPanel {
    private static ForkJoinPool forkJoinPool = new ForkJoinPool();
    private static final int WIDTH = 190;
    private static final int HEIGHT = 768;
    private MainController mainController;
    private Graph graph;

    private JSlider speedSlider;
    private JLabel currentSpeed;
    private ButtonGroup sortButtonGroup;

    public ControlPanel(MainController mainController, Graph graph) {
        this.mainController = mainController;
        this.graph = graph;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);

        addSortConfig();
        addDataModelConfig();

        add(new JLabel("Speed:"));

        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, 25);
        speedSlider.addChangeListener(e -> currentSpeed.setText(speedSlider.getValue() + "ms"));
        add(speedSlider);

        currentSpeed = new JLabel(speedSlider.getValue() + "ms");
        add(currentSpeed);

        JButton sortB = new JButton("Start sorting");
        sortB.addActionListener(e -> {
            System.out.println("Sort started");

            new Thread(() -> {
                sortB.setEnabled(false);
                if (mainController.getCurrentSortAlgorithm() instanceof ParallelQuickSort) {
                    for (int i = 0; i < mainController.getCurrentDataModel().getArrayCount(); i++) {
                        ParallelQuickSort parallelQuickSort =
                                new ParallelQuickSort(
                                        mainController.getCurrentDataModel(),
                                        this,
                                        graph,
                                        0,
                                        mainController.getCurrentDataModel().getArrayToSort(i).length - 1,
                                        i);
                        forkJoinPool.execute(parallelQuickSort);
                        while (forkJoinPool.getActiveThreadCount() > 0) {
                            try {
                                Thread.sleep(1000l);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                            System.out.println("Active threads count : " + forkJoinPool.getActiveThreadCount());
                        }
                    }

                } else if (mainController.getCurrentSortAlgorithm() instanceof QuickSort) {
                    QuickSort quickSort = (QuickSort) mainController.getCurrentSortAlgorithm();
                    quickSort.sort(mainController.getCurrentDataModel(), this, graph);
                } else {
                    boolean isSorted = false;
                    while (!isSorted) {
                        isSorted = true;
                        for (int i = 0; i < mainController.getCurrentDataModel().getDataArray().length; i++)
                            isSorted = isSorted & mainController.getCurrentSortAlgorithm().doSortIteration(mainController.getCurrentDataModel().getArrayToSort(i));
                        graph.repaint();
                        try {
                            Thread.sleep(speedSlider.getValue());
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }
                }
                sortB.setEnabled(true);
            }).start();

        });
        add(sortB);
    }

    private void addSortConfig() {
        add(new JLabel("Sort algorithm:"));
        sortButtonGroup = new ButtonGroup();
        for (String sort : mainController.getSortAlgorithms().getAlgorithmsNames()) {
            JRadioButton jRadioButton = new JRadioButton(sort);
            jRadioButton.addActionListener(e -> {
                mainController.setCurrentSortAlgorithm(((JRadioButton) e.getSource()).getText());
            });
            sortButtonGroup.add(jRadioButton);
            add(jRadioButton);
        }
    }

    private void addDataModelConfig() {
        add(new JLabel("Data model:"));
        ButtonGroup dataModelButtonGroup = new ButtonGroup();

        JRadioButton bwDataModel = new JRadioButton("Black-white");
        bwDataModel.addActionListener(e -> {
            mainController.setCurrentDataModel(new BlackWhiteDataModel());
            graph.repaint();
        });
        dataModelButtonGroup.add(bwDataModel);
        add(bwDataModel);

        JRadioButton singleColorDataModel = new JRadioButton("Single color");
        singleColorDataModel.addActionListener(e -> {
            mainController.setCurrentDataModel(new ColorDataModel(1));
            graph.repaint();
        });
        dataModelButtonGroup.add(singleColorDataModel);
        add(singleColorDataModel);

        JRadioButton multiColorDataModel = new JRadioButton("Multicolor");
        multiColorDataModel.addActionListener(e -> {
            mainController.setCurrentDataModel(new ColorDataModel(DataModel.ARRAY_SIZE));
            graph.repaint();
        });
        dataModelButtonGroup.add(multiColorDataModel);
        add(multiColorDataModel);
    }

    public JSlider getSpeedSlider() {
        return speedSlider;
    }
}
