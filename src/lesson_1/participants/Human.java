package lesson_1.participants;

import lesson_1.Jump;
import lesson_1.Run;

public class Human implements Jump, Run {

    String name;
    int runCapacity;
    double jumpCapacity;

    public Human (String name, int runCapacity, double jumpCapacity){
        this.name = name;
        this.runCapacity = runCapacity;
        this.jumpCapacity = jumpCapacity;
    }

    public String getName(){
        return name;
    }

    public void getInfo() {

        System.out.println("My name is " + name + "! I can run about " + runCapacity + " meters and jump about " + jumpCapacity);
    }

    @Override
    public boolean jump(double height) {

        return jumpCapacity >= height;

    }

    @Override
    public boolean run(int distance) {

        return runCapacity >= distance;

    }

}
