package com.cpcd.microservices.app.estudiantes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpcd.microservices.app.estudiantes.models.entity.Estudiante;
import com.cpcd.microservices.app.estudiantes.services.ServicioEstudiante;

@RestController
public class ControladorEstudiante {

	@Autowired
	private ServicioEstudiante servicioestudiante;
	
	@GetMapping
	public ResponseEntity<?> devolverEstudiantes(){
		return ResponseEntity.ok().body(servicioestudiante.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> devolverEstudiante(@PathVariable Long id){
		Optional<Estudiante> est = servicioestudiante.findById(id);
		
		if (est.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(est.get());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borarEstudiante(@PathVariable Long id){
		servicioestudiante.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> addEstudiante(@RequestBody Estudiante estudiante){
		Estudiante est = servicioestudiante.save(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(est);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarEstudainte(@RequestBody Estudiante estudiante, @PathVariable Long id){
		Optional<Estudiante> est = servicioestudiante.findById(id);
		if (est.isEmpty()) {
			return ResponseEntity.notFound().build();
		
	}
		Estudiante oestudiante = est.get();
		oestudiante.setNombre(estudiante.getNombre());
		oestudiante.setEdad(estudiante.getEdad());
		oestudiante.setCurso(estudiante.getCurso());
		oestudiante.setEmail(estudiante.getEmail());
		
		Estudiante oestudiante2 = servicioestudiante.save(oestudiante);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(oestudiante2);
  }
	
}
	
