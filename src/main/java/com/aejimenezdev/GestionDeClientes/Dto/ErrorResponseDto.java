package com.aejimenezdev.GestionDeClientes.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private Map<String, String> errors;
}
