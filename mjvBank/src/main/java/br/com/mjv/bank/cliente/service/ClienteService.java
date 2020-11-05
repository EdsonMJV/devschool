package br.com.mjv.bank.cliente.service;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.exception.BusinessException;
import br.com.mjv.bank.operacao.model.Operacao;

public interface ClienteService {

	/**
	 * Funcionalidade para incluir um novo cliente.
	 * @param cliente
	 * @return
	 * @throws BusinessException Exception disparada se o cliente informado tem usuario ja cadastrado previamente no banco.
	 */
	Integer incluirCliente(Cliente cliente) throws BusinessException;
	
	/**
	 * Retorna um {@link Cliente} com base no id informado.
	 * @param id
	 * @return
	 */
	Cliente buscarPorId(Integer id);

	/**
	 * Metodo para buscar um {@link Cliente} com base na agencia e conta informada.
	 * @param agencia
	 * @param conta
	 * @return
	 */
	Cliente findClienteByAgenciaConta(Integer agencia, Integer conta);
	
	
	void realizarTransferencia(Integer idCliente, Operacao operacao);

}
