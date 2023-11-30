package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.orcamento_venda.entity.Produto;
import br.edu.univille.orcamento_venda.repository.ProdutoRepository;
import br.edu.univille.orcamento_venda.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Produto produto) {
        repository.save(produto);
    }

    @Override
    public void delete(Produto produto) {
        repository.delete(produto);
    }

}
