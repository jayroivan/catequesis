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

import com.proyecto.matricula.entidades.Encargado;
import com.proyecto.matricula.repositorio.RepoEncargado;

@Controller
public class EncargadoController {
	@Autowired
	RepoEncargado repo;
	
		@GetMapping("/index_encargado")
		public String Inicio(Model model) {
			model.addAttribute("encargados", repo.findAll());
			return "index_encargado";
		}
		
		@GetMapping("/nuevoencargado")
		public String Nuevo() {
			return "nuevo_encargado";
		}
		
		@PostMapping("/registrarencargado")
		public String registrar(@Valid @ModelAttribute("encargado")Encargado encargado, BindingResult result) {	
			repo.save(encargado);
			return "redirect:/index_encargado";
		}
		
		@GetMapping("/editarencargado/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("encargado", repo.findById(id));
			return "actualizar_encargado";
		}
		
		@PostMapping("/actualizarencargado")
		public String actualizar(@Valid @ModelAttribute("encargado")Encargado encargado, BindingResult result) {
			repo.save(encargado);	
			return "redirect:/index_encargado";
		}
		
		@GetMapping("/eliminarencargado/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_encargado";
		}
}
