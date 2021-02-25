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
        //setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setLayout(null);
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(graph);
        add(controlPanel);
        setVisible(true);
    }


}
