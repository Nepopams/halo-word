package main.java.glassclass.com.vadimrostov.glassclass.db;

/**
 * Created by Vad on 14.09.2016.
 */
public class DBUpdate {
    Object frame;
    private UpdateStrategy strategy;

    public DBUpdate(Object frame) {
        this.frame = frame;
    }

    public void setStrategy(UpdateStrategy strategy){
        this.strategy=strategy;
    }

    public void executeStrategy(){
        strategy.executeStrategy(frame);
    }

}
