package com.aejimenezdev.GestionDeClientes.Service;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    ClientResponseDto saveClient(ClientRequestDto clientRequestDto);
    ClientResponseDto getClientById(Long id);
    Page<ClientResponseDto> getAllClients(Pageable pageable);
}
