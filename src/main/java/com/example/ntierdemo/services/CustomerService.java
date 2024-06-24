package com.example.ntierdemo.services;

import com.example.ntierdemo.viewmodels.CustomerCreateViewModel;
import com.example.ntierdemo.viewmodels.CustomerUpdateViewModel;
import com.example.ntierdemo.viewmodels.CustomerViewModel;

import java.util.List;

public interface CustomerService {
    List<CustomerViewModel> getAll();
    CustomerViewModel getById(int id);
    CustomerViewModel create(CustomerCreateViewModel viewModel);
    CustomerViewModel update(int id, CustomerUpdateViewModel viewModel);
    void deleteById(int id);
}
