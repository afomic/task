package co.touchlab.exercise.model;

import java.util.Locale;

public class Actor {
    private String type;
    private int row;
    private int column;
    private int direction;

    public Actor(String type, int row, int column, int direction) {
        this.type = type;
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH,"%s,%d,%d",type,row,column);
    }
}
