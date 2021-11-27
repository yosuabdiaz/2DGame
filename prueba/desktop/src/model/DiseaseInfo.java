package model;

public class


DiseaseInfo {
    int point;
    boolean up;

    public DiseaseInfo(int point, boolean up) {
        this.point = point;
        this.up = up;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
