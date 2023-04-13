package com.teste.minsait.sistemaemprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.minsait.sistemaemprestimos.entity.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    Optional<Cliente> findByCpf(String cpf);
}
