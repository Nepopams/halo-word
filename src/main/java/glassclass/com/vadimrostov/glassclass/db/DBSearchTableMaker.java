package main.java.glassclass.com.vadimrostov.glassclass.db;

/**
 * Created by Vad on 14.09.2016.
 */
public class DBSearchTableMaker {
    Object frame;

    public DBSearchTableMaker(Object frame) {
        this.frame = frame;
    }

    private DBSearchTableMakerStrategy strategy;

    public void setStrategy(DBSearchTableMakerStrategy strategy){
        this.strategy=strategy;
    }

    public String[][] executeStrategy(){
        return strategy.execute(frame);
    }



}
