package com.example.ntierdemo.services;

import com.example.ntierdemo.viewmodels.*;

import java.util.List;

public interface TicketService {

    List<TicketViewModel> getAll();
    TicketViewModel getById(int id);
    TicketViewModel create(TicketCreateViewModel viewModel);
    TicketViewModel update(int id, TicketUpdateViewModel viewModel);
    void deleteById(int id);
}
