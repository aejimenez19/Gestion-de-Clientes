package com.aejimenezdev.GestionDeClientes.Service.Impl;

import com.aejimenezdev.GestionDeClientes.Dto.ClientFilterRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientRequestDto;
import com.aejimenezdev.GestionDeClientes.Dto.ClientResponseDto;
import com.aejimenezdev.GestionDeClientes.Exception.ClientException;
import com.aejimenezdev.GestionDeClientes.Exception.ClientNotFound;
import com.aejimenezdev.GestionDeClientes.Mapper.ClientMapper;
import com.aejimenezdev.GestionDeClientes.Model.ClientModel;
import com.aejimenezdev.GestionDeClientes.Repository.ClientRepository;
import com.aejimenezdev.GestionDeClientes.Service.ClientService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
        ClientModel client = clientMapper.toClientModel(clientRequestDto);
        ClientModel savedClient = clientRepository.save(client);
        return clientMapper.toClientResponseDto(savedClient);
    }

    @Override
    public ClientResponseDto getClientById(Long id) {
        ClientModel client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientException("Client not found with id: " + id));
        return clientMapper.toClientResponseDto(client);
    }

    @Override
    public Page<ClientResponseDto> getAllClients(Pageable pageable, ClientFilterRequestDto clientFilterRequestDto) {
        Specification<ClientModel> specs = (root, query, criteriaBuilder) -> {
            List<Predicate> specification = new ArrayList<>();


            if (clientFilterRequestDto.getName() != null && !clientFilterRequestDto.getName().isEmpty()) {
                specification.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + clientFilterRequestDto.getName().toLowerCase() + "%"
                        )
                );
            }

            if (clientFilterRequestDto.getEmail() != null && !clientFilterRequestDto.getEmail().isEmpty()) {
                specification.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("email")),
                                "%" + clientFilterRequestDto.getEmail().toLowerCase() + "%"
                        )
                );
            }

            if (clientFilterRequestDto.getInitDate() != null && clientFilterRequestDto.getEndDate() != null) {
                OffsetDateTime initDate = clientFilterRequestDto.getInitDate().atOffset(ZoneOffset.UTC);
                OffsetDateTime endDate = clientFilterRequestDto.getEndDate().atOffset(ZoneOffset.UTC);
                specification.add(
                        criteriaBuilder.between(
                                root.get("createdAt"),
                                initDate,
                                endDate
                        )
                );
            }

            return criteriaBuilder.and(specification.toArray(new Predicate[0]));
        };

        Page<ClientModel> clients = clientRepository.findAll(specs, pageable);
        return clients.map(clientMapper::toClientResponseDto);
    }

    @Override
    public ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto) {
        ClientModel client = clientRepository.findById(id)
                .orElseThrow(ClientNotFound::new);

        client.setName(clientRequestDto.getName());
        client.setEmail(clientRequestDto.getEmail());
        client.setPassword(clientRequestDto.getPassword());
        client.setUpdatedAt(OffsetDateTime.now());
        ClientModel updatedClient = clientRepository.save(client);
        return clientMapper.toClientResponseDto(updatedClient);
    }
}
