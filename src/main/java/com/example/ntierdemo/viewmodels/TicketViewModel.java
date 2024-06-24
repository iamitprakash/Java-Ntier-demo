package com.example.ntierdemo.viewmodels;

import java.time.LocalDate;

public class TicketViewModel {

    private int ticketId;
    private LocalDate purchasedOn;
    private LocalDate dueOn;
    private double price;
    private int customerId;
    private CustomerViewModel customer;

    public CustomerViewModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerViewModel customer) {
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
