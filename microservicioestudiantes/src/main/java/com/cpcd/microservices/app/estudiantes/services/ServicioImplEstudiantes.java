package com.cpcd.microservices.app.estudiantes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;
import com.cpcd.microservices.app.estudiantes.models.repository.RepositorioEstudiante;

@Service
public class ServicioImplEstudiantes implements ServicioEstudiante {

	@Autowired
	private RepositorioEstudiante repositorioestudiante;
	
	@Override
	@Transactional (readOnly = true)
	public Iterable<Estudiante> findAll() {
		
		return repositorioestudiante.findAll();
	}

	@Override
	@Transactional (readOnly = true)
	public Optional<Estudiante> findById(long id) {
		
		return repositorioestudiante.findById(id);
	}

	@Override
	@Transactional 
	public Estudiante save(Estudiante estudiante) {
		
		return repositorioestudiante.save(estudiante);
	}

	@Override
	@Transactional
	public void deleteById(long id) {

		repositorioestudiante.deleteById(id);
	}

}
