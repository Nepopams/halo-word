package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLStrArrMaker {
    MySQLDataHandler dataHandler;

    public MySQLStrArrMaker(MySQLDataHandler dataHandler) {
        this.dataHandler= dataHandler;
    }


    String[][] createStrAr(){
        ArrayList<String[]> al=new ArrayList<>();
        try(Connection con=new MySQLConnector(dataHandler).connect();
            Statement stmt = con.createStatement())
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+dataHandler.getMysqltablename());
            int i=0;
            while (rs.next()) {


                String[] str = {rs.getString(1) , rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5)};
                al.add(i, str);

                i++;

            }
            int k=al.size();
            String[][]a=new String[k][];
            for (int j=0; j<k; j++){
                a[j]=al.get(j);
            }
            return a;
        }
        catch (SQLException e){
            Object[] options={"Ok"};
            JOptionPane.showOptionDialog(dataHandler.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                    options[0]);
            throw new RuntimeException(""+e);
        }

    }

}
