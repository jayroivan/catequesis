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

import com.proyecto.matricula.entidades.Grupo;
import com.proyecto.matricula.repositorio.RepoCatequista;
import com.proyecto.matricula.repositorio.RepoGrupo;
import com.proyecto.matricula.repositorio.RepoNivel;

@Controller
public class GrupoController {
	@Autowired
	RepoGrupo repo;
	@Autowired
	RepoCatequista repo2;
	@Autowired
	RepoNivel repo3;
	
		@GetMapping("/index_grupo")
		public String Inicio(Model model) {
			model.addAttribute("grupos", repo.findAll());
			return "index_grupo";
		}
		
		@GetMapping("/nuevogrupo")
		public String Nuevo(Model model) {
			model.addAttribute("listado", repo2.findAll());
			model.addAttribute("listado2", repo3.findAll());
			return "nuevo_grupo";
		}
		
		@PostMapping("/registrargrupo")
		public String registrar(@Valid @ModelAttribute("grupo")Grupo grupo, BindingResult result) {	
			repo.save(grupo);
			return "redirect:/index_grupo";
		}
		
		@GetMapping("/editargrupo/{id}")
		public String editar(@PathVariable("id") int id, Model model) {
			model.addAttribute("grupo", repo.findById(id));
			model.addAttribute("listado", repo2.findAll());
			model.addAttribute("listado2", repo3.findAll());
			return "actualizar_grupo";
		}
		
		@PostMapping("/actualizargrupo")
		public String actualizar(@Valid @ModelAttribute("grupo")Grupo grupo, BindingResult result) {
		
			repo.save(grupo);	
			return "redirect:/index_grupo";
		}
		
		@GetMapping("/eliminargrupo/{id}")
		public String eliminar(@PathVariable("id")int id) {
			repo.deleteById(id);
			return "redirect:/index_grupo";
		}
}
