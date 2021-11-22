package model;

public class Memento {
    Player player;
    Storage storage;

    public Memento(Player player, Storage storage){
        this.player = player;
        this.storage = storage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
