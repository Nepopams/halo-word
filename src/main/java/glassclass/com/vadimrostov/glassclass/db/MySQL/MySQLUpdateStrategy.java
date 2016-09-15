package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.UpdateStrategy;

/**
 * Created by Vad on 14.09.2016.
 */
public class MySQLUpdateStrategy implements UpdateStrategy {

    @Override
    public void executeStrategy(Object frame) {
        new MySQLUpdate((MySQLDataHandler) frame).updateLNFromSerial();



    }
}
