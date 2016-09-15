package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

import main.java.glassclass.com.vadimrostov.glassclass.db.*;
import main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE.PostGRESearchTableMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vad on 13.09.2016.
 */
public class MySQLFrame extends JFrame{

    MySQLFrame frame=this;
    JButton tablemsql, mysqladd, mysqltable, dbconnectbutton, manualadd, manualupdate, delete;
    JScrollPane tabpane;
    JPanel buttonpanel, tablepanel, manualaddpanel, panel, opbutpanel, manualupdatepanel, deletepanel;
    JTable  restable;
    Component setvis;

    MySQLDataHandler data = new MySQLDataHandler(frame);




    public MySQLFrame() throws HeadlessException {
        super("MYSQL");
        this.setSize(1600, 800);
        this.setVisible(true);

        this.createUI();
    }








    private void createButPan(){


        buttonpanel = new JPanel();
        buttonpanel.setLayout(null);
        buttonpanel.setBounds(0,0,800,60);
        panel.add(buttonpanel);

        dbconnectbutton = new JButton("Connect 2 DB");
        dbconnectbutton.setBounds(0,0,200,20);
        dbconnectbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DBConnectorFrame dbcframe=new DBConnectorFrame(data);
                tablemsql.setVisible(true);

            }
        });
        buttonpanel.add(dbconnectbutton);

        tablemsql=new JButton("Choose table");
        tablemsql.setBounds(0,30,200,20);
        tablemsql.setVisible(false);
        tablemsql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBTableFrame dbtable = new DBTableFrame(data);
                mysqladd.setVisible(true);

            }
        });
        buttonpanel.add(tablemsql);

        mysqladd=new JButton("AddExcel");
        mysqladd.setBounds(200,0,200,20);
        mysqladd.setVisible(false);
        mysqladd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBAdd con = new DBAdd(data);
                con.setStrategy(new MySQLAddStrategy());
                con.executeStrategy();
                mysqltable.setVisible(true);
            }
        });
        buttonpanel.add(mysqladd);

        mysqltable = new JButton("make table");
        mysqltable.setBounds(200, 30, 200, 20);
        mysqltable.setVisible(false);
        mysqltable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                restable=new JTable(new MySQLStrArrMaker(data).createStrAr(), data.getK());
                restable.setAutoCreateRowSorter(true);
                createTabPan();
                opbutpanel.setVisible(true);


            }
        });
        buttonpanel.add(mysqltable);

        getContentPane().add(panel);
    }

    private void createOpButPanel(){
        opbutpanel = new JPanel();
        opbutpanel.setLayout(null);
        opbutpanel.setBounds(850,0,400,60);
        opbutpanel.setVisible(false);


        manualadd = new JButton("Manual Add");
        manualadd.setBounds(0,0,200, 20);
        manualadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setvis.setVisible(false);
                manualaddpanel.setVisible(true);
                setvis=manualaddpanel;


            }
        });
        opbutpanel.add(manualadd);

        manualupdate = new JButton("Change LN");
        manualupdate.setBounds(200,0,200, 20);
        manualupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setvis.setVisible(false);
                manualupdatepanel.setVisible(true);
                setvis=manualupdatepanel;

            }
        });
        opbutpanel.add(manualupdate);

        delete = new JButton("DeleteRow");
        delete.setBounds(0,30,200, 20);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setvis.setVisible(false);
                deletepanel.setVisible(true);
                setvis=deletepanel;

            }
        });
        opbutpanel.add(delete);
        panel.add(opbutpanel);

    }

    private void createManUpdPanel(){
        manualupdatepanel=new JPanel(null);
        manualupdatepanel.setBounds(850,70,400,400);

        JLabel lnl = new JLabel("City Code");
        lnl.setBounds(0,0,100,20);
        manualupdatepanel.add(lnl);

        JTextField lntf = new JTextField();
        lntf.setBounds(100,0,100,20);
        manualupdatepanel.add(lntf);

        JLabel newlnl=new JLabel("New LastName");
        newlnl.setBounds(0,30,100,20);
        JTextField newln = new JTextField();
        newln.setBounds(100,30,100,20);
        JButton  newlnb = new JButton("Change LN");
        newlnb.setBounds(200,30,100,20);
        newlnb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Ok"};
                try{
                if(!lntf.getText().isEmpty()&&!newln.getText().isEmpty()){
                data.setSernum(Integer.parseInt(lntf.getText()));
                data.setChangename(newln.getText());
                DBUpdate cont=new DBUpdate(data);
                cont.setStrategy(new MySQLUpdateStrategy());
                cont.executeStrategy();
                tabpane.setViewportView(restable=new JTable(new MySQLStrArrMaker(data).createStrAr(),data.getK()));}
                else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null,options,
                        options[0]);}
                catch (NumberFormatException nfe){
                    JOptionPane.showOptionDialog(frame, "Неправильный формат ячейки", nfe.toString(), JOptionPane.NO_OPTION, 0, null,options,
                            options[0]);
                }


            }
        });

        manualupdatepanel.add(newlnl);
        manualupdatepanel.add(newln);
        manualupdatepanel.add(newlnb);

        manualupdatepanel.setVisible(false);

        panel.add(manualupdatepanel);


    }

    private void createManAddPanel(){

        manualaddpanel=new JPanel();
        manualaddpanel.setBounds(850,70,400,400);
        manualaddpanel.setLayout(null);




        JLabel lnl = new JLabel("LN");
        lnl.setBounds(0,0,70,20);
        manualaddpanel.add(lnl);
        JLabel fnl = new JLabel("FN");
        fnl.setBounds(0,30,70,20);
        manualaddpanel.add(fnl);
        JLabel al = new JLabel("Adress");
        al.setBounds(0,60,70,20);
        manualaddpanel.add(al);
        JLabel cl = new JLabel("City");
        cl.setBounds(0,90,70,20);
        manualaddpanel.add(cl);

        JTextField lntf=new JTextField();
        lntf.setBounds(70,0,100,20);
        manualaddpanel.add(lntf);

        JTextField fntf=new JTextField();
        fntf.setBounds(70,30,100,20);
        manualaddpanel.add(fntf);

        JTextField atf=new JTextField();
        atf.setBounds(70,60,100,20);
        manualaddpanel.add(atf);

        JTextField ctf=new JTextField();
        ctf.setBounds(70,90,100,20);
        manualaddpanel.add(ctf);

        JButton insertbut = new JButton("Apply");
        insertbut.setBounds(170,90,80,20);
        insertbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{Object[] options={"Ok"};
                if(!lntf.getText().isEmpty()&&!fntf.getText().isEmpty()&&!atf.getText().isEmpty()&&!ctf.getText().isEmpty()) {
                    data.setLn(lntf.getText());
                    data.setFn(fntf.getText());
                    data.setAdr(atf.getText());
                    data.setCity(ctf.getText());
                    new MySQLManualInsert(data).manualinsert();
                    tablepanel.remove(tabpane);

                    tabpane.setViewportView(restable = new JTable(new MySQLStrArrMaker(data).createStrAr(), data.getK()));
                    restable.setAutoCreateRowSorter(true);
                    tabpane.setBounds(0, 0, 800, 600);
                    tablepanel.add(tabpane);
                }
                else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );}
                catch (NumberFormatException nfe){
                    Object[] options={"Ok"};
                    JOptionPane.showOptionDialog(frame, "Неправильный формат ячейки", nfe.toString(), JOptionPane.NO_OPTION, 0, null,options,
                            options[0]);
                }







            }
        });
        manualaddpanel.add(insertbut);
        manualaddpanel.setVisible(false);


        panel.add(manualaddpanel);

    }

    private void createDeleteRowPanel(){
        deletepanel=new JPanel(null);
        deletepanel.setBounds(850,70,400,400);
        deletepanel.setVisible(false);

        JLabel lnl = new JLabel("Id");
        lnl.setBounds(0,0,100,20);
        deletepanel.add(lnl);

        JTextField lntf = new JTextField();
        lntf.setBounds(100,0,100,20);
        deletepanel.add(lntf);

        JButton delb=new JButton("Delete Row");
        delb.setBounds(200,0,100,20);
        delb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options={"Ok"};
                try{
                if(!lntf.getText().isEmpty()){
                data.setDelid(Integer.parseInt(lntf.getText()));
                new MySQLDeleteRow(data).deleteRow();
                tabpane.setViewportView(new JTable(new MySQLStrArrMaker(data).createStrAr(),data.getK()));}
                else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );}
                catch (NumberFormatException nfe){
                    JOptionPane.showOptionDialog(frame, "Неправильный формат ячейки", nfe.toString(), JOptionPane.NO_OPTION, 0, null,options,
                            options[0]);
                }

            }
        });
        deletepanel.add(delb);

        panel.add(deletepanel);

    }

    private void createTabPan(){
        tablepanel=new JPanel();
        tablepanel.setLayout(null);
        tablepanel.setBounds(0,60,800,700);
        panel.add(tablepanel);

        tabpane=new JScrollPane(restable);
        tabpane.setBounds(0,0,800,600);
        tablepanel.add(tabpane);

    }

    private void createUI(){
        panel = new JPanel();
        panel.setLayout(null);

        createButPan();
        createOpButPanel();
        createManAddPanel();
        createManUpdPanel();
        createDeleteRowPanel();
        setvis=new JPanel();










        getContentPane().add(panel);

    }


}
