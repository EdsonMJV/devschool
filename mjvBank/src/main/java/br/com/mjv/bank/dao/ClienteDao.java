package br.com.mjv.bank.dao;

import br.com.mjv.model.Cliente;

public interface ClienteDao {

	Cliente buscarPorId(Integer id);

	Cliente buscarClienteUsuario(String usuario);

	
}
