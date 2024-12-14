package com.cpcd.microservices.app.estudiantes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;

public interface RepositorioEstudiante extends CrudRepository<Estudiante, Long> {

}
