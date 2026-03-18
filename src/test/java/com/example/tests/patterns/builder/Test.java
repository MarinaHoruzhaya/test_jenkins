package com.example.tests.patterns.builder;

public class Test {
    public static void main(String[] args) {
        Ticket ticket1 = new TicketBuilder()
                .setNumber(1233)
                .setAccount("1111")
                .setClient("Хоружая М. С.")
                .setDate("10.10.2026")
                .build();

        Ticket ticket2 = new TicketBuilder()
                .setType("Новая")
                .build();

        System.out.println(ticket1);
        System.out.println(ticket2);
    }

}
