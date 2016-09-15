package main.java.glassclass.com.vadimrostov.glassclass;

import main.java.glassclass.com.vadimrostov.glassclass.MailV.MailVFrame;
import main.java.glassclass.com.vadimrostov.glassclass.WordC.WordCFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.DBFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vadim on 05.08.2016.
 */
public class GlassClass extends JFrame{
    JPanel panel;

    public GlassClass() throws HeadlessException {
        super("Glass Class");
        createUI();
    }

    public void createUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setLayout(null);

        JButton mailBut = new JButton("EMail Validatot");
        mailBut.setBounds(5, 5, 100, 20);
        mailBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MailVFrame mframe = new MailVFrame();
                mframe.setSize(450,200);
                mframe.setLocationRelativeTo(null);
                mframe.setVisible(true);
            }
        });
        panel.add(mailBut);
        mailBut.setLayout(null);

        JButton wordBut = new JButton("Word count");
        wordBut.setBounds(110, 5, 100, 20);
        wordBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WordCFrame wframe = new WordCFrame();
                wframe.setSize(450,500);
                wframe.setLocationRelativeTo(null);
                wframe.setVisible(true);
            }
        });
        panel.add(wordBut);
        wordBut.setLayout(null);

        JButton dbbut = new JButton("DB");
        dbbut.setBounds(220,5,100,20);
        dbbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBFrame fr = new DBFrame();
            }
        });
        panel.add(dbbut);

        getContentPane().add(panel);


    }






    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        GlassClass frame = new GlassClass();
        frame.setSize(450, 900);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
