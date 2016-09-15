package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

/**
 * Created by Vad on 15.09.2016.
 */
public class PostGREDataHandler {
    PostGREFrame frame;

    public PostGREDataHandler(PostGREFrame frame) {
        this.frame = frame;
    }

    private String pgredbname,  pgrelogin, pgrepassword, pgretablename,changename, ln, fn, pn,  str;
    private int postgreportn, lastnamesearch, sn, delid, sernum, age, house;;
    private double room;
    private String[] k = new String[]{"id", "ln", "fn", "pn", "age", "str", "h", "r"};

    public String[] getK() {
        return k;
    }

    public void setK(String[] k) {
        this.k = k;
    }

    public void setPgredbname(String pgredbname) {
        this.pgredbname = pgredbname;
    }

    public void setPgrelogin(String pgrelogin) {
        this.pgrelogin = pgrelogin;
    }

    public void setPgrepassword(String pgrepassword) {
        this.pgrepassword = pgrepassword;
    }

    public void setPgretablename(String pgretablename) {
        this.pgretablename = pgretablename;
    }

    public void setChangename(String changename) {
        this.changename = changename;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setPostgreportn(int postgreportn) {
        this.postgreportn = postgreportn;
    }

    public void setLastnamesearch(int lastnamesearch) {
        this.lastnamesearch = lastnamesearch;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public void setDelid(int delid) {
        this.delid = delid;
    }

    public void setSernum(int sernum) {
        this.sernum = sernum;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setRoom(double room) {
        this.room = room;
    }

    public String getPgredbname() {
        return pgredbname;
    }

    public String getPgrelogin() {
        return pgrelogin;
    }

    public String getPgrepassword() {
        return pgrepassword;
    }

    public String getPgretablename() {
        return pgretablename;
    }

    public String getChangename() {
        return changename;
    }

    public String getLn() {
        return ln;
    }

    public String getFn() {
        return fn;
    }

    public String getPn() {
        return pn;
    }

    public String getStr() {
        return str;
    }

    public int getPostgreportn() {
        return postgreportn;
    }

    public int getLastnamesearch() {
        return lastnamesearch;
    }

    public int getSn() {
        return sn;
    }

    public int getDelid() {
        return delid;
    }

    public int getSernum() {
        return sernum;
    }

    public int getAge() {
        return age;
    }

    public int getHouse() {
        return house;
    }

    public double getRoom() {
        return room;
    }
}
