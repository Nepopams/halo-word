package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBConnectorFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by uad on 10.09.2016.
 */
public class PostGREConnector {
    PostGREDataHandler frame;


    public PostGREConnector(PostGREDataHandler frame) {
        this.frame = frame;

    }






    Connection connect() throws SQLException{
        String dbname = frame.getPgredbname(), dblogin = frame.getPgrelogin(), dbpass = frame.getPgrepassword();
        int port = frame.getPostgreportn();

        String url = "jdbc:postgresql://localhost:" + port + "/" + dbname;

      Connection con = DriverManager.getConnection(url, dblogin, dbpass);
            return con;



    }
}
