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

import com.proyecto.matricula.entidades.Catequista;
import com.proyecto.matricula.repositorio.RepoCatequista;

@Controller
public class CatequistaController {
	@Autowired
	RepoCatequista repo;
	
		@GetMapping("/index_catequista")
		public String Inicio(Model model) {
			model.addAttribute("catequistas", repo.findAll());
			return "index_catequista";
		}
		
		@GetMapping("/nuevocatequista")
		public String Nuevo() {
			return "nuevo_catequista";
		}
		
		@PostMapping("/registrarcatequista")
		public String registrar(@Valid @ModelAttribute("catequista")Catequista catequista, BindingResult result) {	
			repo.save(catequista);
			return "redirect:/index_catequista";
		}
		
		@GetMapping("/editarcatequista/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("catequista", repo.findById(id));
			return "actualizar_catequista";
		}
		
		@PostMapping("/actualizarcatequista")
		public String actualizar(@Valid @ModelAttribute("catequista")Catequista catequista, BindingResult result) {
		
			repo.save(catequista);	
			return "redirect:/index_catequista";
		}
		
		@GetMapping("/eliminarcatequista/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_catequista";
		}
}
