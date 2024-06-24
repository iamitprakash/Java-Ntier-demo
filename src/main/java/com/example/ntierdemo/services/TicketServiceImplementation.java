package com.example.ntierdemo.services;

import com.example.ntierdemo.exceptions.RecordNotFoundException;
import com.example.ntierdemo.models.Customer;
import com.example.ntierdemo.models.Ticket;
import com.example.ntierdemo.repositories.CustomerRepository;
import com.example.ntierdemo.repositories.TicketRepository;
import com.example.ntierdemo.viewmodels.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketServiceImplementation implements TicketService {

    private final TicketRepository ticketRepository;
    private final CustomerRepository customerRepository;

    public TicketServiceImplementation(TicketRepository ticketRepository, CustomerRepository customerRepository, CustomerRepository customerRepository1) {
        this.ticketRepository = ticketRepository;
        this.customerRepository = customerRepository1;
    }

    @Override
    public List<TicketViewModel> getAll() {
        return ticketRepository.findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public TicketViewModel getById(int id) {
        return toViewModel(getTicketById(id));
    }

    @Override
    public TicketViewModel create(TicketCreateViewModel viewModel) {
        return toViewModel(ticketRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public TicketViewModel update(int id, TicketUpdateViewModel viewModel) {
        Ticket entity = getTicketById(id);

        BeanUtils.copyProperties(viewModel, entity);

        return toViewModel(ticketRepository.saveAndFlush(entity));
    }

    @Override
    public void deleteById(int id) {
        Ticket entity = getTicketById(id);
        ticketRepository.delete(entity);
    }

    private Ticket getTicketById(int id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                                String.format("Could not find the ticket with id: %d", id)
                        )
                );
    }

    private Customer getMasterEntityById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                                String.format("Could not find the customer with id: %d", id)
                        )
                );
    }

    private TicketViewModel toViewModel(Ticket entity) {
        TicketViewModel viewModel = new TicketViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        viewModel.setCustomer(toCustomerViewModel(entity.getCustomer()));
        return viewModel;
    }

    private CustomerViewModel toCustomerViewModel(Customer entity) {
        CustomerViewModel viewModel = new CustomerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private Ticket toEntity(TicketCreateViewModel viewModel) {
        Ticket entity = new Ticket();
        BeanUtils.copyProperties(viewModel, entity);
        entity.setCustomer(getMasterEntityById(viewModel.getCustomerId()));
        return entity;
    }
}
