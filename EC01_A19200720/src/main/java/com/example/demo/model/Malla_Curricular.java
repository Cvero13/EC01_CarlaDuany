package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "malla_curricular")
@Entity
public class Malla_Curricular implements Serializable{

	private static final long serialVersionUID = -9036656791382546648L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdMalla;
	private String anioMalla;
	
	@OneToMany(mappedBy = "malla_curricular")
	private List<Malla_Curricular> malla_curricular = new ArrayList<>();
	
	@OneToOne(mappedBy = "mallas") 
	private Universidad universidades;

	public Integer getIdMalla() {
		return IdMalla;
	}

	public void setIdMalla(Integer idMalla) {
		IdMalla = idMalla;
	}



	public String getAnioMalla() {
		return anioMalla;
	}

	public void setAnioMalla(String anioMalla) {
		this.anioMalla = anioMalla;
	}



	public List<Malla_Curricular> getMalla_curricular() {
		return malla_curricular;
	}

	public void setMalla_curricular(List<Malla_Curricular> malla_curricular) {
		this.malla_curricular = malla_curricular;
	}

	public Universidad getUniversidades() {
		return universidades;
	}

	public void setUniversidades(Universidad universidades) {
		this.universidades = universidades;
	}
	
	
}
