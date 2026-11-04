package br.fiap.assistenciatecnica.service;

import br.fiap.assistenciatecnica.domain.Cliente;
import br.fiap.assistenciatecnica.domain.Equipamento;
import br.fiap.assistenciatecnica.mapper.EquipamentoMapper;
import br.fiap.assistenciatecnica.repository.ClienteRepository;
import br.fiap.assistenciatecnica.repository.EquipamentoRepository;
import br.fiap.assistenciatecnica.web.dto.EquipamentoRequest;
import br.fiap.assistenciatecnica.web.dto.EquipamentoResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipamentoService {

    private final ClienteRepository clienteRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper mapper;

    @Transactional
    public EquipamentoResponse salvar(EquipamentoRequest dto) {
        Cliente cliente= clienteRepository.findById(dto.idCliente()).orElseThrow();
        Equipamento equipamento = mapper.paraEntidade(dto);
        equipamento.setCliente(cliente);
        equipamento.setDataCadastro(LocalDate.now());
        return mapper.paraResposta(equipamentoRepository.save(equipamento));
    }

    @Transactional
    public List<EquipamentoResponse> listarPorCliente(Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");   // cliente inexistente: 404
        }
        return equipamentoRepository.findByClienteId(idCliente).stream()
                .map(mapper::paraResposta)
                .toList();
    }

}
