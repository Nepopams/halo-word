package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBTableFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.TableStrategy;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLTableStrategy implements TableStrategy {
    @Override
    public void execute(Object frame) {

        new MySQLTable((MySQLDataHandler)frame).createorconnect();

    }
}
