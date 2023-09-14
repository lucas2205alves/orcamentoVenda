package br.edu.univille.orcamento_venda.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.univille.orcamento_venda.entity.Cliente;
import br.edu.univille.orcamento_venda.repository.ClienteRepository;
import br.edu.univille.orcamento_venda.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    public ModelAndView index() {

        var listaClientes = service.getAll();
        return new ModelAndView("cliente/index", "listaClientes", listaClientes);
    }

}
