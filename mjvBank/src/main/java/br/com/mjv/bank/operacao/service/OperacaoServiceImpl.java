package br.com.mjv.bank.operacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.bank.operacao.dao.OperacaoDao;
import br.com.mjv.bank.operacao.model.Operacao;

@Service
public class OperacaoServiceImpl implements OperacaoService {

	@Autowired
	private OperacaoDao dao;
	
	@Override
	public void incluirOperacao(Operacao operacao) {

	}

}
