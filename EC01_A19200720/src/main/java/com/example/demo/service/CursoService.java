package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CursoRequestDTO;
import com.example.demo.dto.CursoResponseDTO;

public interface CursoService {
	public void guardarCurso(CursoRequestDTO c);
	public void eliminarCurso(Integer id);
	public void editarCurso(CursoRequestDTO c);
	public List<CursoResponseDTO> listarCurso();
	public CursoResponseDTO cursoById(Integer id);

}
