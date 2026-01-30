package com.aejimenezdev.GestionDeClientes.Mapper;

import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import com.aejimenezdev.GestionDeClientes.Model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapStructur {

    ClientResponseDto toClientResponse(ClientModel clientModel);

    ClientModel toClientModel(ClientRequestDto clientRequestDto);
}
