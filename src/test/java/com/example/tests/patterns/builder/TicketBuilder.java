package com.example.tests.patterns.builder;

import java.util.Date;

public class TicketBuilder {
    private String type;
    private int number;
    private String client;
    private String account;
    private String date;

    public TicketBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public TicketBuilder setNumber(int number) {
        this.number = number;
        return this;
    }

    public TicketBuilder setClient(String client) {
        this.client = client;
        return this;
    }

    public TicketBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public TicketBuilder setAccount(String account) {
        this.account = account;
        return this;
    }

    public Ticket build() {
        Ticket ticket = new Ticket(type, number, client, account, date);
        return ticket;
    }

}
