package main.java.glassclass.com.vadimrostov.glassclass.db;

/**
 * Created by Vad on 13.09.2016.
 */
public class DBConnector {

    Object data;

    public DBConnector( Object data) {

        this.data = data;
    }

    private ConnectorStrategy strategy;
    public void setStrategy(ConnectorStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
       strategy.connect(data);
    }
}
