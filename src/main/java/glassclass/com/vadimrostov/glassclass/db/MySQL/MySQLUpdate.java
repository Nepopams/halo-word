package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 14.09.2016.
 */
public class MySQLUpdate {
    MySQLDataHandler dataHandler;

    public MySQLUpdate(MySQLDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public void updateLNFromSerial(){
        String sql="UPDATE "+dataHandler.getMysqltablename()+" SET Lastname = ? WHERE city = ?";
        try (Connection con=new MySQLConnector(dataHandler).connect();
             PreparedStatement ps=con.prepareStatement(sql)){
             ps.setString(1, dataHandler.getChangename());
             ps.setInt(2, dataHandler.getSernum());
             ps.executeUpdate();

        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(dataHandler.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
            throw new RuntimeException("dsada"+e);
        }
    }

}
