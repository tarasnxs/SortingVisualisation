package nxs.taras;

import nxs.taras.view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
