package com.example.tests.patterns.factoryMethod;

public class InputButton implements Button{
    @Override
    public void click() {
        System.out.println("клик по input кнопке");
    }

    @Override
    public void doubleClick() {
        System.out.println(" двойной клик по input кнопке");
    }
}
