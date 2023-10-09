package br.edu.univille.orcamento_venda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.orcamento_venda.entity.Produto;
import br.edu.univille.orcamento_venda.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ModelAndView index() {

        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoProduto = new Produto();
        return new ModelAndView("produto/form", "produto", novoProduto);
    }

    @PostMapping
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto) {
        return new ModelAndView("produto/form", "produto", produto);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Produto produto) {
        service.delete(produto);
        return new ModelAndView("redirect:/produtos");
    }
}
