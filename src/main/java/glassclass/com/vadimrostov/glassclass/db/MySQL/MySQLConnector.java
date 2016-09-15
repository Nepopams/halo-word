package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBConnectorFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREConnector;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Vad on 12.09.2016.
 */
public class MySQLConnector {
    MySQLDataHandler data;




    public MySQLConnector(MySQLDataHandler data) {
        this.data = data;

    }





    java.sql.Connection connect() throws SQLException{



        String dbname=data.getMysqldbname(), dblogin=data.getMysqllogin(), dbpass=data.getMysqlpassword();
        int port=data.getMysqlportn();

       String url = "jdbc:mysql://localhost:"+port+"/"+dbname;
     java.sql.Connection con = DriverManager.getConnection(url, dblogin, dbpass);

               return con;



    }
}
