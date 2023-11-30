package br.edu.univille.orcamento_venda.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.orcamento_venda.entity.ItemOrcamento;
import br.edu.univille.orcamento_venda.entity.Orcamento;
import br.edu.univille.orcamento_venda.entity.Produto;
import br.edu.univille.orcamento_venda.service.OrcamentoService;
import br.edu.univille.orcamento_venda.service.ProdutoService;
import br.edu.univille.orcamento_venda.service.ClienteService;
import br.edu.univille.orcamento_venda.service.ItemOrcamentoService;;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;
    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ModelAndView index() {

        var listaOrcamentos = service.getAll();
        return new ModelAndView("orcamento/index", "listaOrcamentos", listaOrcamentos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        HashMap<String,Object> dados = new HashMap<>();
        var novoOrcamento = new Orcamento();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();

        dados.put("orcamento", novoOrcamento);
        dados.put("listaClientes", listaClientes);
        dados.put("novoItem", new ItemOrcamento());
        dados.put("listaProdutos", listaProdutos);
        return new ModelAndView("orcamento/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(Orcamento orcamento) {
        service.save(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }


    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(Orcamento orcamento, ItemOrcamento novoItem){
        var listaClientes = clienteService.getAll();
        orcamento.getColecaoItens().add(novoItem);
            Double valorTotal = 0.0;
            Double quantidade = 0.0;
            Double valorFinal = 0.0;
            Double descontoUnitario = 0.0;
            for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
                valorTotal += itemOrcamento.getProduto().getValor();
            }
            for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
                valorFinal += itemOrcamento.getProduto().getValor();
            }
            for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
                quantidade += 1;
            }
            for (ItemOrcamento itemOrcamento : orcamento.getColecaoItens()) {
                valorFinal = valorTotal - orcamento.getDescontoUnitario();
            }

        orcamento.setValorFinal(valorFinal);
        orcamento.setValorTotal(valorTotal);
        orcamento.setQuantTotal(quantidade);




        HashMap<String,Object> dados = new HashMap<>();
        var listaProdutos = produtoService.getAll();
        dados.put("orcamento", orcamento);
        dados.put("novoItem", new ItemOrcamento());
        dados.put("listaProdutos", listaProdutos);
        dados.put("listaClientes", listaClientes);
        dados.put("colecaoItens", new ItemOrcamento());
        return new ModelAndView("orcamento/form",dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(Orcamento orcamento, 
            @RequestParam("removeitem") int index){
        orcamento.getColecaoItens().remove(index);
        var listaProdutos = produtoService.getAll();

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("orcamento", orcamento);
        dados.put("novoItem", new ItemOrcamento());
        dados.put("listaProdutos", listaProdutos);
        return new ModelAndView("or /form",dados);
    }



    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Orcamento orcamento) {

        HashMap<String,Object> dados = new HashMap<>();
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        dados.put("orcamento", orcamento);
        dados.put("listaClientes", listaClientes);
        dados.put("colecaoItens", new ItemOrcamento());
        dados.put("novoItem", new ItemOrcamento());
        dados.put("listaProdutos", listaProdutos);
        return new ModelAndView("orcamento/form",dados);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Orcamento orcamento) {
        service.delete(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }
}
