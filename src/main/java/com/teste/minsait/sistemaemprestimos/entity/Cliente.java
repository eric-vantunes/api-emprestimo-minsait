package com.teste.minsait.sistemaemprestimos.entity;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CPF(message = "CPF Inválido")
    @NotBlank
    @NotNull(message = "CPF não pode ser vazio")
    private String cpf;
    @NotBlank
    private String nome;
    @NotNull
    private String telefone;
    @NotBlank
    private String rua;
    @NotNull
    @Range(min = 0)
    private int numero;
    @NotNull
    @Range(min = 0)
    private String cep;
    @NotNull
    @Range(min = 0)
    private BigDecimal rendimentoMensal;

    //construtor padrão
    public Cliente() {

    }

    public Cliente(String nome, String rua, int numero, String cep, String cpf, String telefone, BigDecimal rendimentoMensal)
    {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.telefone = telefone;
        this.rendimentoMensal = rendimentoMensal;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
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

    public BigDecimal getRendimentoMensal() {
        return rendimentoMensal;
    }

    public void setRendimentoMensal(BigDecimal rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }

}
