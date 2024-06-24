package com.example.ntierdemo.viewmodels;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TicketCreateViewModel {

    @NotNull(message = "Purchased on is required")
    private LocalDate purchasedOn;
    @NotNull(message = "Due on is required")
    private LocalDate dueOn;
    @Min(value = 0L, message = "The value must be positive")
    private double price;

    @Min(value = 0L, message = "The value must be positive")
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
