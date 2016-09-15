package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBTableFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLTable {
    MySQLDataHandler dataHandler;


    public MySQLTable(MySQLDataHandler dataHandler) {
        this.dataHandler = dataHandler;

    }

    void createorconnect(){

        String msqlcomand="CREATE TABLE IF NOT EXISTS "+ dataHandler.getMysqltablename()+"(P_Id integer AUTO_INCREMENT, Lastname varchar(50) NOT NULL, Firstname varchar(50) NOT NULL, Adress VARCHAR (50) not null, City varchar(50) not null, PRIMARY KEY (P_Id))";

        try(Connection con=new MySQLConnector(dataHandler).connect();
            PreparedStatement ps = con.prepareStatement(msqlcomand)){ps.executeUpdate();}
        catch (SQLException sql){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(dataHandler.frame, "Ошибка SQL", sql.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        }


    }

}
