package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Catequista;

@Repository
public interface RepoCatequista extends JpaRepository<Catequista, Integer> {

}
