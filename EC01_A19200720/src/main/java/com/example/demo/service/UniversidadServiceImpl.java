package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UniversidadRequestDTO;
import com.example.demo.dto.UniversidadResponseDTO;
import com.example.demo.model.Universidad;
import com.example.demo.repository.UniversidadRepositorio;
@Service
public class UniversidadServiceImpl implements UniversidadService {

	@Autowired
	private UniversidadRepositorio repository;
	
	@Override
	public void guardarUniversidad(UniversidadRequestDTO u) {
		// TODO Auto-generated method stub
		Universidad universidad = new Universidad();		
		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getNombreUniversidadRq());
			
		repository.save(universidad);
	}

	@Override
	public void eliminarUniversidad(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarUniversidad(UniversidadRequestDTO u) {
		// TODO Auto-generated method stub
		Universidad universidad = new Universidad();		
		universidad.setIdUniversidad(u.getIdRequest());
		universidad.setUniversidad(u.getNombreUniversidadRq());			
		
		repository.saveAndFlush(universidad);
	}

	@Override
	public List<UniversidadResponseDTO> listarUnivrsidad() {
		// TODO Auto-generated method stub
		List<Universidad> universidades = repository.findAll();		
		List<UniversidadResponseDTO> dto = new ArrayList<UniversidadResponseDTO>();
		UniversidadResponseDTO universiddDto = null;
		
		for (Universidad uni : universidades) {
			universiddDto = new UniversidadResponseDTO();			
			universiddDto.setIdResponse(uni.getIdUniversidad());
			universiddDto.setNombreUniversidadRp(uni.getUniversidad());
			
			dto.add(universiddDto);
		}
		return dto;
	}

	@Override
	public UniversidadResponseDTO universidadById(Integer id) {
		// TODO Auto-generated method stub
		Universidad universidad = repository.findById(id).orElse(null);
		UniversidadResponseDTO universidadDto = new UniversidadResponseDTO();		
		universidadDto = new UniversidadResponseDTO();		
		universidadDto.setIdResponse(universidad.getIdUniversidad());
		universidadDto.setNombreUniversidadRp(universidad.getUniversidad());		
		
		return universidadDto;
	}
}
