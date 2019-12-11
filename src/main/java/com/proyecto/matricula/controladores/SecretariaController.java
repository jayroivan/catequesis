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

import com.proyecto.matricula.entidades.Secretaria;
import com.proyecto.matricula.repositorio.RepoSecretaria;

@Controller
public class SecretariaController {
	@Autowired
	RepoSecretaria repo;
	
		@GetMapping("/index_secretaria")
		public String Inicio(Model model) {
			model.addAttribute("secretarias", repo.findAll());
			return "index_secretaria";
		}
		
		@GetMapping("/nuevasecretaria")
		public String Nuevo() {
			return "nuevo_secretaria";
		}
		
		@PostMapping("/registrarsecretaria")
		public String registrar(@Valid @ModelAttribute("secretaria")Secretaria secretaria, BindingResult result) {	
			repo.save(secretaria);
			return "redirect:/index_secretaria";
		}
		
		@GetMapping("/editarsecretaria/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("secretaria", repo.findById(id));
			return "actualizar_secretaria";
		}
		
		@PostMapping("/actualizarsecretaria")
		public String actualizar(@Valid @ModelAttribute("secretaria")Secretaria secretaria, BindingResult result) {
		
			repo.save(secretaria);	
			return "redirect:/index_secretaria";
		}
		
		@GetMapping("/eliminarsecretaria/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_secretaria";
		}
}
