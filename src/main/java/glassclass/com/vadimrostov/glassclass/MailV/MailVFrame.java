package main.java.glassclass.com.vadimrostov.glassclass.MailV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vad on 15.09.2016.
 */
public class MailVFrame extends JFrame{
    private JTextField mtextfield;
    JPanel mpanel;
    JLabel mlabel;
    public MailVFrame() throws HeadlessException {
        super("Mail validator");
        createmUi();
    }

    public void createmUi(){



        mpanel = new JPanel();
        mpanel.setLayout(null);

        JButton vbutton = new JButton("Push da TEMPA");
        vbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = mtextfield.getText();
                Pattern pattern = Pattern.compile("[a-z0-9][a-z0-9\\-\\_.]*[^.]@[a-z0-9][a-z0-9\\-\\_.]*\\.[a-z]{2,6}");
                Matcher matcher = pattern.matcher(s);



                if (s.isEmpty()) {
                    mlabel.setText("Введи e-mail");
                } else if (matcher.matches()) {
                    mlabel.setText("Правильно");
                } else {
                    mlabel.setText("Это не похоже на e-mail");
                }

            }
        });
        vbutton.setBounds(210,5,120,20);

        mpanel.add(vbutton);
        vbutton.setLayout(null);

        mtextfield = new JTextField();
        mtextfield.setColumns(30);
        mtextfield.setBounds(5,5,200,20);

        mpanel.add(mtextfield);
        mtextfield.setLayout(null);

        mlabel = new JLabel("Введи e-mail");
        mlabel.setBounds(5,30,260,20);
        mpanel.add(mlabel);
        mpanel.setLayout(null);



        getContentPane().add(mpanel);


    }



}
