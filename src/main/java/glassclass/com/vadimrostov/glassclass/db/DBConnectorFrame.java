package main.java.glassclass.com.vadimrostov.glassclass.db;


import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLConnectorStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLDataHandler;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREConnectorStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREDataHandler;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vad on 13.09.2016.
 */
public class DBConnectorFrame extends JFrame{
    Object datadb;

   public JTextField dbnametf, dbporttf, dblogintf, dbpasstf;
    DBConnectorFrame dbcframe=this;


    public String s,log,pass, maindb, mainport, mainuser ;
   public int ss, label;


    public DBConnectorFrame(MySQLDataHandler framedb) throws HeadlessException {
        super("Connect 2 msql DB");
        this.datadb = framedb;
        this.setSize(1200, 800);
        this.setVisible(true);

        this.label=1;
        this.maindb="test";
        this.mainport="3306";
        this.mainuser="root";
        createUI();

    }

    public DBConnectorFrame(PostGREDataHandler framedb) throws HeadlessException {
        super("Connect 2 postgresql DB");
        this.datadb = framedb;
        this.setSize(1200, 800);
        this.setVisible(true);

        this.label=2;
        this.maindb="mydb";
        this.mainport="5432";

        this.mainuser="postgres";
        createUI();
    }



    private void createUI(){

        JPanel panel=new JPanel();
        panel.setLayout(null);

        JLabel dbname = new JLabel("Имя Базы данных");
        dbname.setBounds(5,5,100,20);
        panel.add(dbname);
        dbnametf = new JTextField(maindb);
        dbnametf.setBounds(105,5,100,20);
        panel.add(dbnametf);

        JLabel dbport= new JLabel("Порт #");
        dbport.setBounds(5,30,100,20);
        panel.add(dbport);
        dbporttf = new JTextField(mainport);
        dbporttf.setBounds(105,30,100,20);
        panel.add(dbporttf);


        JLabel dblogin= new JLabel("login");
        dblogin.setBounds(5,55,100,20);
        panel.add(dblogin);
        dblogintf = new JTextField(mainuser);
        dblogintf.setBounds(105,55,100,20);
        panel.add(dblogintf);

        JLabel dbpass= new JLabel("password");
        dbpass.setBounds(5,80,100,20);
        panel.add(dbpass);
        dbpasstf = new JTextField();
        dbpasstf.setBounds(105,80,100,20);
        panel.add(dbpasstf);


        JButton dbnamebut = new JButton("Ввести");
        dbnamebut.setBounds(205,5,100,20);
        dbnamebut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Ok"};
                if(!dbcframe.dbnametf.getText().isEmpty()&&!dbcframe.dbporttf.getText().isEmpty()&&!dbcframe.dblogintf.getText().isEmpty()&&!dbcframe.dbpasstf.getText().isEmpty()){
                s=dbcframe.dbnametf.getText();
                ss=Integer.parseInt(dbcframe.dbporttf.getText());
                log = dbcframe.dblogintf.getText();
                pass = dbcframe.dbpasstf.getText();
                DBConnector con=new DBConnector(datadb);
                switch (label){
                    case 1: con.setStrategy(new MySQLConnectorStrategy());
                        MySQLDataHandler data=(MySQLDataHandler) datadb;
                        data.setMysqldbname(s);
                        data.setMysqlportn(ss);
                        data.setMysqllogin(log);
                        data.setMysqlpassword(pass);
                        break;
                    case 2: con.setStrategy(new PostGREConnectorStrategy());
                        PostGREDataHandler dataHandler=(PostGREDataHandler) datadb;
                        dataHandler.setPgredbname(s);
                        dataHandler.setPostgreportn(ss);
                        dataHandler.setPgrelogin(log);
                        dataHandler.setPgrepassword(pass);
                        break;
                }



                con.executeStrategy();
                dbcframe.setVisible(false);}
                else JOptionPane.showOptionDialog(dbcframe, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );


            }
        });
        panel.add(dbnamebut);

        getContentPane().add(panel);
    }


}
