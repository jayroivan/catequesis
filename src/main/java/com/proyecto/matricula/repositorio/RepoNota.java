package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Nota;

@Repository
public interface RepoNota extends JpaRepository<Nota, Integer> {

}
