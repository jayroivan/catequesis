package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Nivel;

@Repository
public interface RepoNivel extends JpaRepository<Nivel, Integer> {

}
