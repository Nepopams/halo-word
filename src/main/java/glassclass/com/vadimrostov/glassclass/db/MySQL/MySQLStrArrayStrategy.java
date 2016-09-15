package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBStrArrayStrategy;

/**
 * Created by Vad on 14.09.2016.
 */
public class MySQLStrArrayStrategy implements DBStrArrayStrategy {

    @Override
    public String[][] execute(Object frame) {
        MySQLDataHandler mySQLFrame=(MySQLDataHandler) frame;
        return  new MySQLStrArrMaker(mySQLFrame).createStrAr();
    }
}
