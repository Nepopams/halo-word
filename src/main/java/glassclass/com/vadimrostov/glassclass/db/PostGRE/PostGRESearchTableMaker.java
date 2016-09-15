package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Vad on 13.09.2016.
 */
public class PostGRESearchTableMaker {

        PostGREDataHandler frame;

        public PostGRESearchTableMaker(PostGREDataHandler frame) {
            this.frame = frame;
        }

        String[][] searchtc() {
            ArrayList<String[]> al=new ArrayList<>();
            String sql="SELECT * FROM "+frame.getPgretablename();


            try(Connection con = new PostGREConnector(frame).connect();
            Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM "+frame.getPgretablename());
            int i=0;
            while (rs.next()) {
                if(rs.getInt("years")==frame.getLastnamesearch()){

                    String[] str = {rs.getString(1) , rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8)};
                    al.add(i, str);

                    i++;}

            }




            int k=al.size();
            String[][]a=new String[k][];
            for (int j=0; j<al.size(); j++){
                a[j]=al.get(j);
            }

            return a;}
            catch (SQLException e){
                Object[] options={"Ok"};
                JOptionPane.showOptionDialog(frame.frame, "Ошибка SQL", e.toString(), JOptionPane.NO_OPTION, 0, null,options,
                        options[0]);
                throw new RuntimeException(""+e);
            }
        }
    }

