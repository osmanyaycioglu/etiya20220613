package com.training.lambdas.java.usage;

import java.security.SecureRandom;
import java.util.Random;

public class SoldierRun {
    public static void main(String[] args) {
        Soldier soldier = new Soldier(x -> x < 10,
                                      y -> y > 500);
        Soldier soldier2 = new Soldier(SoldierRun::sharpShooterBehavior,
                                       y -> y > 500);
        soldier2.shoot(30);
    }

    public static boolean sharpShooterBehavior(Integer x) {
        if (x < 10) {
            return true;
        }
        Random random = new SecureRandom();
        if (random.nextInt(100) > 30) {
            return true;
        }
        return false;
    }
}
