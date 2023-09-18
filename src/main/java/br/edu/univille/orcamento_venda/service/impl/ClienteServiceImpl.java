package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.orcamento_venda.entity.Cliente;
import br.edu.univille.orcamento_venda.repository.ClienteRepository;
import br.edu.univille.orcamento_venda.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

}
