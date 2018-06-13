package co.touchlab.exercise.animation;

import co.touchlab.exercise.model.Actor;
import co.touchlab.exercise.util.Movement;

public class LineAnimation extends Animation {
    public LineAnimation(Actor actor, int height, int width) {
        super(actor,height,width);
    }

    @Override
    public void animate(int frame) {
        String output = frame +","+ actor.toString();
        System.out.println(output);
        Movement movement=new Movement(actor,gridHeight,gridWith);
        movement.move(1);

    }
}
