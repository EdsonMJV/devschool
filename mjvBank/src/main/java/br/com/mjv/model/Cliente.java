package br.com.mjv.model;


/**
 * Modelo referente a tabela TB_CLIENTE 
 * @author edson.costa
 */
public class Cliente {

	private Integer id;
	private String nome;
	private String usuario;
	private String cpf;
	private Double saldo;
	private Integer conta;
	private Integer agencia;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public Integer getConta() {
		return conta;
	}
	
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	
	public Integer getAgencia() {
		return agencia;
	}
	
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	

}
