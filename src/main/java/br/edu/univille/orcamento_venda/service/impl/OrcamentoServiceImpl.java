package br.edu.univille.orcamento_venda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.orcamento_venda.entity.ItemOrcamento;
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


    public Double calcularValorTotal(Orcamento orcamento) {

        Double valorTotal = 0.0;
        for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
            valorTotal += itemOrcamento.getProduto().getValor();
        }
        return valorTotal;
    }

    public Double calcularQuantidade(Orcamento orcamento) {

            Double quantidade = 0.0;
            for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
                quantidade += itemOrcamento.getProduto().getQuantidade();
            }
            return quantidade;
        }

    public Double calcularValorFinal(Orcamento orcamento) {

        Double valorFinal = 0.0;
        for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
             valorFinal += itemOrcamento.getProduto().getQuantidade();
        }
        return valorFinal;
        }


    @Override
    public void save(Orcamento orcamento) {
        Double valorTotal = calcularValorTotal(orcamento);
        Double quantidade = calcularQuantidade(orcamento);
        Double valorFinal = calcularValorFinal(orcamento);

        valorFinal = valorTotal - orcamento.getDescontoUnitario();
        orcamento.setValorFinal(valorFinal);
        orcamento.setQuantTotal(quantidade);
        orcamento.setValorTotal(valorTotal);
        orcamento.setQuantPecas(quantidade);
        repository.save(orcamento);
    }


    

    @Override
    public void delete(Orcamento orcamento) {
        repository.delete(orcamento);
    }
}
