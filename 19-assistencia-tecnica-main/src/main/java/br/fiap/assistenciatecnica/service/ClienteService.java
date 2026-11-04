package br.fiap.assistenciatecnica.service;

import br.fiap.assistenciatecnica.config.SenhaConfig;
import br.fiap.assistenciatecnica.domain.Cliente;
import br.fiap.assistenciatecnica.mapper.ClienteMapper;
import br.fiap.assistenciatecnica.repository.ClienteRepository;
import br.fiap.assistenciatecnica.web.dto.ClienteRequest;
import br.fiap.assistenciatecnica.web.dto.ClienteResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    private final ClienteMapper mapper;
    private final SenhaConfig senhaConfig;

    public ClienteService(ClienteRepository repo,
                          ClienteMapper mapper,
                          SenhaConfig senhaConfig) {
        this.repo = repo;
        this.mapper = mapper;
        this.senhaConfig = senhaConfig;
    }

    public ClienteResponse salvar(ClienteRequest dto) {
        String hash = senhaConfig.passwordEncoder().encode(dto.senha());
        Cliente cliente = mapper.paraEntidade(dto);
        cliente.setSenha(hash);
        Cliente aux = repo.save(cliente);
        return mapper.paraResposta(cliente);
    }

    public ClienteResponse pesquisar(Long id) {
        Cliente cliente = repo.findById(id).orElseThrow();
        return mapper.paraResposta(cliente);
    }

    public List<ClienteResponse> listar() {
        return repo.findAll().stream()
                .map(cliente -> mapper.paraResposta(cliente))
                .toList();
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    @Transactional
    public ClienteResponse atualizar(Long id, ClienteRequest dto) {
        Cliente cliente = repo.findById(id).orElseThrow();
        cliente.setEmail(dto.email());
        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setSenha(dto.senha());
        return mapper.paraResposta(cliente);
    }

    public ClienteResponse pesquisarPorEmail(String email) {
        Cliente cliente = repo.findClienteByEmail(email).orElseThrow();
        return mapper.paraResposta(cliente);
    }

}
