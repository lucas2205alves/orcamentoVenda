package br.edu.univille.orcamento_venda.service;

import java.util.List;

import br.edu.univille.orcamento_venda.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();

    void save(Cliente cliente);

    void delete(Cliente cliente);
}
