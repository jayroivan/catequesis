package com.proyecto.matricula.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.matricula.entidades.Alumno;

@Repository
public interface RepoAlumno extends JpaRepository<Alumno, Integer> {

}
