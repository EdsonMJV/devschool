package br.com.mjv.bank.operacao.model;

import java.util.Date;

import br.com.mjv.bank.cliente.model.Cliente;

/**
 * Modelo referente a tabela TB_OPERACAO 
 * @author edson.costa
 */
public class Operacao {

	private Integer idCliente;
	private Integer idTipoOperacao;
	private Date data;
	private Double valor;
	private String descricao;
	
	private Cliente cliente;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getIdTipoOperacao() {
		return idTipoOperacao;
	}
	
	public void setIdTipoOperacao(Integer idTipoOperacao) {
		this.idTipoOperacao = idTipoOperacao;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
