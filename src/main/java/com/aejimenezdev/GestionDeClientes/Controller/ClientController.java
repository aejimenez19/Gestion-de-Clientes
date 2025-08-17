package com.aejimenezdev.GestionDeClientes.Controller;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import com.aejimenezdev.GestionDeClientes.Service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponseDto> saveClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        ClientResponseDto savedClient = clientService.saveClient(clientRequestDto);
        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }
}
