package br.com.mjv.bank.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.bank.cliente.dao.ClienteDao;
import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.exception.BusinessException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao dao;
	
	@Override
	public Integer incluirCliente(Cliente cliente) throws BusinessException {

		
		Cliente existe = dao.buscarClienteUsuario(cliente.getUsuario());
		
		if(existe != null) {
			throw new BusinessException("Já existe cliente com o usuário informado");
		}
		
		cliente.setAgencia(1);
		cliente.setConta(6549879);
		
		return dao.incluirCliente(cliente);
	}

}
