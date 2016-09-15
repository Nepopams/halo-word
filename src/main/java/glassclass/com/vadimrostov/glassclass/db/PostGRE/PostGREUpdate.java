package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Vad on 12.09.2016.
 */
public class PostGREUpdate {

    PostGREDataHandler frame;

    public PostGREUpdate( PostGREDataHandler frame) {

        this.frame=frame;
    }

    void updateLNfromSerial() {

        String sql="UPDATE "+frame.getPgretablename()+" SET LAST_NAME = ? WHERE CONTACT_ID=?";


        try(Connection con =new PostGREConnector(frame).connect();
            PreparedStatement stmt = con.prepareStatement(sql)){
        stmt.setString(1, frame.getChangename());
        stmt.setInt(2, frame.getSernum());
        stmt.executeUpdate();
        stmt.close();}
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(frame.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
        throw new RuntimeException(""+e);
}


    }


}
