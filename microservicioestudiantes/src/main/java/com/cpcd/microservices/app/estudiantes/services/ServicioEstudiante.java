package com.cpcd.microservices.app.estudiantes.services;

import java.util.Optional;

import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;

public interface ServicioEstudiante {
	
	public Iterable<Estudiante> findAll();
	
	public Optional<Estudiante> findById(long id);
	
	public Estudiante save(Estudiante estudiante);
	
	public void deleteById(long id);

}
