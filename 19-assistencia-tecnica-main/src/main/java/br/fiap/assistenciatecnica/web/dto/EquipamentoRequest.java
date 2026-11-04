package br.fiap.assistenciatecnica.web.dto;

public record EquipamentoRequest(

        Long idCliente,
        String tipo,
        String marca,
        String modelo,
        String numero_serie
        ){

    }

