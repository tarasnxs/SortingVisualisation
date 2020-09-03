package nxs.taras.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private MainPanel mp;

    public MainFrame() {
        setSize(new Dimension(968, 768));
        setPreferredSize(new Dimension(968, 768));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocation(10,0);
        mp = new MainPanel();
        add(mp);
        pack();
    }
}
