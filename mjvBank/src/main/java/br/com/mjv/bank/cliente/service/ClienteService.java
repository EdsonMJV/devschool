package br.com.mjv.bank.cliente.service;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.exception.BusinessException;

public interface ClienteService {

	/**
	 * Funcionalidade para incluir um novo cliente.
	 * @param cliente
	 * @return
	 * @throws BusinessException Exception disparada se o cliente informado tem usuario ja cadastrado previamente no banco.
	 */
	Integer incluirCliente(Cliente cliente) throws BusinessException;
}
