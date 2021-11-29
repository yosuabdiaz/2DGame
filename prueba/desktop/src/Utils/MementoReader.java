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
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            LinkedList<Memento> data = (LinkedList<Memento>)objectIn.readObject();
            objectIn.close();
            return data;

        } catch (Exception ex) {
            System.out.println("ERROR DEL MEMENTO");
            return null;
        }
    }

    @Override
    public void write(Object data, String path) {
        try {

            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
