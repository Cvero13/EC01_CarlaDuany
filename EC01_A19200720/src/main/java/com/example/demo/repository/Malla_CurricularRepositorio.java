package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Malla_Curricular;
@Repository
public interface Malla_CurricularRepositorio extends JpaRepository<Malla_Curricular, Integer>{

}
