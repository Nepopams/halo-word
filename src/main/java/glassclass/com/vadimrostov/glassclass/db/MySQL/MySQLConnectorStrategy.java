package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.ConnectorStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.DBConnectorFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnector;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLConnectorStrategy implements ConnectorStrategy {

    @Override
    public void connect(Object data) {

        MySQLDataHandler msdata=(MySQLDataHandler) data;

        MySQLConnector mysqcon = new MySQLConnector(msdata);
        try (Connection con=mysqcon.connect()){
        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(msdata.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        throw new RuntimeException("");
        }

    }
}
