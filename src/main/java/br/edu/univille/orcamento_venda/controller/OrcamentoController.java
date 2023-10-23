package br.edu.univille.orcamento_venda.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.orcamento_venda.entity.Orcamento;
import br.edu.univille.orcamento_venda.service.OrcamentoService;
import br.edu.univille.orcamento_venda.service.ClienteService;;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {
    @Autowired
    private OrcamentoService service;

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

        dados.put("orcamento", novoOrcamento);
        dados.put("listaClientes", listaClientes);
        return new ModelAndView("orcamento/form", dados);
    }

    @PostMapping
    public ModelAndView save(Orcamento orcamento) {
        service.save(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Orcamento orcamento) {

        HashMap<String,Object> dados = new HashMap<>();
        var listaClientes = clienteService.getAll();
        dados.put("orcamento", orcamento);
        dados.put("listaClientes", listaClientes);

        return new ModelAndView("orcamento/form",dados);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Orcamento orcamento) {
        service.delete(orcamento);
        return new ModelAndView("redirect:/orcamentos");
    }
}