package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBTableFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class PostGRETable {
    PostGREDataHandler pgreframe;


    public PostGRETable(PostGREDataHandler pgreframe) {
        this.pgreframe = pgreframe;

    }

    void createorconnect(){

        String pgrecomand="CREATE TABLE IF NOT EXISTS " + pgreframe.getPgretablename() + "(CONTACT_ID SERIAL, LAST_NAME VARCHAR(50) NOT NULL, FIRST_NAME VARCHAR(50) NOT NULL, PARENT_NAME VARCHAR(50) NOT NULL, years VARCHAR(50) NOT NULL, STREET VARCHAR(50) NOT NULL, house VARCHAR(50) NOT NULL,ROOM VARCHAR(50) NOT NULL)";
        try(Connection con=new PostGREConnector(pgreframe).connect();
            PreparedStatement ps = con.prepareStatement(pgrecomand)){ps.executeUpdate();}
        catch (SQLException sql){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(pgreframe.frame, "Ошибка SQL", sql.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
            throw new RuntimeException(""+sql);
        }


    }

}
