package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLManualInsert {
    MySQLDataHandler dataHandler;

    public MySQLManualInsert(MySQLDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    void manualinsert(){
        String sql="insert into "+dataHandler.getMysqltablename()+"(Lastname, Firstname, Adress, City) "+
                "VALUES (?,?,?,?)";
        try(Connection connection=new MySQLConnector(dataHandler).connect();
            PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1, dataHandler.getLn());
            ps.setString(2, dataHandler.getFn());
            ps.setString(3, dataHandler.getAdr());
            ps.setString(4, dataHandler.getCity());
            ps.executeUpdate();

        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(dataHandler.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
            throw new RuntimeException(""+e);
        }
    }


}
