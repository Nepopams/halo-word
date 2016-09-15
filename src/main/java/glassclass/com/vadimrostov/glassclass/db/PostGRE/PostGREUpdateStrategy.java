package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.UpdateStrategy;

/**
 * Created by Vad on 14.09.2016.
 */
public class PostGREUpdateStrategy implements UpdateStrategy{

    @Override
    public void executeStrategy(Object frame) {

        new PostGREUpdate( (PostGREDataHandler) frame).updateLNfromSerial();
    }
}
