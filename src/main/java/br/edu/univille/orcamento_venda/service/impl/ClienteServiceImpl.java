package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.univille.orcamento_venda.entity.Cliente;
import br.edu.univille.orcamento_venda.repository.ClienteRepository;
import br.edu.univille.orcamento_venda.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

}
