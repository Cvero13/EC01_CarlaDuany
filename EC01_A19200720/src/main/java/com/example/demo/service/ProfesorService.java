package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProfesorRequestDTO;
import com.example.demo.dto.ProfesorResponseDTO;

public interface ProfesorService {
	
	public void guardarProfesor(ProfesorRequestDTO p);
	public void eliminarProfesor(Integer id);
	public void editarProfesor(ProfesorRequestDTO p);
	public List<ProfesorResponseDTO> listarProfesor();
	public ProfesorResponseDTO profesortById(Integer id);

}
