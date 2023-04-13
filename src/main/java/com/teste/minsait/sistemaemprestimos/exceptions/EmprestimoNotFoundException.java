package com.teste.minsait.sistemaemprestimos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmprestimoNotFoundException extends Exception{

    private static final long serialVersionUID = 3L;

    public EmprestimoNotFoundException(Long id){
        super("Empréstimo não encontrado");
    }
}
