package br.com.mjv.bank.login.service;

import br.com.mjv.bank.cliente.model.Cliente;

public interface LoginService {

	
	Cliente buscarClienteUsuario(String usuario);
	
}
