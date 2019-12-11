package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.matricula.entidades.Secretaria;

@Repository
public interface RepoSecretaria extends JpaRepository<Secretaria, Integer> {

}
