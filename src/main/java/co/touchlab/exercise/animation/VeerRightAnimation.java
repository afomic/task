package co.touchlab.exercise.animation;

import co.touchlab.exercise.model.Actor;

public class VeerRightAnimation extends Animation {
    public VeerRightAnimation(Actor actor, int height, int width) {
        super(actor,height,width);
    }

    @Override
    public void animate(int frame) {
        String output = frame +","+ actor.toString();
        System.out.println(output);
    }
}
