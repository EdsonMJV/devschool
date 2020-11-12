package br.com.mjv.bank.operacao.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OperacaoRowMapper implements RowMapper<Operacao> {

	@Override
	public Operacao mapRow(ResultSet rs, int rowNum) throws SQLException {
		Operacao operacao = new Operacao();
		operacao.setIdCliente((rs.getInt("id_cliente")));
		operacao.setData(rs.getTimestamp("data"));
		operacao.setDescricao(rs.getString("descricao"));
		operacao.setIdTipoOperacao(rs.getInt("id_operacao"));
		operacao.setValor(rs.getDouble("valor"));
		return operacao;
	}

}
