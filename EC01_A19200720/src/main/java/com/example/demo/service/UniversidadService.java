package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UniversidadRequestDTO;
import com.example.demo.dto.UniversidadResponseDTO;

public interface UniversidadService {
	
	public void guardarUniversidad(UniversidadRequestDTO u);
	public void eliminarUniversidad(Integer id);
	public void editarUniversidad(UniversidadRequestDTO u);
	public List<UniversidadResponseDTO> listarUnivrsidad();
	public UniversidadResponseDTO universidadById(Integer id);

}
