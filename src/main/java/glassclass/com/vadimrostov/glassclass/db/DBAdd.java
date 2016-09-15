package main.java.glassclass.com.vadimrostov.glassclass.db;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBAddStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.TableStrategy;

/**
 * Created by Vad on 13.09.2016.
 */
public class DBAdd {
    private DBAddStrategy strategy;
    Object frame;

    public DBAdd(Object frame) {
        this.frame = frame;
    }

    public void setStrategy(DBAddStrategy strategy){
        this.strategy=strategy;
    }

    public void executeStrategy(){
        strategy.insertDB(frame);
    }
}
