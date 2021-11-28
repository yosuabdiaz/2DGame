package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Configuration;
import model.ReadWrite;

import java.io.*;

public class ConfigurationReader implements ReadWrite<Configuration> {

    @Override
    public Configuration read(String path) {
        try {
            File file = new File(path+ path +  "game.config");
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            return gson.fromJson(br, Configuration.class);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void write(Configuration data, String path) {
        File file = new File(path +  "game.config");
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
