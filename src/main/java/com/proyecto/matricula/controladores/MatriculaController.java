package com.proyecto.matricula.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.matricula.entidades.Matricula;
import com.proyecto.matricula.repositorio.RepoMatricula;
import com.proyecto.matricula.repositorio.RepoAlumno;
import com.proyecto.matricula.repositorio.RepoGrupo;

@Controller
public class MatriculaController {
	@Autowired
	RepoMatricula repo;
	@Autowired
	RepoAlumno repo2;
	@Autowired
	RepoGrupo repo3;
	
		@GetMapping("/index_matricula")
		public String Inicio(Model model) {
			model.addAttribute("matriculas", repo.findAll());
			return "index_matricula";
		}
		
		@GetMapping("/nuevomatricula")
		public String Nuevo(Model model) {
			model.addAttribute("listado", repo2.findAll());
			model.addAttribute("listado2", repo3.findAll());
			return "nuevo_matricula";
		}
		
		@PostMapping("/registrarmatricula")
		public String registrar(@Valid @ModelAttribute("matricula")Matricula matricula, BindingResult result) {	
			repo.save(matricula);
			return "redirect:/index_matricula";
		}
		
		@GetMapping("/editarmatricula/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("matricula", repo.findById(id));
			model.addAttribute("listado", repo2.findAll());
			model.addAttribute("listado2", repo3.findAll());
			return "actualizar_matricula";
		}
		
		@PostMapping("/actualizarmatricula")
		public String actualizar(@Valid @ModelAttribute("matricula")Matricula matricula, BindingResult result) {
			repo.save(matricula);	
			return "redirect:/index_matricula";
		}
		
		@GetMapping("/eliminarmatricula/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_matricula";
		}
}
