package com.example.tests.patterns.factoryMethod;

public class MyTicketPage extends Page{
    @Override
    protected Button createButton() {
        return new DivButton();
    }
}
