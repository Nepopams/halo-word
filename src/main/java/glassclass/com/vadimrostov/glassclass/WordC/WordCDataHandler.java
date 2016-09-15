package main.java.glassclass.com.vadimrostov.glassclass.WordC;

import java.util.HashMap;

/**
 * Created by Vad on 15.09.2016.
 */
public class WordCDataHandler {
    private String thistext;
    private HashMap<String, Integer> wmap = new HashMap();

    public String getThistext() {
        return thistext;
    }

    public HashMap<String, Integer> getWmap() {
        return wmap;
    }

    public void setThistext(String thistext) {
        this.thistext = thistext;
    }


}
