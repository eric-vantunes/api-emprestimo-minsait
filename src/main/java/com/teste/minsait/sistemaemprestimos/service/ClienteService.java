package com.teste.minsait.sistemaemprestimos.service;

import com.teste.minsait.sistemaemprestimos.DTO.ClienteDTO;
import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import com.teste.minsait.sistemaemprestimos.exceptions.*;
import com.teste.minsait.sistemaemprestimos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) throws ClienteNotFoundException {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com o CPF: "));
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return this.clienteRepository.findAll();
    }

    public Cliente atualizarCliente(String cpf, @Valid Cliente cliente) throws ClienteNotFoundException {
        if (this.clienteRepository.existsByCpf(cpf)) {
            Cliente clienteAtualizado = this.clienteRepository.findByCpf(cpf).get();
            if (cliente.getCpf() != null) {
                clienteAtualizado.setCpf(cliente.getCpf());
            }
            if (cliente.getNome() != null) {
                clienteAtualizado.setNome(cliente.getNome());
            }
            if (cliente.getTelefone() != null) {
                clienteAtualizado.setTelefone(cliente.getTelefone());
            }
            if (cliente.getRua() != null) {
                clienteAtualizado.setRua(cliente.getRua());
            }
            if (cliente.getNumero() != 0) {
                clienteAtualizado.setNumero(cliente.getNumero());
            }
            if (cliente.getCep() != null) {
                clienteAtualizado.setCep(cliente.getCep());
            }
            if (cliente.getRendimentoMensal() != null) {
                clienteAtualizado.setRendimentoMensal(cliente.getRendimentoMensal());
            }

            return clienteRepository.save(clienteAtualizado);
        }
        throw new ClienteNotFoundException(cpf);
    }

    public void deletarCliente (String cpf) throws ClienteNotFoundException {
            Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpf);
            if (!clienteOptional.isPresent()) {
                throw new ClienteNotFoundException(cpf);
            }
            clienteRepository.delete(clienteOptional.get());
        }
    }


