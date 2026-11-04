package br.fiap.assistenciatecnica.web.dto;

import java.time.LocalDate;


    public record EquipamentoResponse(
            Long id,
            String tipo,
            String marca,
            String modelo,
            String numero_serie,
            LocalDate dataCadastro,
            Long idCliente,
            String nomeCliente
    ) {
    }

