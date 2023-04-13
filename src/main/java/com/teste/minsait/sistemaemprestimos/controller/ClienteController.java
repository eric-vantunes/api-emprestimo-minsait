package com.teste.minsait.sistemaemprestimos.controller;

import com.teste.minsait.sistemaemprestimos.DTO.ClienteDTO;
import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import com.teste.minsait.sistemaemprestimos.exceptions.*;
import com.teste.minsait.sistemaemprestimos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sistema-emprestimos/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> cadastrarCliente(@Valid @RequestBody Cliente cliente) throws CpfAlreadyExistsException {
        Cliente clienteCadastrado;
        clienteCadastrado = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(clienteCadastrado));
    }
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clientesDTO.add(new ClienteDTO(cliente));
        }
        return ResponseEntity.ok(clientesDTO);
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpf) throws ClienteNotFoundException {
        Cliente cliente = clienteService.buscarClientePorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable String cpf, @Valid @RequestBody Cliente clienteDTO) throws ClienteNotFoundException {
        Cliente cliente = clienteService.atualizarCliente(cpf, clienteDTO);
        return ResponseEntity.ok().body(new ClienteDTO(cliente));
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String cpf) throws ClienteNotFoundException {
        clienteService.deletarCliente(cpf);
        return ResponseEntity.noContent().build();
    }
}




