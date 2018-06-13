package co.touchlab.exercise.util;

import co.touchlab.exercise.model.Actor;

import java.util.Random;

public class Movement {
    private Actor mActor;
    private int direction;
    private int gridHeight;
    private int gridWidth;

    public Movement(Actor actor, int gridHeight, int gridWidth) {
        mActor = actor;
        this.direction = actor.getDirection();
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
    }

    public void move( int pace) {
        switch (direction) {
            case 0:
                moveUp(pace);
                break;
            case 1:
                if (moveUp(pace)) {
                   moveRight(pace);
                }
                break;
            case 2:
                moveRight(pace);
                break;
            case 3:
                if(moveDown(pace)){
                    moveRight(pace);
                }
                break;
            case 4:
                moveDown(pace);
                break;
            case 5:
                if(moveDown(pace)){
                    moveLeft(pace);
                }
                break;
            case 6:
                moveLeft(pace);
                break;
            case 7:
                if(moveUp(pace)){
                    moveLeft(pace);
                }



        }
    }
    public boolean moveUp(int pace){
        if ((mActor.getRow()+pace) < gridHeight) {
            int newRow = mActor.getRow() + pace;
            mActor.setRow(newRow);
            return true;
        }
        return false;
    }
    public boolean moveDown(int pace){
        if ((mActor.getRow()-pace) >= 0) {
            int newRow = mActor.getRow() - pace;
            mActor.setRow(newRow);
            return true;
        }
        return false;
    }
    public boolean moveRight(int pace) {
        if ((mActor.getColumn()+pace) < gridWidth) {
            int newColumn = mActor.getColumn() + pace;
            mActor.setColumn(newColumn);
            return true;
        }
        return false;
    }
    public boolean moveLeft(int pace) {
        if ((mActor.getColumn()-pace) >= 0) {
            int newColumn = mActor.getColumn() - pace;
            mActor.setColumn(newColumn);
            return true;
        }
        return false;
    }
    public void moveRandomly(){
        Random random=new Random();
        int column=random.nextInt(gridWidth);
        int row=random.nextInt(gridHeight);
        mActor.setColumn(column);
        mActor.setRow(row);

    }
}
