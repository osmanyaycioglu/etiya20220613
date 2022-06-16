package com.training.lambdas.java.usage;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Predicate;

public class Soldier {
    private Predicate<Integer> shootingBehavior;
    private Predicate<Long> dodgeBehavior;

    public Soldier(Predicate<Integer> shootingBehavior,
                   Predicate<Long> dodgeBehavior) {
        this.shootingBehavior = shootingBehavior;
        this.dodgeBehavior = dodgeBehavior;
    }

    public void shoot(int range) {
        Random random = new SecureRandom();
        if (random.nextInt(10) > 8) {
            System.out.println("Vurdum");
            return;
        }
        if (shootingBehavior.test(range)) {
            System.out.println("Vurdum");
            return;
        }
        System.out.println("Vuramadım");
    }

    public void dodge(long start,
                      long duration) {
        if (dodgeBehavior.test(start)) {
            System.out.println("kurtuldum");
        }

    }
}
