package br.edu.univille.orcamento_venda.service;

import java.util.List;

import br.edu.univille.orcamento_venda.entity.ItemOrcamento;

public interface ItemOrcamentoService {
    List<ItemOrcamento> getAll();

    void save(ItemOrcamento ItemOrcamento);

    void delete(ItemOrcamento ItemOrcamento);
    
}  