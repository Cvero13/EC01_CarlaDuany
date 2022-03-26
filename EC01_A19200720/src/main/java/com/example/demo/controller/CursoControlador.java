package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CursoRequestDTO;
import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.service.CursoService;

@RestController
@RequestMapping("/Curso/e1")
public class CursoControlador {
	@Autowired
	private CursoService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listarCursos")
	public ResponseEntity<List<CursoResponseDTO>>listarCursos(){
		return new ResponseEntity<List<CursoResponseDTO>>(service.listarCurso(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardarCurso")
	public ResponseEntity<Void> guardarCurso(@RequestBody CursoRequestDTO curso){
		service.guardarCurso(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listarCurso/{id}")
	public @ResponseBody ResponseEntity<CursoResponseDTO> cursotById(@PathVariable Integer id){
		CursoResponseDTO curso = service.cursoById(id);
		if(curso != null) {
			return new ResponseEntity<CursoResponseDTO>(curso, HttpStatus.OK);
		}
		return new ResponseEntity<CursoResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminarCurso/{id}")
	public ResponseEntity<Void> eliminarCurso(@PathVariable Integer id){
		CursoResponseDTO curso = service.cursoById(id);
		if(curso != null) {
			service.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editarCurso")
	public ResponseEntity<Void> editarCurso(@RequestBody CursoRequestDTO curso){
		CursoResponseDTO cur = service.cursoById(curso.getIdRequest());
		if(cur != null) {
			service.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}	
}
