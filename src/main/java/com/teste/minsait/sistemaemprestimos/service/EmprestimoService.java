package com.teste.minsait.sistemaemprestimos.service;

import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import com.teste.minsait.sistemaemprestimos.entity.Emprestimo;
import com.teste.minsait.sistemaemprestimos.exceptions.ClienteNotFoundException;
import com.teste.minsait.sistemaemprestimos.exceptions.EmprestimoNotFoundException;
import com.teste.minsait.sistemaemprestimos.exceptions.EmprestimoValorUltrapassadoException;
import com.teste.minsait.sistemaemprestimos.repository.ClienteRepository;
import com.teste.minsait.sistemaemprestimos.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo, String cpfCliente) throws ClienteNotFoundException, EmprestimoValorUltrapassadoException {
        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpfCliente);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            BigDecimal maximo = BigDecimal.TEN;
            BigDecimal rendimentoMensalTotal = cliente.getRendimentoMensal().multiply(maximo);

            List<Emprestimo> emprestimosCliente = emprestimoRepository.findByCpfCliente(cliente);
            BigDecimal quantidadeEmprestimos = new BigDecimal(emprestimosCliente.size());
            BigDecimal valorInicialTotal = emprestimo.getValorInicial().add(quantidadeEmprestimos.multiply(emprestimo.getValorInicial()));

            if (valorInicialTotal.compareTo(rendimentoMensalTotal) > 0) {
                throw new EmprestimoValorUltrapassadoException(valorInicialTotal, rendimentoMensalTotal);
            }

            emprestimo.setValorFinal(emprestimo.getRelacionamento().calculoValorFinal(emprestimo.getValorInicial(), quantidadeEmprestimos));
            emprestimo.setCliente(cliente);
            return emprestimoRepository.save(emprestimo);
        } else {
            throw new ClienteNotFoundException("Cliente não encontrado para o CPF: " + cpfCliente);
        }
    }

    public List<Emprestimo> buscarEmprestimos(String cpfCliente) throws ClienteNotFoundException {

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpfCliente);

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return emprestimoRepository.findByCpfCliente(cliente);
        }

        throw new ClienteNotFoundException(cpfCliente);
    }

    public Emprestimo buscarEmprestimosPorId(String cpfCliente, Long id) throws ClienteNotFoundException, EmprestimoNotFoundException{

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(cpfCliente);

        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);

            if(emprestimoOptional.isPresent()) {
                return emprestimoOptional.get();
            } else {
                throw new EmprestimoNotFoundException(id);
            }

        } else {
            throw new ClienteNotFoundException(cpfCliente);
        }
    }
    public MensagemSucesso deletarEmprestimo(String cpfCliente, Long Id) throws ClienteNotFoundException, EmprestimoNotFoundException {
        if(clienteRepository.existsByCpf(cpfCliente)){

        if (this.emprestimoRepository.existsById(Id)) {
            emprestimoRepository.deleteById(Id);

            MensagemSucesso mensagem = new MensagemSucesso();
            mensagem.setMensagem("Empréstimo deletado com sucesso!");
            return mensagem;
        } else {
            throw new EmprestimoNotFoundException(Id);
        }
    }
        throw new ClienteNotFoundException(cpfCliente);
    }
}