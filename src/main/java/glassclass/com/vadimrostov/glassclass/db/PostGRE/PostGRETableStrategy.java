package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBTableFrame;
import main.java.glassclass.com.vadimrostov.glassclass.db.TableStrategy;

/**
 * Created by Vad on 13.09.2016.
 */
public class PostGRETableStrategy implements TableStrategy{

    @Override
    public void execute(Object frame) {
        PostGREDataHandler fr=(PostGREDataHandler) frame;
        PostGRETable tab=new PostGRETable(fr);
        tab.createorconnect();

    }
}
