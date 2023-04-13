package com.teste.minsait.sistemaemprestimos.DTO;
import com.teste.minsait.sistemaemprestimos.entity.Cliente;
import com.teste.minsait.sistemaemprestimos.entity.Emprestimo;
import com.teste.minsait.sistemaemprestimos.tipos.RelacionamentoEnum;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EmprestimoDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_cpf")
    private Cliente cpfCliente;
    @NotNull(message = "Valor não pode ser vazio")
    private BigDecimal valorInicial;
    private BigDecimal valorFinal;
    @NotNull(message = "Data não pode ser vazio")
    private LocalDate dataInicial;
    @NotNull(message = "Data não pode ser vazio")
    private LocalDate dataFinal;
    @NotNull(message = "Relacionamento não pode ser vazio")
    private RelacionamentoEnum relacionamento;

    public EmprestimoDTO(Long id, BigDecimal valorInicial, RelacionamentoEnum relacionamento, BigDecimal valorFinal, LocalDate dataInicial, LocalDate dataFinal) {
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

    public Cliente getCliente() {

        return cpfCliente;
    }

    public void setCliente(Cliente cliente){
        this.cpfCliente = cliente;
    }
    public BigDecimal getValorInicial() {

        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {

        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal(){
        return valorFinal;
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

}
