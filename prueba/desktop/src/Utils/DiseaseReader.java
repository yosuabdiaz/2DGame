package Utils;

import com.google.gson.*;
import model.Disease;
import model.actions.Reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DiseaseReader implements Reader<Disease> {
    @Override
    public Disease read(String path) {
        try {
            File file = new File(path);
            BufferedReader br
                    = new BufferedReader(new FileReader(file));


            Gson gson = new Gson();
            Disease Disease = gson.fromJson(br, Disease.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write(Disease data, String path) {
        File file = new File(path);
        Gson gson = new Gson();
        BufferedWriter br
                = new BufferedWriter(new FileReader(file));

    }
}
