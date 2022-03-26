package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CursoRequestDTO;
import com.example.demo.dto.CursoResponseDTO;
import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepositorio;
@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepositorio repository;
	
	
	@Override
	public void guardarCurso(CursoRequestDTO c) {
		// TODO Auto-generated method stub		
		Curso curso = new Curso();
		
		curso.setIdCurso(c.getIdRequest());
		curso.setCurso(c.getNombreCursoRq());
		curso.setDescripcion(c.getDescripcionCursoRq());			
		repository.save(curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCurso(CursoRequestDTO c) {
		// TODO Auto-generated method stub
		Curso curso = new Curso();		
		curso.setIdCurso(c.getIdRequest());
		curso.setDescripcion(c.getDescripcionCursoRq());
		curso.setCurso(c.getNombreCursoRq());		
		
		repository.saveAndFlush(curso);		
	}

	@Override
	public List<CursoResponseDTO> listarCurso() {
		// TODO Auto-generated method stub
		
		List<Curso> curso = repository.findAll();		
		List<CursoResponseDTO> dto = new ArrayList<CursoResponseDTO>();
		CursoResponseDTO cursoDto = null;
		
		for (Curso cur : curso) {
			cursoDto = new CursoResponseDTO();			
			cursoDto.setIdResponse(cur.getIdCurso());
			cursoDto.setDescripcionCursoRp(cur.getDescripcion());
			cursoDto.setNombreCursoRp(cur.getCurso());			
			dto.add(cursoDto);
		}
		return dto;
	}

	@Override
	public CursoResponseDTO cursoById(Integer id) {
		// TODO Auto-generated method stub
		Curso curso = repository.findById(id).orElse(null);
		CursoResponseDTO cursooDto = new CursoResponseDTO();		
		cursooDto = new CursoResponseDTO();		
		cursooDto.setIdResponse(curso.getIdCurso());
		cursooDto.setDescripcionCursoRp(curso.getDescripcion());
		cursooDto.setNombreCursoRp(curso.getCurso());
		
		return cursooDto;
	}
}
