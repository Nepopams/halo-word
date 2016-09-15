package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.ConnectorStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.DBConnectorFrame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vad on 13.09.2016.
 */
public class PostGREConnectorStrategy implements ConnectorStrategy{
    @Override
    public void connect( Object frame) {

        PostGREDataHandler conframe=(PostGREDataHandler) frame;
        PostGREConnector con=new PostGREConnector(conframe);
        try(Connection connec=con.connect()){

        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(((PostGREDataHandler) frame).frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
            throw new RuntimeException(""+e);
        }

    }
}
