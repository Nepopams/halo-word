package main.java.glassclass.com.vadimrostov.glassclass.db;

/**
 * Created by Vad on 14.09.2016.
 */
public class DBStrArrayMaker {
    Object frame;

    public DBStrArrayMaker(Object frame) {
        this.frame = frame;
    }

    private DBStrArrayStrategy strategy;

    public void setStrategy(DBStrArrayStrategy strategy){
        this.strategy=strategy;
    }

    public String[][] execute(){
        return strategy.execute(frame);
    }
}
