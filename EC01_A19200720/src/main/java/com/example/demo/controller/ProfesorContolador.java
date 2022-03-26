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

import com.example.demo.dto.ProfesorRequestDTO;
import com.example.demo.dto.ProfesorResponseDTO;
import com.example.demo.service.ProfesorService;

@RestController
@RequestMapping("/profesor/e1")
public class ProfesorContolador { 

	@Autowired
	private ProfesorService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listarProfesores")
	public ResponseEntity<List<ProfesorResponseDTO>>listarProfesores(){
		return new ResponseEntity<List<ProfesorResponseDTO>>(service.listarProfesor(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardarProfesor")
	public ResponseEntity<Void> guardarProfesor(@RequestBody ProfesorRequestDTO profesor){
		service.guardarProfesor(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listarProfesor/{id}")
	public @ResponseBody ResponseEntity<ProfesorResponseDTO> profesortById(@PathVariable Integer id){
		ProfesorResponseDTO profesor = service.profesortById(id);
		if(profesor != null) {
			return new ResponseEntity<ProfesorResponseDTO>(profesor, HttpStatus.OK);
		}
		return new ResponseEntity<ProfesorResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminarProfesor/{id}")
	public ResponseEntity<Void> eliminarProfesor(@PathVariable Integer id){
		ProfesorResponseDTO profesor = service.profesortById(id);
		if(profesor != null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editarProfesor")
	public ResponseEntity<Void> editarProfesor(@RequestBody ProfesorRequestDTO profesor){
		ProfesorResponseDTO prof = service.profesortById(profesor.getIdRequest());
		if(prof != null) {
			service.editarProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
