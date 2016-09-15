package main.java.glassclass.com.vadimrostov.glassclass.db;

import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLDataHandler;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLTableStrategy;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREConnector;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREDataHandler;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGRETableStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Vad on 13.09.2016.
 */
public class DBTableFrame extends JFrame{
    Object frame;
    JTextArea area;
    String tablename;
    int labelint;
    DBTableFrame dbtframe=this;

    public DBTableFrame(MySQLDataHandler frame) throws HeadlessException {
        super("MSQL table");
        this.frame = frame;
        this.setSize(400, 90);
        this.setVisible(true);
        this.createUI();
        labelint=1;
    }
    public DBTableFrame(PostGREDataHandler frame) throws HeadlessException {
        super("PGRE table");
        this.frame = frame;
        this.setSize(400, 90);
        this.setVisible(true);
        this.createUI();
        labelint=2;
    }



    private void createUI() {
        JPanel panel = new JPanel(null);


        JLabel label = new JLabel("DB Table Name");
        label.setBounds(0, 5, 100, 20);
        panel.add(label);

        area = new JTextArea();
        area.setBounds(100, 5, 100, 20);
        panel.add(area);

        JButton button = new JButton("In");
        button.setBounds(200, 5, 100, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Ok"};
                if(!area.getText().isEmpty()){
            tablename=area.getText();
                DBTable context=new DBTable(frame);
                switch (labelint){
                    case 1: context.setStrategy(new MySQLTableStrategy());
                        MySQLDataHandler dataHandler=(MySQLDataHandler) frame;
                        dataHandler.setMysqltablename(tablename);
                        break;
                    case 2: context.setStrategy(new PostGRETableStrategy());
                        PostGREDataHandler dataHandler1=(PostGREDataHandler) frame;
                        dataHandler1.setPgretablename(tablename);
                        break;
                }

                context.executeStrategy();
                dbtframe.setVisible(false);}
                else  JOptionPane.showOptionDialog(dbtframe, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );


            }
        });
        panel.add(button);
        this.getContentPane().add(panel);
    }
}
