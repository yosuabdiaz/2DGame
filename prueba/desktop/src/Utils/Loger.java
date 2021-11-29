package Utils;

import model.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loger {

    private static Loger instance;

    public static Loger getInstance(){
        instance = (instance == null)? new Loger():instance;
        return instance;
    }

    public void log(String event){
        Date now = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        String log = dateFormat.format(now);
        log += " -" + event;
        FileWriter fw = null;BufferedWriter bw = null;PrintWriter pw = null;
        try {
            fw = new FileWriter(Configuration.getInstance().getLogPath() + "log.txt" , true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(log);

        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            pw.close();
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
