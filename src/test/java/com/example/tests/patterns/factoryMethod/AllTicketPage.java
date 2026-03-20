package com.example.tests.patterns.factoryMethod;

public class AllTicketPage extends Page {
    @Override
    protected Button createButton() {
        return new InputButton();
    }
}
