package nxs.taras.view;

import nxs.taras.controller.MainController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Taras on 27.11.2017.
 */
public class MainPanel extends JPanel {
    private static final int WIDTH = 968;
    private static final int HEIGHT = 768;
    private MainController mainController;
    private Graph graph;
    private ControlPanel controlPanel;

    public MainPanel() {
        this.mainController = new MainController();
        this.graph = new Graph(this.mainController);
        this.controlPanel = new ControlPanel(this.mainController, this.graph);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
        add(controlPanel);
        add(graph);
    }


   /* boolean quickSort(Pair<Integer,Color>[] block, int startIndex, int endIndex) {
        if (endIndex >= startIndex)
            return true;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            if (block[i].getKey() < minValue)
                minValue = block[i].getKey();
            if (block[i].getKey() > maxValue)
                maxValue = block[i].getKey();
        }
        int avgValue = (maxValue - minValue) / 2;
        int minDiff = Integer.MAX_VALUE;
        int indexOfAvgElement = 0;

        for (int i = startIndex; i < endIndex; i++) {
            if (Math.abs(block[i].getKey() - avgValue) < minDiff) {
                minDiff = Math.abs(block[i].getKey() - avgValue);
                indexOfAvgElement = i;
            }
        }

        avgValue = block[indexOfAvgElement].getKey();

        for (int i = startIndex; i < endIndex; i++) {
            if ( (block[i].getKey() < avgValue && i > indexOfAvgElement) ||
                    (block[i].getKey() >= avgValue && i < indexOfAvgElement)) {
                Pair<Integer, Color> temp = block[i];
                block[i] = block[indexOfAvgElement];
                block[indexOfAvgElement] = temp;
                indexOfAvgElement = i;
            }
        }

        repaint();
        final int finalIndexOfAvgElement = indexOfAvgElement;
        forkJoinPool.execute(() -> {
            quickSort(block, startIndex, finalIndexOfAvgElement + 1);
        });

        forkJoinPool.execute(() -> {
            quickSort(block, finalIndexOfAvgElement, endIndex);
        });

        return  true;
    }


    boolean stupidSort() {
        boolean isSorted = true;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length - 1; j++) {
                if (block[i][j].getKey() < block[i][j + 1].getKey()) {
                    isSorted = false;
                    Pair a = block[i][j];
                    block[i][j] = block[i][j + 1];
                    block[i][j + 1] = a;
                    break;
                }
            }
        }

        return isSorted;
    }

    boolean bubleSort() {
        boolean isSorted = true;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length - 1; j++) {
                if (block[i][j].getKey() < block[i][j + 1].getKey()) {
                    isSorted = false;
                    Pair a = block[i][j];
                    block[i][j] = block[i][j + 1];
                    block[i][j + 1] = a;
                }
            }
        }

        return isSorted;
    }

    boolean shuffleSort(boolean direction) {
        boolean isSorted = true;
        for (int i = 0; i < block.length; i++) {
            if (direction)
                for (int j = 0; j < block[i].length - 1; j++) {
                    if (block[i][j].getKey() < block[i][j + 1].getKey()) {
                        isSorted = false;
                        Pair a = block[i][j];
                        block[i][j] = block[i][j + 1];
                        block[i][j + 1] = a;
                    }
                }
            else
                for (int j = block[i].length - 1; j > 0; j--) {
                    if (block[i][j].getKey() > block[i][j - 1].getKey()) {
                        isSorted = false;
                        Pair a = block[i][j];
                        block[i][j] = block[i][j - 1];
                        block[i][j - 1] = a;
                    }
                }
        }
        return isSorted;

    }

    boolean evenOddSort() {
        boolean isSorted = true;
        for (int i = 0; i < block.length; i++) {
                for (int j = 0; j < block[i].length - 1; j+=2) {
                    if (block[i][j].getKey() < block[i][j + 1].getKey()) {
                        isSorted = false;
                        Pair a = block[i][j];
                        block[i][j] = block[i][j + 1];
                        block[i][j + 1] = a;
                    }
                }
                for (int j = 1; j < block[i].length - 1; j+=2) {
                    if (block[i][j].getKey() < block[i][j + 1].getKey()) {
                        isSorted = false;
                        Pair a = block[i][j];
                        block[i][j] = block[i][j + 1];
                        block[i][j + 1] = a;
                    }
                }
        }
        return isSorted;

    }

    boolean combSort(int diff) {
        boolean isSorted = true;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; (j + diff) < block[i].length; j++) {
                if (block[i][j].getKey() < block[i][j + diff].getKey()) {
                    isSorted = false;
                    Pair a = block[i][j];
                    block[i][j] = block[i][j + diff];
                    block[i][j + diff] = a;
                }
            }
        }

        return diff > 1 ? false : isSorted;
    }*/


}
