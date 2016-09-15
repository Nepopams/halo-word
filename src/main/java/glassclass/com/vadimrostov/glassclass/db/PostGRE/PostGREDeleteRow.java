package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 14.09.2016.
 */
public class PostGREDeleteRow {
    PostGREDataHandler frame;

    public PostGREDeleteRow(PostGREDataHandler frame) {
        this.frame = frame;
    }

    void deleteRow(){
        String sql="DELETE FROM "+frame.getPgretablename()+" where CONTACT_ID=?";

        try(Connection con = new PostGREConnector(frame).connect();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,frame.getDelid());
            ps.executeUpdate();

        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(((PostGREDataHandler) frame).frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        }
    }
}
