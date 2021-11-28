package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Disease;
import model.Medicine;
import model.ReadWrite;

import java.io.*;

public class MedicineReader implements ReadWrite<Medicine> {

    @Override
    public Medicine read(String path) {
        try {
            File file = new File(path  + ".json");
            BufferedReader br
                    = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            return  gson.fromJson(br, Medicine.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public void write(Medicine data, String path) {
        File file = new File(path + data.getName() + ".json");
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
