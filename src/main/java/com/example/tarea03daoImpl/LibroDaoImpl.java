package com.example.tarea03daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.tarea03.dao.Todo;
import com.example.tarea03.entity.Libro;

@Component
public class LibroDaoImpl implements Todo<Libro>{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int create(Libro t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Libro t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int updateEstado(int idlibro, int estado) {
		String query = "UPDATE libro SET estado = " + estado + "WHERE  idlibro = " + idlibro;
		return jdbcTemplate.update(query);
	}
	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Libro read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
