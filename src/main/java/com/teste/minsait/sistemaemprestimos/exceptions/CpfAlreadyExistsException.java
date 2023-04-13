package com.teste.minsait.sistemaemprestimos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CpfAlreadyExistsException extends Exception{

    private final long serialVersionUID = 2L;
    public CpfAlreadyExistsException(String cpf) {
        super(String.format("O CPF %s já esta cadastrado.", cpf));
    }
}
