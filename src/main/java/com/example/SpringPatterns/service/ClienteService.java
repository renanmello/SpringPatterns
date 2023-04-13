package com.example.SpringPatterns.service;

import com.example.SpringPatterns.model.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService {

    Iterable<Cliente> buscartodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);


}
