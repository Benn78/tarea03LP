package com.example.tarea03.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tarea03.Constantes;
import com.example.tarea03.dao.Todo;
import com.example.tarea03.entity.Prestamo;
import com.example.tarea03daoImpl.DetalleDaoImpl;
import com.example.tarea03daoImpl.LibroDaoImpl;
import com.example.tarea03daoImpl.PrestamoDaoImpl;

@Service
public class PrestamoService implements Todo<Prestamo>{
	
	@Autowired
	private PrestamoDaoImpl prestamoDao;
	
	@Autowired
	private DetalleDaoImpl detalleDao;
	
	@Autowired
	private LibroDaoImpl libroDao;
	
	@Override
	@Transactional
	public int create(Prestamo t) {
		
		int idGenerado = prestamoDao.create(t);
		
		t.getDetalles().forEach(detalle -> {
			detalle.setIdPrestamo(idGenerado);
			detalleDao.create(detalle);
			
			libroDao.updateEstado(detalle.getIdLibro(), Constantes.L_PRESTADO);
		});
		return idGenerado;
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
