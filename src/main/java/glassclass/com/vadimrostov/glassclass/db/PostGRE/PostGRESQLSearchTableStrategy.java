package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBSearchTableMakerStrategy;

/**
 * Created by Vad on 14.09.2016.
 */
public class PostGRESQLSearchTableStrategy implements DBSearchTableMakerStrategy {
    @Override
    public String[][] execute(Object frame) {

        return new PostGRESearchTableMaker((PostGREDataHandler) frame).searchtc();

    }
}
