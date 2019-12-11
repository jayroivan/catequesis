package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Grupo;

@Repository
public interface RepoGrupo extends JpaRepository<Grupo, Integer> {

}
