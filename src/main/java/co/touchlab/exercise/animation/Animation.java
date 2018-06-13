package co.touchlab.exercise.animation;

import co.touchlab.exercise.model.Actor;

public abstract class Animation {
    public Actor actor;
    public int gridHeight;
    public int gridWith;

    public Animation(Actor actor, int gridHeight, int gridWith) {
        this.actor = actor;
        this.gridHeight = gridHeight;
        this.gridWith = gridWith;
    }

    public abstract void animate(int frame);
}
