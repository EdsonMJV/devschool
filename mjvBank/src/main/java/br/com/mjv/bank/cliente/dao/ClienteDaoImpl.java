package br.com.mjv.bank.cliente.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.cliente.model.ClienteRowMapper;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public Cliente buscarPorId(Integer id) {
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Cliente buscarCliente(Cliente cliente) {
		
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		sql.append(" SELECT id, nome FROM TB_CLIENTE WHERE 1 = 1 ");
		
		if(!StringUtils.isEmpty(cliente.getNome())) {
			sql.append(" AND nome = :nome ");
			params.addValue("nome", cliente.getNome());
		}
		
		if(!StringUtils.isEmpty(cliente.getUsuario())) {
			sql.append(" AND usuario = :usuario ");
			params.addValue("usuario", cliente.getUsuario());
		}
		
		if(!StringUtils.isEmpty(cliente.getCpf())) {
			sql.append(" AND cpf = :cpf ");
			params.addValue("cpf", cliente.getCpf());
		}
		
		template.query(sql.toString(), params, new RowMapper() {

			@Override
			public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Object> row = new HashMap<>();
				
				row.put("id", rs.getInt("id"));
				row.put("nome", rs.getString("nome"));
				
				return row;
			}
			
		});
		
		return null;
		
	}

	@Override
	public Cliente buscarClienteUsuario(String usuario) {

		try {
			StringBuilder sql = new StringBuilder(" SELECT * FROM TB_CLIENTE WHERE usuario = :usuario ");

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("usuario", usuario);
			
			Cliente cliente = template.queryForObject(sql.toString(), params, new ClienteRowMapper());
			
			return cliente;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public Integer incluirCliente(Cliente cliente) {
		StringBuilder sql = new StringBuilder(" INSERT INTO TB_CLIENTE (nome, usuario, cpf, agencia, conta) VALUES ");
		sql.append("(:nome, :usuario, :cpf, :agencia, :conta)");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("usuario", cliente.getUsuario());
		params.addValue("nome", cliente.getNome());
		params.addValue("cpf", cliente.getCpf());
		params.addValue("agencia", cliente.getAgencia());
		params.addValue("conta", cliente.getConta());
		
		template.update(sql.toString(), params);
		
		return buscarClienteUsuario(cliente.getUsuario()).getId();
	}


}
