package model.actions;

public interface Reader<T> {
    public T read(String path);
    public void write(T data);
}
