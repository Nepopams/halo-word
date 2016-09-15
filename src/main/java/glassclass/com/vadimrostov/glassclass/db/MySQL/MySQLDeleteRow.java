package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLDeleteRow {

    MySQLDataHandler dataHandler;

    public MySQLDeleteRow( MySQLDataHandler dataHandler) {

        this.dataHandler = dataHandler;
    }

    void deleteRow(){
        String sql="DELETE FROM "+dataHandler.getMysqltablename()+" where P_Id=?";

        try(Connection con = new MySQLConnector(dataHandler).connect();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,dataHandler.getDelid());
            ps.executeUpdate();

        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(dataHandler.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        }
    }
}
