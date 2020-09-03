package nxs.taras.model;

import java.awt.*;
import java.util.HashMap;

public class ColorDataModel extends DataModel {
    private HashMap<Integer, Color> colorMap;

    public ColorDataModel(int arrayCount) {
        super(arrayCount, ARRAY_SIZE);
        colorMap = new HashMap<>();
        for (int i = 0; i <= 256*3; i++) {
            if ( i < 64*3 )
                colorMap.put(i, new Color(255,(int) ((i/192.0)*255), 0));
            else if ( i < 128*3 )
                colorMap.put(i, new Color((int) (255 - (((i-192.0)/192.0)*255)), 255, 0));
            else if ( i < 192*3 )
                colorMap.put(i, new Color(0, 255, (int) (((i-384.0)/192.0)*255)));
            else
                colorMap.put(i, new Color(0,(int) (255 - (((i-576.0)/192.0)*255)),  255));
        }
    }

    @Override
    public void paint(Graphics graph) {
        if (dataArray.length == 1) {
            for (int j = 0; j < dataArray[0].length; j++) {
                graph.setColor(colorMap.get(dataArray[0][j]));
                graph.fillRect(0,j,ColorDataModel.ARRAY_SIZE,1);
            }
        } else {
            for (int i = 0; i < dataArray.length; i++) {
                for (int j = 0; j < dataArray[i].length; j++) {
                    graph.setColor(colorMap.get(dataArray[i][j]));
                    graph.fillRect(i,j,1,1);
                }
            }
        }
    }
}
