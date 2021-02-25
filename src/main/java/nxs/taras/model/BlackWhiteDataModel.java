package nxs.taras.model;

import java.awt.*;

public class BlackWhiteDataModel extends DataModel {

    public BlackWhiteDataModel() {
        super(1, ARRAY_SIZE);
    }

    @Override
    public void paint(Graphics graph) {
        graph.setColor(Color.BLACK);
        graph.fillRect(0, 0, ARRAY_SIZE, ARRAY_SIZE);
        graph.setColor(Color.WHITE);
        for (int j = 0; j < dataArray[0].length; j++) {
            graph.fillRect(j,0,1,dataArray[0][j]);
        }
    }
}
