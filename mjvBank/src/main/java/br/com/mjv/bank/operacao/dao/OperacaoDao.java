package br.com.mjv.bank.operacao.dao;

import java.util.Date;
import java.util.List;

import br.com.mjv.bank.operacao.model.Operacao;

public interface OperacaoDao {

	void incluirOperacao(Operacao operacao);
	List<Operacao> operacoesPorClientePeriodo(Integer idCliente, Date dataInicio, Date dataFim);
	Operacao findById(Integer id);
}
