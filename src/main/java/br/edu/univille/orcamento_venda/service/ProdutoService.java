package br.edu.univille.orcamento_venda.service;

import java.util.List;

import br.edu.univille.orcamento_venda.entity.Produto;

public interface ProdutoService {
    List<Produto> getAll();

    void save(Produto produto);

    void delete(Produto produto);
}
