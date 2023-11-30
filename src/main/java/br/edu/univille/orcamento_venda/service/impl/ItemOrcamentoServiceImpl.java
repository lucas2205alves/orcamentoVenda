package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.univille.orcamento_venda.entity.ItemOrcamento;
import br.edu.univille.orcamento_venda.repository.ItemOrcamentoRepository;
import br.edu.univille.orcamento_venda.service.ItemOrcamentoService;

@Service
public class ItemOrcamentoServiceImpl implements ItemOrcamentoService{

     @Autowired
    private ItemOrcamentoRepository repository;

    @Override
    public List<ItemOrcamento> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(ItemOrcamento itemOrcamento) {
        repository.save(itemOrcamento);
    }

    @Override
    public void delete(ItemOrcamento itemOrcamento) {
        repository.delete(itemOrcamento);
    }
    
}
