package main.java.glassclass.com.vadimrostov.glassclass.db.MySQL;

/**
 * Created by Vad on 15.09.2016.
 */
public class MySQLDataHandler {
    private String mysqldbname,mysqllogin,mysqlpassword, mysqltablename, ln,fn,adr, city, changename;
    private int mysqlportn, delid, sernum;
    MySQLFrame frame;

    public MySQLDataHandler(MySQLFrame frame) {
        this.frame = frame;
    }

    private String[] k = new String[]{"id", "ln", "fn", "adress", "city"};

    public String getMysqldbname() {
        return mysqldbname;
    }

    public String getMysqllogin() {
        return mysqllogin;
    }

    public String getMysqlpassword() {
        return mysqlpassword;
    }

    public String getMysqltablename() {
        return mysqltablename;
    }

    public int getMysqlportn() {
        return mysqlportn;
    }

    public int getDelid() {
        return delid;
    }

    public String getLn() {
        return ln;
    }

    public String getFn() {
        return fn;
    }

    public String getAdr() {
        return adr;
    }

    public String getCity() {
        return city;
    }

    public String getChangename() {
        return changename;
    }

    public int getSernum() {
        return sernum;
    }

    public String[] getK() {
        return k;
    }

    public void setMysqldbname(String mysqldbname) {
        this.mysqldbname = mysqldbname;
    }

    public void setMysqllogin(String mysqllogin) {
        this.mysqllogin = mysqllogin;
    }

    public void setMysqlpassword(String mysqlpassword) {
        this.mysqlpassword = mysqlpassword;
    }

    public void setMysqltablename(String mysqltablename) {
        this.mysqltablename = mysqltablename;
    }

    public void setMysqlportn(int mysqlportn) {
        this.mysqlportn = mysqlportn;
    }

    public void setDelid(int delid) {
        this.delid = delid;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setChangename(String changename) {
        this.changename = changename;
    }

    public void setSernum(int sernum) {
        this.sernum = sernum;
    }

    public void setK(String[] k) {
        this.k = k;
    }
}
