package main.java.glassclass.com.vadimrostov.glassclass;

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
        mailBut.addActionListener(new MailButListener());
        panel.add(mailBut);
        mailBut.setLayout(null);

        JButton wordBut = new JButton("Word count");
        wordBut.setBounds(110, 5, 100, 20);
        wordBut.addActionListener(new WordButListener());
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
        //  setPreferredSize(new Dimension(320, 100));

    }
    public class MailButListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MailV mframe = new MailV();
            mframe.setSize(450,200);
            mframe.setLocationRelativeTo(null);
            mframe.setVisible(true);
            // JFrame.setDefaultLookAndFeelDecorated(true);

        }

    }
    class MailV extends JFrame{
        private JTextField mtextfield;
        JPanel mpanel;
        JLabel mlabel;
        public MailV() throws HeadlessException {
            super("Mail validator");
            createmUi();
        }

        public void createmUi(){



            mpanel = new JPanel();
            mpanel.setLayout(new FlowLayout());
            panel.setLayout(null);

            JButton vbutton = new JButton("Push da TEMPA");
            vbutton.addActionListener(new BListener());
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
            //setPreferredSize(new Dimension(320, 100));

        }


        public class BListener implements ActionListener{


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
        }


    }

    public class WordButListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            WordC wframe = new WordC();
            wframe.setSize(450,500);
            wframe.setLocationRelativeTo(null);
            wframe.setVisible(true);
            //JFrame.setDefaultLookAndFeelDecorated(true);
        }
    }

    class WordC extends JFrame{
        private HashMap<String, Integer> wmap = new HashMap();


        JPanel wpanel;
        JTextField wtextfield;
        JTextArea wcarea;

        public WordC(){
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
            wbutton.addActionListener(new WCBListener());
            wpanel.add(wbutton);
            wbutton.setLayout(null);

            getContentPane().add(wpanel);
        }

        public void count(){
            String s =wtextfield.getText();
            String[] ss=s.split(" ");



            for (int i=0; i<ss.length;i++){
                String si=ss[i];
                Integer l=wmap.get(si);

                if (l==null){
                    wmap.put(si,1);
                }
                else {
                    int j=wmap.get(si)+1;
                    wmap.put(si, j);
                }



            }

        }
        public void showcount(){
            String wc="";
            for (Map.Entry<String, Integer> pair : wmap.entrySet())
            {
                String key = pair.getKey();
                int val = wmap.get(pair.getKey());
                wc=wc+(key+" = "+val+"\n");
            }
            wcarea.setText(wc);

        }

        public class WCBListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wtextfield.getText().isEmpty()){
                    wcarea.setText("введите текст");
                }
                else {
                    count();
                    showcount();}


            }
        }

    }



    public static void main(String[] args){
        JFrame.setDefaultLookAndFeelDecorated(true);
        GlassClass frame = new GlassClass();
        frame.setSize(450, 900);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
