package br.edu.univille.orcamento_venda.service;

import java.util.List;

import br.edu.univille.orcamento_venda.entity.Orcamento;

public interface OrcamentoService {
    List<Orcamento> getAll();

    void save(Orcamento orcamento);

    void delete(Orcamento orcamento);
}
