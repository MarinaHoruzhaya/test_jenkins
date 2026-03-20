package com.example.tests.patterns.factoryMethod;

public class TestFactory {
    public static void main(String[] args) {
        Page webPage = new MyTicketPage();
        System.out.println("=== Рендерим WebPage ===");
        webPage.renderPage();

        System.out.println("\n=== Рендерим MobilePage ===");
        Page mobilePage = new AllTicketPage();
        mobilePage.renderPage();
    }
}
