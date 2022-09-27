package com.example.tarea03daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.tarea03.Constantes;
import com.example.tarea03.dao.Todo;
import com.example.tarea03.entity.Detalle;

@Component
public class DetalleDaoImpl implements Todo<Detalle> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int create(Detalle t) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO detalle(idlibro, idprestamo, estado) VALUES(?,?,?)";
		
		return jdbcTemplate.update(query, t.getIdLibro(), t.getIdPrestamo(), Constantes.P_REALIZADO);
	}

	@Override
	public int update(Detalle t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Detalle read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detalle> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
