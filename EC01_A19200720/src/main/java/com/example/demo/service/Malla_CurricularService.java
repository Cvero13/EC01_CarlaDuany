package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Malla_CurricularRequestDTO;
import com.example.demo.dto.Malla_CurricularResponseDTO;

public interface Malla_CurricularService {
	
	public void guardarMalla(Malla_CurricularRequestDTO m);
	public void eliminarMalla(Integer id);
	public void editarMalla(Malla_CurricularRequestDTO m);
	public List<Malla_CurricularResponseDTO> listarMalla();
	public Malla_CurricularResponseDTO mallaById(Integer id);

}
