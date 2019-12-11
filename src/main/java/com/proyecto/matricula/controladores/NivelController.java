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

import com.proyecto.matricula.entidades.Nivel;
import com.proyecto.matricula.repositorio.RepoNivel;

@Controller
public class NivelController {
	@Autowired
	RepoNivel repo;
	
		@GetMapping("/index_nivel")
		public String Inicio(Model model) {
			model.addAttribute("niveles", repo.findAll());
			return "index_nivel";
		}
		
		@GetMapping("/nuevonivel")
		public String Nuevo() {
			return "nuevo_nivel";
		}
		
		@PostMapping("/registrarnivel")
		public String registrar(@Valid @ModelAttribute("nivel")Nivel nivel, BindingResult result) {	
			repo.save(nivel);
			return "redirect:/index_nivel";
		}
		
		@GetMapping("/editarnivel/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("nivel", repo.findById(id));
			return "actualizar_nivel";
		}
		
		@PostMapping("/actualizarnivel")
		public String actualizar(@Valid @ModelAttribute("nivel")Nivel nivel, BindingResult result) {
			repo.save(nivel);	
			return "redirect:/index_nivel";
		}
		
		@GetMapping("/eliminarnivel/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_nivel";
		}
}
