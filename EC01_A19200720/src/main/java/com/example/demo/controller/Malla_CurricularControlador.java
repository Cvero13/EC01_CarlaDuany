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

import com.example.demo.dto.Malla_CurricularRequestDTO;
import com.example.demo.dto.Malla_CurricularResponseDTO;
import com.example.demo.service.Malla_CurricularService;

@RestController
@RequestMapping("/Malla_Curricular/e1")
public class Malla_CurricularControlador {
	
	@Autowired
	private Malla_CurricularService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listarMalla_Curriculares")
	public ResponseEntity<List<Malla_CurricularResponseDTO>>listarMallaCurriculares(){
		return new ResponseEntity<List<Malla_CurricularResponseDTO>>(service.listarMalla(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardarMalla_Curricular")
	public ResponseEntity<Void> guardarMalla_Curricular(@RequestBody Malla_CurricularRequestDTO malla_curricular){
		service.guardarMalla(malla_curricular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
		
	@RequestMapping(method = RequestMethod.GET, path = "/Malla_Curricular/{id}")
	public @ResponseBody ResponseEntity<Malla_CurricularResponseDTO> mallaById(@PathVariable Integer id){
		Malla_CurricularResponseDTO malla_curricular = service.mallaById(id);
		if(malla_curricular != null) {
			return new ResponseEntity<Malla_CurricularResponseDTO>(malla_curricular, HttpStatus.OK);
		}
		return new ResponseEntity<Malla_CurricularResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminarMalla_Curricular/{id}")
	public ResponseEntity<Void> eliminarMalla_Curricular(@PathVariable Integer id){
		Malla_CurricularResponseDTO malla_curricular = service.mallaById(id);
		if(malla_curricular != null) {
			service.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editarMalla_Curricular")
	public ResponseEntity<Void> editarMalla_Curricular(@RequestBody Malla_CurricularRequestDTO malla_curricular){
		Malla_CurricularResponseDTO malla = service.mallaById(malla_curricular.getIdRequest());
		if(malla != null) {
			service.editarMalla(malla_curricular);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
