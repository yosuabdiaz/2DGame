package model;

import java.util.ArrayList;

public interface ReadWrite<T> {
    public T read (String path);
    public void write(T data, String path);
}
