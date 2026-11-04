package br.fiap.assistenciatecnica.mapper;

import br.fiap.assistenciatecnica.domain.Cliente;
import br.fiap.assistenciatecnica.web.dto.ClienteRequest;
import br.fiap.assistenciatecnica.web.dto.ClienteResponse;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    public Cliente paraEntidade(ClienteRequest dto) {
        Cliente cliente = new Cliente();
        cliente.setEmail(dto.email());
        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setSenha(dto.senha());
        return cliente;
    }

    public ClienteResponse paraResposta(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }

}
