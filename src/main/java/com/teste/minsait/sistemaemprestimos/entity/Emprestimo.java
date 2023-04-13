package com.teste.minsait.sistemaemprestimos.entity;

import com.teste.minsait.sistemaemprestimos.tipos.RelacionamentoEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")// anotação
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cpf_cliente")
    private Cliente cpfCliente;
    @NotNull
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    @NotNull
    private LocalDate dataInicial;
    @NotNull
    private LocalDate dataFinal;
    @NotNull
    private RelacionamentoEnum relacionamento;

    public Emprestimo() {

    }

    public Emprestimo(Long id, BigDecimal valorInicial, BigDecimal valorFinal, RelacionamentoEnum relacionamento, LocalDate dataInicial, LocalDate dataFinal) {
        super();
        this.id = id;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.relacionamento = relacionamento;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Cliente cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal){
        this.valorFinal = valorFinal;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public RelacionamentoEnum getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(RelacionamentoEnum relacionamento) {
        this.relacionamento = relacionamento;
    }

    public Cliente getCliente() {
        return cpfCliente;
    }


    public void setCliente(Cliente cliente) {
        this.cpfCliente = cliente;
    }
}
