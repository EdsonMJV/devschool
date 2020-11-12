package br.com.mjv.bank.operacao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.mjv.bank.cliente.dao.ClienteDao;
import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.operacao.dao.OperacaoDao;
import br.com.mjv.bank.operacao.model.Operacao;

@Service
public class OperacaoServiceImpl implements OperacaoService {

	@Autowired
	private OperacaoDao dao;
	
	@Autowired 
	private ClienteDao clienteDao;
	
	
	@Override
	public List<Operacao> operacoesPorClientePeriodo(Integer idCliente, Date dataInicio, Date dataFim) {
		return dao.operacoesPorClientePeriodo(idCliente, dataInicio, dataFim);
	}

	@Override
	public void incluirOperacao(Operacao operacao) {
		dao.incluirOperacao(operacao);
	}

	@Override
	@Transactional
	public void realizarTransferencia(Integer idDe, Operacao operacao) {
		
		String semPonto = StringUtils.replace(operacao.getValorString(), ".", "");
		String semVirgula = StringUtils.replace(semPonto, ",", ".");
		
		operacao.setData(new Date());
		operacao.setDescricao("RECEBIMENTO DE OUTRA CONTA");
		operacao.setIdTipoOperacao(1);
		operacao.setValor(Double.valueOf(semVirgula));
		incluirOperacao(operacao);
		
		Cliente para = clienteDao.buscarPorId(operacao.getCliente().getId());
		para.setSaldo(para.getSaldo() + operacao.getValor());
		clienteDao.atualizarSaldo(para.getSaldo(), operacao.getCliente().getId());
		operacao.setCliente(para);

		Operacao operacaoDe = new Operacao();
		operacaoDe.setCliente(new Cliente(idDe));
		operacaoDe.setData(new Date());
		operacaoDe.setDescricao("TRANSFERENCIA PARA OUTRA CONTA");
		operacaoDe.setIdTipoOperacao(3);
		operacaoDe.setValor(Double.valueOf(semVirgula));
		incluirOperacao(operacaoDe);
		
		Cliente de = clienteDao.buscarPorId(idDe);
		de.setSaldo(de.getSaldo() - operacao.getValor());
		clienteDao.atualizarSaldo(de.getSaldo(), idDe);
	}

}
