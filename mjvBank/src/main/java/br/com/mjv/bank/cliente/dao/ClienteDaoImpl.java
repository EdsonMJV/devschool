package br.com.mjv.bank.cliente.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.mjv.bank.cliente.model.Cliente;
import br.com.mjv.bank.cliente.model.ClienteRowMapper;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteDaoImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource ds;
	
	@Override
	public Cliente buscarPorId(Integer id) {
		try {
			StringBuilder sql = new StringBuilder(" SELECT * FROM TB_CLIENTE WHERE id = :id ");

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
			
			Cliente cliente = template.queryForObject(sql.toString(), params, new ClienteRowMapper());
			
			return cliente;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontado cliente com o id: " + id);
			return null;
		}
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
			LOGGER.info("Não foi encontado cliente com o usuario: " + usuario);
			return null;
		}
		
	}

	@Override
	public Integer incluirCliente(Cliente cliente) {
		
		SimpleJdbcInsert insertCliente = new SimpleJdbcInsert(ds).usingGeneratedKeyColumns("id");
		insertCliente.withTableName("TB_CLIENTE");
		 
		Map<String, Object> params = new HashMap<>();
		
		params.put("nome", cliente.getNome());
		params.put("usuario", cliente.getUsuario());
		params.put("cpf", cliente.getCpf());
		params.put("agencia", cliente.getAgencia());
		params.put("conta", cliente.getConta());
		params.put("saldo", 0);
		 
		return (Integer) insertCliente.executeAndReturnKey(params);
	}

	@Override
	public void atualizarSaldo(Double saldo, Integer id) {
		String sql = "UPDATE TB_CLIENTE SET saldo = :saldo WHERE id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("saldo", saldo);
		params.addValue("id", id);
		template.update(sql, params);
	}

	@Override
	public Cliente findClienteByAgenciaConta(Integer agencia, Integer conta) {
		try {
			String sql = "SELECT * FROM TB_CLIENTE WHERE agencia = :agencia AND conta = :conta";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("agencia", agencia);
			params.addValue("conta", conta);
			return template.queryForObject(sql, params, new ClienteRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontado cliente com agencia: " + agencia + " e conta: " + conta);
			return null;
		}
	}


}
