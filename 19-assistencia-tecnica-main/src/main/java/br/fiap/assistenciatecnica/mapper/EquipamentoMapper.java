package br.fiap.assistenciatecnica.mapper;

import br.fiap.assistenciatecnica.domain.Equipamento;
import br.fiap.assistenciatecnica.web.dto.EquipamentoRequest;
import br.fiap.assistenciatecnica.web.dto.EquipamentoResponse;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {
    public Equipamento paraEntidade(EquipamentoRequest dto) {
        Equipamento equipamento = new Equipamento();
        equipamento.setTipo(dto.tipo());
        equipamento.setMarca(dto.marca());
        equipamento.setModelo(dto.modelo());
        equipamento.setNumero_serie(dto.numero_serie());

        return equipamento;
    }

    public EquipamentoResponse paraResposta(Equipamento equipamento) {
        return new EquipamentoResponse(
                equipamento.getId(),
                equipamento.getTipo(),
                equipamento.getMarca(),
                equipamento.getModelo(),
                equipamento.getNumero_serie(),
                equipamento.getDataCadastro(),
                equipamento.getCliente().getId(),
                equipamento.getCliente().getNome());
    }
}
