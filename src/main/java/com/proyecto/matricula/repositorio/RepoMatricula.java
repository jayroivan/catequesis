package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Matricula;

@Repository
public interface RepoMatricula extends JpaRepository<Matricula, Integer> {

}
