package br.fiap.assistenciatecnica.web.dto;

public record ClienteRequest(
        String nome,
        String email,
        String telefone,
        String senha
) {
}
