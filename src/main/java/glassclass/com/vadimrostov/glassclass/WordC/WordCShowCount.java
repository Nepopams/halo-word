package main.java.glassclass.com.vadimrostov.glassclass.WordC;

import java.util.Map;

/**
 * Created by Vad on 15.09.2016.
 */
public class WordCShowCount {
    WordCDataHandler data;
    WordCFrame frame;

    public WordCShowCount(WordCDataHandler data, WordCFrame frame) {
        this.data = data;
        this.frame=frame;
    }

    public void showcount(){
        String wc="";
        for (Map.Entry<String, Integer> pair : data.getWmap().entrySet())
        {
            String key = pair.getKey();
            int val = data.getWmap().get(pair.getKey());
            wc=wc+(key+" = "+val+"\n");
        }
        frame.wcarea.setText(wc);

    }
}
