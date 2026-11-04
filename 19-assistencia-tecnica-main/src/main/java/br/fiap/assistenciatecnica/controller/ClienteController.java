package br.fiap.assistenciatecnica.controller;

import br.fiap.assistenciatecnica.domain.Equipamento;
import br.fiap.assistenciatecnica.service.ClienteService;
import br.fiap.assistenciatecnica.service.EquipamentoService;
import br.fiap.assistenciatecnica.web.dto.ClienteRequest;
import br.fiap.assistenciatecnica.web.dto.ClienteResponse;
import br.fiap.assistenciatecnica.web.dto.EquipamentoResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService service;
    private final EquipamentoService equipamentoService;

    public ClienteController(ClienteService service, EquipamentoService equipamentoService) {
        this.service = service;
        this.equipamentoService = equipamentoService;
    }

    @PostMapping("/salvar")
    public ClienteResponse salvar(@RequestBody ClienteRequest dto) {
        return service.salvar(dto);
    }

    @GetMapping("/pesquisar/{id}")
    public ClienteResponse pesquisar(@PathVariable Long id) {
        return service.pesquisar(id);
    }

    @GetMapping("/listar")
    public List<ClienteResponse> listar() {
        return service.listar();
    }

    @GetMapping("/deletar/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping("/atualizar/{id}")
    public ClienteResponse atualizar(@PathVariable Long id,
                                     @RequestBody ClienteRequest dto) {
        return service.atualizar(id, dto);
    }

    @GetMapping("/pesquisar-email/{email}")
    public ClienteResponse pesquisarPorEmail(@PathVariable String email) {
        return service.pesquisarPorEmail(email);
    }

    @GetMapping ("id/{id}equipamento")
    public List <EquipamentoResponse> listaPorCliente (@PathVariable Long id){
        return  equipamentoService.listarPorCliente(id);
    }
}
