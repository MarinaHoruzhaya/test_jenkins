package com.example.tests.patterns.factoryMethod;

public class DivButton implements Button {
    @Override
    public void click() {
        System.out.println("клик по кнопке с div");
    }

    @Override
    public void doubleClick() {
        System.out.println("Двойной клик по div кнопке");
    }
}
