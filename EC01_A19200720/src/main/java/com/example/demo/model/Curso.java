package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "curso")
@Entity
public class Curso implements Serializable{

	private static final long serialVersionUID = 499192041497612816L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdCurso;
	private String curso;
	private String descripcion;
	
	@ManyToMany(mappedBy = "cursos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesor> profesor = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_malla", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references malla_curricular (id_malla)"))	
	private Malla_Curricular malla_curricular;

	public Integer getIdCurso() {
		return IdCurso;
	}

	public void setIdCurso(Integer idCurso) {
		IdCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Profesor> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<Profesor> profesor) {
		this.profesor = profesor;
	}

	public Malla_Curricular getMalla_curricular() {
		return malla_curricular;
	}

	public void setMalla_curricular(Malla_Curricular malla_curricular) {
		this.malla_curricular = malla_curricular;
	}
	
}
