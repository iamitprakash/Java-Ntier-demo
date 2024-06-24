package com.example.ntierdemo.viewmodels;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerUpdateViewModel {
    @NotBlank(message = "Cannot accept null, empty, or whitespace for first name")
    @Size(min = 5, max = 50, message = "First name should be in the range of [5-50] characters")
    private String firstName;
    private String lastName;

    @NotBlank
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
