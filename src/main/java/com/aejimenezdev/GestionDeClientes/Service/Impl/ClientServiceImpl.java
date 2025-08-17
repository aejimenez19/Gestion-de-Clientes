package com.aejimenezdev.GestionDeClientes.Service.Impl;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import com.aejimenezdev.GestionDeClientes.Mapper.ClientMapper;
import com.aejimenezdev.GestionDeClientes.Model.ClientModel;
import com.aejimenezdev.GestionDeClientes.Repository.ClientRepository;
import com.aejimenezdev.GestionDeClientes.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        ClientModel client = clientMapper.toClientModel(clientRequestDto);
        ClientModel savedClient = clientRepository.save(client);
        return clientMapper.toClientResponse(savedClient);
    }
}
