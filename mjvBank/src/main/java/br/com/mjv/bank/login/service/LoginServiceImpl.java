package br.com.mjv.bank.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.bank.dao.ClienteDao;
import br.com.mjv.model.Cliente;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ClienteDao dao;
	
	@Override
	public Cliente buscarClienteUsuario(String usuario) {
		return dao.buscarClienteUsuario(usuario);
	}

}
