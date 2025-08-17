package com.aejimenezdev.GestionDeClientes.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Long id;
    private String name;
    private String email;
}
