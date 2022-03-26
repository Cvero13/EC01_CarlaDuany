package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="universidad")
@Entity
public class Universidad implements Serializable{

	private static final long serialVersionUID = -1998297166784249392L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdUniversidad;
	private String Universidad;
	
	@OneToOne
	@JoinColumn(name = "id_malla", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_malla) references malla_curricular (id_malla)"))
	private Malla_Curricular mallas;

	public Integer getIdUniversidad() {
		return IdUniversidad;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		IdUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return Universidad;
	}

	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}

	public Malla_Curricular getMallas() {
		return mallas;
	}

	public void setMallas(Malla_Curricular mallas) {
		this.mallas = mallas;
	}
	
	

}
