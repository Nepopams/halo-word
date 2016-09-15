package main.java.glassclass.com.vadimrostov.glassclass.WordC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vad on 15.09.2016.
 */
public class WordCFrame extends JFrame {



    WordCFrame frame=this;

    JPanel wpanel;
    JTextField wtextfield;
    JTextArea wcarea;
    WordCDataHandler data=new WordCDataHandler();

    public WordCFrame(){
        super("Word Count?");
        createwUi();
    }
    public void createwUi(){
        wpanel = new JPanel();
        wpanel.setLayout(new FlowLayout());
        wpanel.setLayout(null);

        wtextfield = new JTextField();
        wtextfield.setColumns(150);
        wtextfield.setBounds(5,5,200,20);
        wpanel.add(wtextfield);
        wtextfield.setLayout(null);

        wcarea = new JTextArea();
        wcarea.setBounds(5,45,325,470 );
        wpanel.add(wcarea);
        wcarea.setLayout(null);



        JButton wbutton = new JButton("Push da TEMPA");
        wbutton.setBounds(210,5,120,20);
        wbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wtextfield.getText().isEmpty()){
                    wcarea.setText("введите текст");
                }
                else {
                    data.setThistext(wtextfield.getText());
                    new WordCCounter(data).count();
                    new WordCShowCount(data,frame).showcount();
                }

            }
        });
        wpanel.add(wbutton);
        wbutton.setLayout(null);

        getContentPane().add(wpanel);
    }





}
