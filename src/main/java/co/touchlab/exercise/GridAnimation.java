package co.touchlab.exercise;

import co.touchlab.exercise.animation.*;
import co.touchlab.exercise.model.Actor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GridAnimation {
    public static void main(String[] args) {
        if (args.length == 4) {
            printArguments(args);
        } else {
            System.out.println("Incorrect arguments");
        }
    }

    private static void printArguments(String[] args) {
        System.out.println("========Arguments========");
        System.out.println("Actors File     : " + args[0]);
        System.out.println("Width           : " + args[1]);
        System.out.println("Height          : " + args[2]);
        System.out.println("Number of frames: " + args[3]);
        System.out.println("=========================");
        int numberOfFrames = Integer.parseInt(args[3]);
        int gridHeight = Integer.parseInt(args[2]);
        int gridWidth = Integer.parseInt(args[1]);
        String filename = args[0];
        List<Animation> animations=getAnimationFromFile(filename,gridHeight,gridWidth);
        for (int i = 0; i < numberOfFrames; i++) {
            for(Animation animation:animations){
                animation.animate(i);
            }
        }
    }

    public static Animation getAnimationFromDescription(Actor actor, String animationDescription, int gridHeight, int gridWith) {
        switch (animationDescription) {
            case "L":
                return new LineAnimation(actor, gridHeight, gridWith);
            case "R":
                return new RandomAnimation(actor, gridHeight, gridWith);
            case "S":
                return new StillAnimation(actor, gridHeight, gridWith);
            case "VL":
                return new VeerLeftAnimation(actor, gridHeight, gridWith);
            case "VR":
                return new VeerRightAnimation(actor, gridHeight, gridWith);
        }
        return null;
    }

    public static List<Animation> getAnimationFromFile(String fileName, int height, int width) {
        List<Animation> animations = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                String[] actorArgument = line.split(",");
                if (actorArgument[0].equals("R")) {
                    Actor actor = new Actor(actorArgument[0], 0, 0, 0);
                    Animation animation = getAnimationFromDescription(actor, actorArgument[0], height, width);
                    if (animation != null) {
                        animations.add(animation);
                    }
                } else if (actorArgument[0].equals("S")) {
                    int row = Integer.parseInt(actorArgument[1]);
                    int column = Integer.parseInt(actorArgument[2]);
                    Actor actor = new Actor(actorArgument[0], row, column, 0);
                    Animation animation = getAnimationFromDescription(actor, actorArgument[0], height, width);
                    if (animation != null) {
                        animations.add(animation);
                    }
                } else {
                    int row = Integer.parseInt(actorArgument[1]);
                    int column = Integer.parseInt(actorArgument[2]);
                    int direction = Integer.parseInt(actorArgument[3]);
                    Actor actor = new Actor(actorArgument[0], row, column, direction);
                    Animation animation = getAnimationFromDescription(actor, actorArgument[0], height, width);
                    if (animation != null) {
                        animations.add(animation);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animations;
    }

}
