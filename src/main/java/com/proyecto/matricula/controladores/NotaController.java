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

import com.proyecto.matricula.entidades.Nota;
import com.proyecto.matricula.repositorio.RepoNota;
import com.proyecto.matricula.repositorio.RepoMatricula;

@Controller
public class NotaController {
	@Autowired
	RepoNota repo;
	@Autowired
	RepoMatricula repo2;
	
		@GetMapping("/index_nota")
		public String Inicio(Model model) {
			model.addAttribute("notas", repo.findAll());
			return "index_nota";
		}
		
		@GetMapping("/nuevonota")
		public String Nuevo(Model model) {
			model.addAttribute("listado", repo2.findAll());
			return "nuevo_nota";
		}
		
		@PostMapping("/registrarnota")
		public String registrar(@Valid @ModelAttribute("alumno")Nota nota, BindingResult result) {	
			repo.save(nota);
			return "redirect:/index_nota";
		}
		
		@GetMapping("/editarnota/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("nota", repo.findById(id));
			model.addAttribute("listado", repo2.findAll());
			return "actualizar_nota";
		}
		
		@PostMapping("/actualizarnota")
		public String actualizar(@Valid @ModelAttribute("nota")Nota nota, BindingResult result) {
		
			repo.save(nota);	
			return "redirect:/index_nota";
		}
		
		@GetMapping("/eliminarnota/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_nota";
		}
}
