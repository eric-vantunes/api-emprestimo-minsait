package com.teste.minsait.sistemaemprestimos.exceptions;

import java.math.BigDecimal;
public class EmprestimoValorUltrapassadoException extends Exception{
    private static final long serialVersionUID = 4L;

    public EmprestimoValorUltrapassadoException(BigDecimal valorInicialTotal, BigDecimal rendimentoMensalTotal){
        super(String.format("A soma total do valor inicial, ultrapassou o equivalente a 10 vezes o rendimento mensal, que é %s"));
    }
}
