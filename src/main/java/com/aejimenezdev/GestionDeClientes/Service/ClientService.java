package com.aejimenezdev.GestionDeClientes.Service;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;

public interface ClientService {
    ClientResponseDto saveClient(ClientRequestDto clientRequestDto);

    ClientResponseDto getClientById(Long id);
}
