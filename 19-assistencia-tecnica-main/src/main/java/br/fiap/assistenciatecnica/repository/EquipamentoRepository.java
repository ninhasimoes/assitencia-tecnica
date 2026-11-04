package br.fiap.assistenciatecnica.repository;

import br.fiap.assistenciatecnica.domain.Cliente;
import br.fiap.assistenciatecnica.domain.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    List<Equipamento> findByClienteId(Long idCliente);
}
