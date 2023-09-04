package br.edu.univille.orcamento_venda.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Orcamento {
    // Precisa puxar a herança de produtos, cliente e usuário

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Usuario usuario;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "id_produto")
    private List<Produto> colecaoProdutos = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_validade")
    private Date validade;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "data_criada")
    private Date dataCriada;
    private double valorTotal;
    private double quantTotal;
    private double quantPecas;
    private double descontoUnitario;
    private double descontoPercentual;
    private double valorFinal;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Date getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(Date dataCriada) {
        this.dataCriada = dataCriada;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getQuantTotal() {
        return quantTotal;
    }

    public void setQuantTotal(double quantTotal) {
        this.quantTotal = quantTotal;
    }

    public double getQuantPecas() {
        return quantPecas;
    }

    public void setQuantPecas(double quantPecas) {
        this.quantPecas = quantPecas;
    }

    public double getDescontoUnitario() {
        return descontoUnitario;
    }

    public void setDescontoUnitario(double descontoUnitario) {
        this.descontoUnitario = descontoUnitario;
    }

    public double getDescontoPercentual() {
        return descontoPercentual;
    }

    public void setDescontoPercentual(double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getColecaoProdutos() {
        return colecaoProdutos;
    }

    public void setColecaoProdutos(List<Produto> colecaoProdutos) {
        this.colecaoProdutos = colecaoProdutos;
    }

    public void setId(long id) {
        this.id = id;
    }

}
