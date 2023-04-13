package com.example.SpringPatterns.service.impl;

import com.example.SpringPatterns.model.Cliente;
import com.example.SpringPatterns.model.ClienteRepository;
import com.example.SpringPatterns.model.Endereco;
import com.example.SpringPatterns.model.EnderecoRepository;
import com.example.SpringPatterns.service.ClienteService;
import com.example.SpringPatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository endrepo;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscartodos() {

        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {

        Optional<Cliente> cliente =  repository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);


    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clientedb  = repository.findById(id);
        if(clientedb.isPresent()){
            salvarClienteComCep(cliente);
        }

    }
    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = endrepo.findById(cep).orElseGet(()->{
            Endereco novo = viaCepService.consultarCep(cep);
            endrepo.save(novo);
            return novo;
        });
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }



}
