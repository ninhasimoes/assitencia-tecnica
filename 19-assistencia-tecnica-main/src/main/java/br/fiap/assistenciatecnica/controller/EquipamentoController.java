package br.fiap.assistenciatecnica.controller;

import br.fiap.assistenciatecnica.service.ClienteService;
import br.fiap.assistenciatecnica.web.dto.ClienteRequest;
import br.fiap.assistenciatecnica.web.dto.ClienteResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private final ClienteService service;
    public EquipamentoController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/salvar")
    public ClienteResponse salvar(@RequestBody ClienteRequest dto) {
        return service.salvar(dto);
    }
}
