package br.edu.univille.orcamento_venda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.orcamento_venda.entity.Orcamento;
import br.edu.univille.orcamento_venda.service.OrcamentoService;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;

    @GetMapping
    public ModelAndView index() {

        var listaOrcamentos = service.getAll();
        return new ModelAndView("orcamento/index", "listaOrcamentos", listaOrcamentos);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var novoOrcamento = new Orcamento();
        return new ModelAndView("orcamento/form", "orcamento", novoOrcamento);
    }

    @PostMapping
    public ModelAndView save(Orcamento orcamento) {
        service.save(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Orcamento orcamento) {
        return new ModelAndView("orcamento/form", "orcamento", orcamento);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Orcamento orcamento) {
        service.delete(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }
}
