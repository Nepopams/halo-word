package main.java.glassclass.com.vadimrostov.glassclass.db.PostGRE;

import main.java.glassclass.com.vadimrostov.glassclass.db.DBStrArrayStrategy;

/**
 * Created by Vad on 14.09.2016.
 */
public class PostGRESQLStrArrayStrategy implements DBStrArrayStrategy {

    @Override
    public String[][] execute(Object frame) {
        PostGREDataHandler postGREFrame=(PostGREDataHandler) frame;
        return new PostGreStrArrayMaker(postGREFrame).createStrAr();

    }
}
