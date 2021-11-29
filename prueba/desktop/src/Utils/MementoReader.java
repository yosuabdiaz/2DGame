package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Medicine;
import model.Memento;
import model.ReadWrite;

import java.io.*;
import java.util.LinkedList;

public class MementoReader implements ReadWrite {
    @Override
    public LinkedList<Memento> read(String path) {
        try {
            File file = new File(path);
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            return  gson.fromJson(br ,new TypeToken<LinkedList<Memento>>(){}.getType());
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public void write(Object data, String path) {
        File file = new File(path);
        if(!file.exists()){
            File f = new File(file.getParentFile().getAbsolutePath());
            f.mkdirs();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(data);
        try {
            BufferedWriter br
                    = new BufferedWriter(new FileWriter(file));
            br.write(json);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
