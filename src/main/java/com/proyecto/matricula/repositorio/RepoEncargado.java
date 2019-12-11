package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Encargado;

@Repository
public interface RepoEncargado extends JpaRepository<Encargado, Integer> {

}
