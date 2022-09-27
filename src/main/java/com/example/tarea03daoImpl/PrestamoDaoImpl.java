package com.example.tarea03daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.example.tarea03.Constantes;
import com.example.tarea03.dao.Todo;
import com.example.tarea03.entity.Prestamo;


@Component
public class PrestamoDaoImpl implements Todo<Prestamo>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public int create(Prestamo t) {
		// TODO Auto-generated method stub
		
		NamedParameterJdbcTemplate named = new NamedParameterJdbcTemplate(dataSource);
		GeneratedKeyHolder llaveRecuperar = new GeneratedKeyHolder();
		
		String query = "INSERT INTO prestamo(fecha_prestamo, fecha_devolucion, "
				+ "idempleado, idalumno, estado) VALUES(now(), :fecDev, :idEmpleado,"
				+ " :idAlumno, :estado)";
		
		Map<String, Object> map new HashMap<>();
		map.put("decDev", t.getFechaDevolucion());
		map.put("idEmpleado", t.getIdEmpleado());
		map.put("idAlumno", t.getIdAlumno());
		map.put("estado", Constantes.P_REALIZADO);
		
		named.update(query, new MapSqlParameterSource(map), llaveRecuperar);
		
		
		return llaveRecuperar.getKey().intValue();
	}

	@Override
	public int update(Prestamo t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prestamo read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prestamo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
