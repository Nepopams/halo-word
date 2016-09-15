package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;


import main.java.glassclass.com.vadimrostov.glassclass.db.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Vad on 09.09.2016.
 */
public class PostGREFrame extends JFrame {


    JPanel panel, butpanel,  tablepanel, opbutpanel, manualaddpanel, manualupdatepanel, deletepanel;
    JScrollPane tabpane;
    PostGREFrame frame = this;
    JButton postgretab, manualadd, manualupdate, delete;
    JButton postgretable;
    JButton postgretabbut;

    JTable restable;




    Component setvis;

    PostGREDataHandler dataHandler=new PostGREDataHandler(frame);








    public PostGREFrame() throws HeadlessException {
        super("PostGRE");
        this.setSize(1600, 1000);
        this.setVisible(true);

        this.createUI();
    }



    private void createButPanel(){
        butpanel=new JPanel(null);
        butpanel.setBounds(0,0,800, 60);

        panel.add(butpanel);


        JButton postgrecbut = new JButton("Connect 2 DB");
        postgrecbut.setBounds(0, 0, 200, 20);
        postgrecbut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBConnectorFrame dbcframe=new DBConnectorFrame(dataHandler);
                postgretable.setVisible(true);
            }
        });
        butpanel.add(postgrecbut);


        this.postgretable = new JButton("Choose DB Table name");
        this.postgretable.setBounds(0, 30, 200, 20);
        this.postgretable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DBTableFrame(dataHandler);
                postgretab.setVisible(true);
            }
        });
        this.postgretable.setVisible(false);
        butpanel.add(this.postgretable);

        this.postgretab = new JButton("InsertExcelTable");
        this.postgretab.setBounds(200, 0, 200, 20);
        postgretab.setVisible(false);
        this.postgretab.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    DBAdd con = new DBAdd(dataHandler);
                    con.setStrategy(new PostGRESQLAddStrategy());
                    con.executeStrategy();
                    PostGREFrame.this.postgretabbut.setVisible(true);
                    PostGREFrame.this.getContentPane().add(panel);


            }
        });
        butpanel.add(this.postgretab);


        this.postgretabbut = new JButton("pgre tab");
        this.postgretabbut.setBounds(200, 30, 200, 20);
        this.postgretabbut.setVisible(false);
        this.postgretabbut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    restable = new JTable(strarraystr(), dataHandler.getK());
                    restable.setAutoCreateRowSorter(true);
                    createTabPanel();
                    opbutpanel.setVisible(true);



            }
        });
        butpanel.add(this.postgretabbut);
    }

    private void createTabPanel(){
        tablepanel=new JPanel();
        tablepanel.setLayout(null);
        tablepanel.setBounds(0,60,1000,700);
        panel.add(tablepanel);

        tabpane=new JScrollPane(restable);
        tabpane.setBounds(0,0,1000,600);
        tablepanel.add(tabpane);
    }

    private void createOpButPanel(){
        opbutpanel = new JPanel();
        opbutpanel.setLayout(null);
        opbutpanel.setBounds(1050,0,400,60);
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
        manualupdatepanel.setBounds(1050,70,400,400);

        JLabel lnl = new JLabel("Id");
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
                    dataHandler.setSernum(Integer.parseInt(lntf.getText()));
                dataHandler.setChangename(newln.getText());
                DBUpdate cont=new DBUpdate(dataHandler);
                cont.setStrategy(new PostGREUpdateStrategy());
                cont.executeStrategy();
                tabpane.setViewportView(restable=new JTable(new PostGreStrArrayMaker(dataHandler).createStrAr(),dataHandler.getK()));}
                    else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null,options,
                            options[0]);

                    }
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
        manualaddpanel.setBounds(1050,70,400,400);
        manualaddpanel.setLayout(null);




        JLabel lnl = new JLabel("LN");
        lnl.setBounds(0,0,70,20);
        manualaddpanel.add(lnl);
        JLabel fnl = new JLabel("FN");
        fnl.setBounds(0,30,70,20);
        manualaddpanel.add(fnl);
        JLabel pnl = new JLabel("PN");
        pnl.setBounds(0,60,70,20);
        manualaddpanel.add(pnl);
        JLabel cl = new JLabel("Age");
        cl.setBounds(0,90,70,20);
        manualaddpanel.add(cl);

        JLabel sl = new JLabel("Street");
        sl.setBounds(0,120,70,20);
        manualaddpanel.add(sl);

        JLabel hl = new JLabel("House");
        hl.setBounds(0,150,70,20);
        manualaddpanel.add(hl);

        JLabel rl = new JLabel("Room");
        rl.setBounds(0,180,70,20);
        manualaddpanel.add(rl);


        JTextField lntf=new JTextField();
        lntf.setBounds(70,0,100,20);
        manualaddpanel.add(lntf);

        JTextField fntf=new JTextField();
        fntf.setBounds(70,30,100,20);
        manualaddpanel.add(fntf);

        JTextField pntf=new JTextField();
        pntf.setBounds(70,60,100,20);
        manualaddpanel.add(pntf);

        JTextField atf=new JTextField();
        atf.setBounds(70,90,100,20);
        manualaddpanel.add(atf);

        JTextField stf=new JTextField();
        stf.setBounds(70,120,100,20);
        manualaddpanel.add(stf);

        JTextField htf=new JTextField();
        htf.setBounds(70,150,100,20);
        manualaddpanel.add(htf);

        JTextField rtf=new JTextField();
        rtf.setBounds(70,180,100,20);
        manualaddpanel.add(rtf);

        JButton insertbut = new JButton("Apply");
        insertbut.setBounds(170,180,80,20);
        insertbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Object[] options={"Ok"};
                    if(!lntf.getText().isEmpty()&&!fntf.getText().isEmpty()&&!pntf.getText().isEmpty()&&!atf.getText().isEmpty()&&!stf.getText().isEmpty()&&!htf.getText().isEmpty()&&!htf.getText().isEmpty()&&!rtf.getText().isEmpty()){
                    dataHandler.setLn(lntf.getText());
                    dataHandler.setFn(fntf.getText());
                    dataHandler.setPn(pntf.getText());
                    dataHandler.setAge(Integer.parseInt(atf.getText()));
                    dataHandler.setStr(stf.getText());
                    dataHandler.setHouse(Integer.parseInt(htf.getText()));
                    dataHandler.setRoom(Double.parseDouble(rtf.getText()));


                    new PostGRESQLManualInsert(dataHandler).manualinsert();
                    tablepanel.remove(tabpane);

                    tabpane.setViewportView(restable = new JTable(new PostGreStrArrayMaker(dataHandler).createStrAr(), dataHandler.getK()));
                    restable.setAutoCreateRowSorter(true);
                    tablepanel.add(tabpane);}
                    else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );
                }
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
        deletepanel.setBounds(1050,70,400,400);
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
                dataHandler.setDelid(Integer.parseInt(lntf.getText()));
                new PostGREDeleteRow(dataHandler).deleteRow();
                tabpane.setViewportView(new JTable(new PostGreStrArrayMaker(dataHandler).createStrAr(),dataHandler.getK()));}
                else JOptionPane.showOptionDialog(frame, "Не все поля заполнены", "NAF", JOptionPane.NO_OPTION, 0, null, options, options[0] );
                }

                catch (NumberFormatException nfe){
                    JOptionPane.showOptionDialog(frame, "Неправильный формат ячейки", nfe.toString(), JOptionPane.NO_OPTION, 0, null,options,
                            options[0]);
                }

            }
        });
        deletepanel.add(delb);

        panel.add(deletepanel);

    }

    private void createUI() {
        panel = new JPanel(null);
        panel.setBounds(0,0,1600,1000);


        createButPanel();
        createOpButPanel();
        createManAddPanel();
        createManUpdPanel();
        createDeleteRowPanel();
        setvis=new JPanel();





        this.getContentPane().add(panel);
    }


    private String[][] strarraystr(){
        DBStrArrayMaker cont=new DBStrArrayMaker(dataHandler);
        cont.setStrategy(new PostGRESQLStrArrayStrategy());

        return cont.execute();


    }

}
