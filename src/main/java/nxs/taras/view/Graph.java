package nxs.taras.view;

import nxs.taras.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class Graph extends JComponent {
    private static final int WIDTH = 768;
    private static final int HEIGHT = 768;
    private MainController mainController;

    public Graph(MainController mainController) {
        this.mainController = mainController;
        setLocation(195, 0);
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graph) {
        super.paint(graph);
        mainController.getCurrentDataModel().paint(graph);
    }
}
