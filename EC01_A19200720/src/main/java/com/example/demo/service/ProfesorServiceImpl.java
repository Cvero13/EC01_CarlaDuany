package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProfesorRequestDTO;
import com.example.demo.dto.ProfesorResponseDTO;
import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepositorio;
@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepositorio repository;
	
	@Override
	public void guardarProfesor(ProfesorRequestDTO p) {
		// TODO Auto-generated method stub
		Profesor profesor = new Profesor();		
		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getNombreProfesorRq());
	
		repository.save(profesor);
	}

	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProfesor(ProfesorRequestDTO p) {
		// TODO Auto-generated method stub
		Profesor profesor = new Profesor();		
		profesor.setIdProfesor(p.getIdRequest());
		profesor.setProfesor(p.getNombreProfesorRq());	
		
		repository.saveAndFlush(profesor);
	}

	@Override
	public List<ProfesorResponseDTO> listarProfesor() {
		// TODO Auto-generated method stub
		List<Profesor> profesores = repository.findAll();		
		List<ProfesorResponseDTO> dto = new ArrayList<ProfesorResponseDTO>();
		ProfesorResponseDTO profesorDto = null;
		
		for (Profesor prof : profesores) {
			profesorDto = new ProfesorResponseDTO();			
			profesorDto.setIdResponse(prof.getIdProfesor());
			profesorDto.setNombreProfesorRp(prof.getProfesor());
			
			dto.add(profesorDto);
		}
		return dto;
	}

	@Override
	public ProfesorResponseDTO profesortById(Integer id) {
		// TODO Auto-generated method stub
		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorResponseDTO profesorDto = new ProfesorResponseDTO();		
		profesorDto = new ProfesorResponseDTO();		
		profesorDto.setIdResponse(profesor.getIdProfesor());
		profesorDto.setNombreProfesorRp(profesor.getProfesor());
				
		return profesorDto;
	}

}
