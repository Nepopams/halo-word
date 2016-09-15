package main.java.glassclass.com.vadimrostov.glassclass.WordC;

/**
 * Created by Vad on 15.09.2016.
 */
public class WordCCounter {
    WordCDataHandler dataHandler;

    public WordCCounter(WordCDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public void count(){
        String s=dataHandler.getThistext();
        String[] ss=s.split(" ");



        for (int i=0; i<ss.length;i++){
            String si=ss[i];
            Integer l=dataHandler.getWmap().get(si);

            if (l==null){
                dataHandler.getWmap().put(si,1);
            }
            else {
                int j=dataHandler.getWmap().get(si)+1;
                dataHandler.getWmap().put(si, j);
            }



        }

    }
}
