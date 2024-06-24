package com.example.ntierdemo.apis;

import com.example.ntierdemo.services.TicketService;
import com.example.ntierdemo.viewmodels.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tickets")
@Tag(name = "Ticket API", description = "RESTful API for ticket resource")
public class TicketApi {
    private final TicketService ticketService;

    public TicketApi(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<TicketViewModel>> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketViewModel> getById(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketViewModel> create(@Valid @RequestBody TicketCreateViewModel viewModel) {
        return ResponseEntity.ok(ticketService.create(viewModel));
    }

    @PutMapping("{id}")
    public ResponseEntity<TicketViewModel> update(@PathVariable int id, @Valid @RequestBody TicketUpdateViewModel viewModel) {
        return ResponseEntity.ok(ticketService.update(id, viewModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
