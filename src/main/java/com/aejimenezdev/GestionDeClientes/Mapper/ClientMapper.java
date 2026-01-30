package com.aejimenezdev.GestionDeClientes.Mapper;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import com.aejimenezdev.GestionDeClientes.Model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientResponseDto toClientResponseDto(ClientModel clientModel) {
        return ClientResponseDto.builder()
                .id(clientModel.getId())
                .email(clientModel.getEmail())
                .name(clientModel.getName())
                .build();
    }

    public ClientModel toClientModel(ClientRequestDto clientRequestDto) {
        return ClientModel.builder()
                .email(clientRequestDto.getEmail())
                .name(clientRequestDto.getName())
                .password(clientRequestDto.getPassword())
                .build();
    }
}
