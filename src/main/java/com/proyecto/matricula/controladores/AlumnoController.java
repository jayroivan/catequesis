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

import com.proyecto.matricula.entidades.Alumno;
import com.proyecto.matricula.repositorio.RepoAlumno;
import com.proyecto.matricula.repositorio.RepoEncargado;

@Controller
public class AlumnoController {
	@Autowired
	RepoAlumno repo;
	@Autowired
	RepoEncargado repo2;
	
		@GetMapping("/index_alumno")
		public String Inicio(Model model) {
			model.addAttribute("alumnos", repo.findAll());
			return "index_alumno";
		}
		
		@GetMapping("/nuevoalumno")
		public String Nuevo(Model model) {
			model.addAttribute("listado", repo2.findAll());
			return "nuevo_alumno";
		}
		
		@PostMapping("/registraralumno")
		public String registrar(@Valid @ModelAttribute("alumno")Alumno alumno, BindingResult result) {	
			repo.save(alumno);
			return "redirect:/index_alumno";
		}
		
		@GetMapping("/editaralumno/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("alumno", repo.findById(id));
			model.addAttribute("id", repo2.findById(id));
			model.addAttribute("listado", repo2.findAll());
			return "actualizar_alumno";
		}
		
		@PostMapping("/actualizaralumno")
		public String actualizar(@Valid @ModelAttribute("alumno")Alumno alumno, BindingResult result) {
		
			repo.save(alumno);	
			return "redirect:/index_alumno";
		}
		
		@GetMapping("/eliminaralumno/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_alumno";
		}
}
