package br.fiap.assistenciatecnica.web.dto;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone
) {
}
