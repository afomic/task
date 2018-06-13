package co.touchlab.exercise.animation;

import co.touchlab.exercise.model.Actor;
import co.touchlab.exercise.util.Movement;

public class RandomAnimation extends Animation {
    public RandomAnimation(Actor actor, int height, int width) {
        super(actor,height,width);
    }


    @Override
    public void animate(int frame) {
        String output = frame +","+ actor.toString();
        System.out.println(output);
        Movement movement=new Movement(actor,gridHeight,gridWith);
        movement.moveRandomly();

    }
}
