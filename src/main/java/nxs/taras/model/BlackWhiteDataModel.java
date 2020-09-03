package nxs.taras.model;

import java.awt.*;

public class BlackWhiteDataModel extends DataModel {

    public BlackWhiteDataModel() {
        super(1, ARRAY_SIZE);
    }

    @Override
    public void paint(Graphics graph) {
        graph.setColor(Color.BLACK);
        for (int j = 0; j < dataArray[0].length; j++) {
            graph.fillRect(0,j,dataArray[0][j],1);
        }
    }
}
