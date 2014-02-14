package com.a13.control;

/**
 * Created by riblee on 2014.02.14..
 */
public class Main {
    public static void main(String[] args) {
        Robot robot= new Robot("http://www.ipon.hu");
        robot.startRobot(3, 0);
        System.out.println(robot.getSet());
        System.out.println(robot.getSet().size());
        System.out.println("vége");
    }
}
