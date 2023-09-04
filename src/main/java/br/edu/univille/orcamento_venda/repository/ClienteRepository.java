package br.edu.univille.orcamento_venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.univille.orcamento_venda.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
