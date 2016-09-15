package main.java.glassclass.com.vadimrostov.glassclass.db;

import main.java.glassclass.com.vadimrostov.glassclass.db.MySQL.MySQLFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGREFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vad on 08.09.2016.
 */
public class DBFrame extends JFrame {

    DBFrame frame=this;





    public DBFrame() throws HeadlessException {
        super("db");
        createUI();
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createUI(){
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton postgrebut = new JButton("postGRESQL test");


        postgrebut.setBounds(5,5,100,20);
        postgrebut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             /*   */
                PostGREFrame frameg = new PostGREFrame();



            }
        });
        panel.add(postgrebut);

        JButton mysqlbut = new JButton("MySQL");
        mysqlbut.setBounds(110,5,100,20);
        mysqlbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MySQLFrame frame = new MySQLFrame();
            }
        });
        panel.add(mysqlbut);





        getContentPane().add(panel);

    }
}
