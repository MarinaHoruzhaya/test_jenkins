package com.example.tests.patterns.builder;

import java.util.Date;

public class Ticket {
    private String type;
    private int number;
    private String client;
    private String account;
    private String date;

    public Ticket(String type, int number, String client, String account, String date) {
        this.type = type;
        this.number = number;
        this.client = client;
        this.account = account;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type='" + type + '\'' +
                ", number=" + number +
                ", client='" + client + '\'' +
                ", account='" + account + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
