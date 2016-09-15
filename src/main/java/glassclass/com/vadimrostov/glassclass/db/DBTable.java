package main.java.glassclass.com.vadimrostov.glassclass.db;

/**
 * Created by Vad on 13.09.2016.
 */
public class DBTable {

    Object frame;

    private TableStrategy strategy;

    public DBTable(Object frame) {

        this.frame = frame;
    }

    public void setStrategy(TableStrategy strategy){
        this.strategy=strategy;
    }

    public void executeStrategy() {
        strategy.execute(frame);
    }

}
