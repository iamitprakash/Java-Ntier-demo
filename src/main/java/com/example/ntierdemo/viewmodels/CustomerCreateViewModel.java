package com.example.ntierdemo.viewmodels;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerCreateViewModel {
    @NotBlank(message = "Cannot accept null, empty, or whitespace for first name")
    @Size(min = 5, max = 50, message = "First name should be in the range of [5-50] characters")
    private String firstName;

    private String lastName;

    @Email
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
