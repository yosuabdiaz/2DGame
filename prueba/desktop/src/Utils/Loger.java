package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loger {

    private Loger instance;

    public Loger getInstance(){
        instance = (instance == null)? new Loger():instance;
        return instance;
    }

    public void log(String event){
        Date now = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String log = dateFormat.format(now);
        log += " -" + event;

    }
}
