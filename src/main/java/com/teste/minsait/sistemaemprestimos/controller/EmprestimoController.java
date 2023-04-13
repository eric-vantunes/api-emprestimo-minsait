package com.teste.minsait.sistemaemprestimos.controller;
import com.teste.minsait.sistemaemprestimos.entity.Emprestimo;
import com.teste.minsait.sistemaemprestimos.exceptions.ClienteNotFoundException;
import com.teste.minsait.sistemaemprestimos.exceptions.EmprestimoNotFoundException;
import com.teste.minsait.sistemaemprestimos.exceptions.EmprestimoValorUltrapassadoException;
import com.teste.minsait.sistemaemprestimos.service.EmprestimoService;
import com.teste.minsait.sistemaemprestimos.service.MensagemSucesso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/sistema-emprestimos/clientes")
public class EmprestimoController {

    private EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/{cpfCliente}/emprestimos")
    public ResponseEntity<?> cadastrarEmprestimo(@RequestBody @Valid Emprestimo emprestimo, @PathVariable String cpfCliente) {
        try {
            Emprestimo novoEmprestimo = emprestimoService.cadastrarEmprestimo(emprestimo, cpfCliente);
            return ResponseEntity.ok(novoEmprestimo);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (EmprestimoValorUltrapassadoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{cpfCliente}/emprestimos")
    public ResponseEntity<?> buscarEmprestimos(@PathVariable String cpfCliente) {
        try {
            List<Emprestimo> emprestimos = emprestimoService.buscarEmprestimos(cpfCliente);
            return ResponseEntity.ok(emprestimos);
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{cpfCliente}/emprestimos/{id}")
    public ResponseEntity<?> buscarEmprestimoPorId(@PathVariable String cpfCliente, @PathVariable Long id) {
        try {
            Emprestimo emprestimo = emprestimoService.buscarEmprestimosPorId(cpfCliente, id);
            return ResponseEntity.ok(emprestimo);
        } catch (ClienteNotFoundException | EmprestimoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{cpfCliente}/emprestimos/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable String cpfCliente, @PathVariable Long id) {
        try {
            MensagemSucesso mensagem = emprestimoService.deletarEmprestimo(cpfCliente, id);
            return ResponseEntity.ok(mensagem);
        } catch (ClienteNotFoundException | EmprestimoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
