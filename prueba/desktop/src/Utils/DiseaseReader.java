package Utils;

import com.google.gson.*;
import model.Disease;
import model.ReadWrite;

import java.io.*;

public class DiseaseReader implements ReadWrite<Disease> {
    @Override
    public Disease read(String path) {
        try {
            File file = new File(path);
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            return  gson.fromJson(br, Disease.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void write(Disease data, String path) {

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
