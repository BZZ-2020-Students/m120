package dev.phillip.m133_autoscout;

public class Johannes {
    private static String[] nachnamen = {"Fuchs", "Bisig"};

    public static void say() {
        System.out.println("Mein Name ist Johannes " + nachnamen[(int) (Math.random() * 2)]);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            say();
        }
    }
}
