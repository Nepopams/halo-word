package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 14.09.2016.
 */
public class PostGRESQLManualInsert {
    PostGREDataHandler frame;

    public PostGRESQLManualInsert(PostGREDataHandler frame) {
        this.frame = frame;
    }

    public void manualinsert(){
        String sql="INSERT INTO " + frame.getPgretablename() + " (LAST_NAME, FIRST_NAME, PARENT_NAME, YEARS, STREET, HOUSE, ROOM) VALUES (?, ?, ?, ?, ?, ?,?)";
        try(Connection connection=new PostGREConnector(frame).connect();
            PreparedStatement ps=connection.prepareStatement(sql)) {

            ps.setString(1, frame.getLn());
            ps.setString(2, frame.getFn());
            ps.setString(3, frame.getPn());
            ps.setInt(4, frame.getAge());
            ps.setString(5, frame.getStr());
            ps.setInt(6, frame.getHouse());
            ps.setDouble(7, frame.getRoom());
            ps.executeUpdate();


        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(frame.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);

        }

    }

}

