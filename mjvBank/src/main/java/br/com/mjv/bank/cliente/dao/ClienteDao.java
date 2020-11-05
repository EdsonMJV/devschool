package br.com.mjv.bank.cliente.dao;

import br.com.mjv.bank.cliente.model.Cliente;

public interface ClienteDao {

	/**
	 * Retorna um {@link Cliente} com base no id informado.
	 * @param id
	 * @return
	 */
	Cliente buscarPorId(Integer id);

	/**
	 * Retorna um {@link Cliente} com base no usuario informado.
	 * @param usuario usuario informado no momento de login.
	 * @return um cliente encontrado na base com o usuario informado. Se nenhum for encontrado, retorna null.
	 */
	Cliente buscarClienteUsuario(String usuario);
	
	/**
	 * Funcionalidade para incluir no banco de dados um novo {@link Cliente}. 
	 * @param cliente
	 * @return
	 */
	Integer incluirCliente(Cliente cliente);

	Cliente findClienteByAgenciaConta(Integer agencia, Integer conta);

	void atualizarSaldo(Double saldo, Integer id);

	
}
