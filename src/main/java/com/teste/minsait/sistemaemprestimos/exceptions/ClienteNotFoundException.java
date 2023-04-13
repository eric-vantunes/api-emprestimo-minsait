package com.teste.minsait.sistemaemprestimos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;
    public ClienteNotFoundException(String cpf) {
        super(String.format("Cliente com CPF %s não encontrado"));
    }
}
