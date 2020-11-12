package br.com.mjv.bank.operacao.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.bank.operacao.model.Operacao;
import br.com.mjv.bank.operacao.model.OperacaoRowMapper;

@Repository
public class OperacaoDaoImpl implements OperacaoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public void incluirOperacao(Operacao operacao) {
		
		String sql = "INSERT INTO TB_OPERACAO (id_cliente, id_operacao, data, valor, descricao) VALUES (:id_cliente, :id_operacao, :data, :valor, :descricao)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id_cliente", operacao.getCliente().getId());
		params.addValue("id_operacao", operacao.getIdTipoOperacao());
		params.addValue("data", operacao.getData());
		params.addValue("valor", operacao.getValor());
		params.addValue("descricao", operacao.getDescricao());
		template.update(sql, params);
		
	}

	@Override
	public List<Operacao> operacoesPorClientePeriodo(Integer idCliente, Date dataInicio, Date dataFim) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		StringBuilder sql = new StringBuilder("SELECT * FROM TB_OPERACAO WHERE id_cliente = :idCliente ");
		params.addValue("idCliente", idCliente);
		
		if(dataInicio != null) {
			sql.append(" AND DATA >= :inicio ");
			params.addValue("inicio", dataInicio);
		}
		
		if(dataFim != null) {
			sql.append(" AND DATA <= :fim ");
			params.addValue("fim", dataFim);
		}
		
		sql.append(" ORDER BY data desc");
		
		return template.query(sql.toString(), params, new OperacaoRowMapper());
	}

	@Override
	public Operacao findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
