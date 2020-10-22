package br.com.mjv.bank.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.model.Cliente;
import br.com.mjv.model.ClienteRowMapper;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public Cliente buscarPorId(Integer id) {
		
		return null;
	}

	@Override
	public Cliente buscarClienteUsuario(String usuario) {

		try {
			String sql = " SELECT * FROM TB_CLIENTE WHERE usuario = :usuario ";

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("usuario", usuario);
			
			Cliente cliente = template.queryForObject(sql, params, new ClienteRowMapper());
			
			return cliente;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}


}
