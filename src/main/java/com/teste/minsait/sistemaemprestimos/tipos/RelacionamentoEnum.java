package com.teste.minsait.sistemaemprestimos.tipos;

import java.math.BigDecimal;
import java.math.MathContext;

public enum RelacionamentoEnum {

    BRONZE(1){
        @Override
        public BigDecimal calculoValorFinal(BigDecimal valorInicial, BigDecimal quantidadeEmprestimos){
            BigDecimal calculo = new BigDecimal("1.80");
            BigDecimal valorFinal = valorInicial.multiply(calculo);
            return valorFinal;
        }
    },
    PRATA(2){
        @Override
        public BigDecimal calculoValorFinal(BigDecimal valorInicial, BigDecimal quantidadeEmprestimos) {
//            BigDecimal valueCompareTo = new BigDecimal("5000");
            if(valorInicial.compareTo(new BigDecimal("5000")) == 1 ) {
                BigDecimal calculo = new BigDecimal("1.40");
                BigDecimal valorFinal = calculo.multiply(valorInicial, MathContext.DECIMAL32);
                return valorFinal;
            }
            BigDecimal calculo = new BigDecimal("1.60");
            BigDecimal valorFinal = calculo.multiply(valorInicial, MathContext.DECIMAL32);
            return valorFinal;
        }
    },
    OURO(3) {
        @Override
        public BigDecimal calculoValorFinal(BigDecimal valorInicial, BigDecimal quantidadeEmprestimos) {
            if (quantidadeEmprestimos.compareTo(new BigDecimal(1)) == -1) {
                BigDecimal calculo = new BigDecimal("1.20");
                BigDecimal valorFinal = calculo.multiply(valorInicial, MathContext.DECIMAL32);
                return valorFinal;
            }
            BigDecimal calculo = new BigDecimal("1.30");
            BigDecimal valorFinal = calculo.multiply(valorInicial, MathContext.DECIMAL32);
            return valorFinal;
            }
        };
        private int id;

        RelacionamentoEnum(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public abstract BigDecimal calculoValorFinal(BigDecimal valorInicial, BigDecimal quantidadeEmprestimos);

    }
