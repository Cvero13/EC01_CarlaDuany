package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Malla_CurricularRequestDTO;
import com.example.demo.dto.Malla_CurricularResponseDTO;
import com.example.demo.model.Malla_Curricular;
import com.example.demo.repository.Malla_CurricularRepositorio;
@Service
public class Malla_CurricularServiceImpl implements Malla_CurricularService {

	@Autowired
	private Malla_CurricularRepositorio repository;
	
	@Override
	public void guardarMalla(Malla_CurricularRequestDTO m) {
		// TODO Auto-generated method stub
		Malla_Curricular malla_curricular = new Malla_Curricular();		
		malla_curricular.setIdMalla(m.getIdRequest());
		malla_curricular.setAnioMalla(m.getAnioMallaRq());
		repository.save(malla_curricular);
	}

	@Override
	public void eliminarMalla(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarMalla(Malla_CurricularRequestDTO m) {
		// TODO Auto-generated method stub
		Malla_Curricular malla_curricular = new Malla_Curricular();		
		malla_curricular.setIdMalla(m.getIdRequest());
		malla_curricular.setAnioMalla(m.getAnioMallaRq());				
		
		repository.saveAndFlush(malla_curricular);
	}

	@Override
	public List<Malla_CurricularResponseDTO> listarMalla() {
		// TODO Auto-generated method stub
		List<Malla_Curricular> mallas_curricular = repository.findAll();		
		List<Malla_CurricularResponseDTO> dto = new ArrayList<Malla_CurricularResponseDTO>();
		Malla_CurricularResponseDTO mallaDto = null;
		
		for (Malla_Curricular mallas : mallas_curricular) {
			mallaDto = new Malla_CurricularResponseDTO();			
			mallaDto.setIdResponse(mallas.getIdMalla());
			mallaDto.setAnioMallaRp(mallas.getAnioMalla());						
			dto.add(mallaDto);
		}
		return dto;
	}

	@Override
	public Malla_CurricularResponseDTO mallaById(Integer id) {
		Malla_Curricular malla_curricular = repository.findById(id).orElse(null);
		Malla_CurricularResponseDTO mallaDto = new Malla_CurricularResponseDTO();		
		mallaDto = new Malla_CurricularResponseDTO();		
		mallaDto.setIdResponse(malla_curricular.getIdMalla());
		mallaDto.setAnioMallaRp(malla_curricular.getAnioMalla());

		return mallaDto;
	}

}
