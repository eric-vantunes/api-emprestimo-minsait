package com.teste.minsait.sistemaemprestimos.repository;

import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import com.teste.minsait.sistemaemprestimos.entity.Emprestimo;

import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Optional<Emprestimo> findByCpfClienteAndId(Long id, Cliente cpfCliente);
    List<Emprestimo> findByCpfCliente(Cliente cpfCliente);
}
