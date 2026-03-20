package com.example.tests.patterns.factoryMethod;

public abstract class Page {
    protected abstract Button createButton();
    // ← Общая логика, которая работает с Button, а не с DivButton или InputButton
    public void renderPage() {
        Button button = createButton(); // ← Здесь фабричный метод вызывается!
        button.doubleClick();
        button.click();
    }
}
