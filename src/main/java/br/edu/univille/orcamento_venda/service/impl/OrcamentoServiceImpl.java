package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.orcamento_venda.entity.Orcamento;
import br.edu.univille.orcamento_venda.repository.OrcamentoRepository;
import br.edu.univille.orcamento_venda.service.OrcamentoService;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {
    @Autowired
    private OrcamentoRepository repository;

    @Override
    public List<Orcamento> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Orcamento orcamento) {
        repository.save(orcamento);
    }

    @Override
    public void delete(Orcamento orcamento) {
        repository.delete(orcamento);
    }
}
