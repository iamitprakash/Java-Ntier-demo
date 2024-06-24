package com.example.ntierdemo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private LocalDate purchasedOn;
    private LocalDate dueOn;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", updatable = false, insertable = false)
    private Customer customer;
    private int customerId;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDate getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(LocalDate purchasedOn) {
        this.purchasedOn = purchasedOn;
    }

    public LocalDate getDueOn() {
        return dueOn;
    }

    public void setDueOn(LocalDate dueOn) {
        this.dueOn = dueOn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
