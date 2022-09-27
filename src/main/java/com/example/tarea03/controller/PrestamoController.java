package com.example.tarea03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tarea03.Constantes;
import com.example.tarea03.entity.Prestamo;
import com.example.tarea03.service.PrestamoService;

@RestController
@RequestMapping("/api/prestamo")

public class PrestamoController {
	
	@Autowired
	private PrestamoService prestamoService;
	
	@PostMapping("/crear")
	public ResponseEntity<?> prestar(@RequestBody Prestamo prestamo){
		
		int idCreadoporBD = 0;
		
		if(prestamo.getDetalles().size() > Constantes.MAX_LIBROS) {
			return new ResponseEntity<String>("Usted no puede llevar más de 2 libros", HttpStatus.BAD_REQUEST);		
		}
		
		try {
			prestamoService.create(prestamo);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocurrió un error inesperado" + e.getMessage(), HttpStatus.BAD_REQUEST);		
		}
		
		prestamo.setIdPrestamo(idCreadoporBD);
		
		return new ResponseEntity<Prestamo>(prestamo, HttpStatus.CREATED);
	}
}
