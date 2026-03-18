package com.example.tests.patterns;

public class Singleton {
    private static Singleton instance;
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void setUp() {
        System.out.println("Вызывается один и тот же текст");
    }

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton.setUp();
        singleton2.setUp();
    }
}
