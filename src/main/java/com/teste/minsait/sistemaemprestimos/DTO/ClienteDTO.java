package com.teste.minsait.sistemaemprestimos.DTO;

import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ClienteDTO {
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank(message = "O nome do cliente não pode estar em branco")
    private String nome;
    @NotBlank(message = "O telefone do cliente não pode estar em branco")
    private String telefone;

    @NotBlank(message = "O nome da rua não pode estar em branco")
    private String rua;

    @NotNull(message = "O campo número não pode ser vazio")
    @Min(value = 1, message = "O número deve ser maior que zero")
    private int numero;

    @NotNull(message = "O campo cep não pode ser vazio")
    @Pattern(regexp = "^\\\\d{8}$", message = "O cep deve ter 8 dígitos")
    private String cep;

    @NotNull(message = "A renda mensal do cliente não pode estar vazia")
    @DecimalMin(value = "0.00", inclusive = false, message = "A renda mensal deve ser maior que zero")
    private BigDecimal rendaMensal;

    public ClienteDTO(Cliente cliente) {
        nome = cliente.getNome();
        cpf = cliente.getCpf();
        telefone = cliente.getTelefone();
        rua = cliente.getRua();
        numero = cliente.getNumero();
        cep = cliente.getCep();
        rendaMensal = cliente.getRendimentoMensal();

    }
    public ClienteDTO(){
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public BigDecimal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(BigDecimal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

}
