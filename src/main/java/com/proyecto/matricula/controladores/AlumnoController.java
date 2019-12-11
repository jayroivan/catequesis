package com.proyecto.matricula.controladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.proyecto.matricula.entidades.Alumno;
import com.proyecto.matricula.entidades.Encargado;
import com.proyecto.matricula.repositorio.RepoAlumno;
import com.proyecto.matricula.repositorio.RepoEncargado;

@Controller
public class AlumnoController {
	@Autowired
	RepoAlumno repo;
	@Autowired
	RepoEncargado repo2;
	
	@GetMapping("/")
	public String Inicio() {
		return "index";
	}
		
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
		
		@RequestMapping(value="/reporte", method = RequestMethod.GET)
	    @ResponseBody
	    public FileSystemResource getUserFile(HttpServletResponse response){
			generateReport();

	        final File file = new File("reporte.pdf");
	        response.reset();
            response.addHeader("Content-Disposition", "attachment; filename=" + "reporte.pdf");

            return new FileSystemResource(file);
	    }
		
		public void generateReport () {
			ArrayList<Alumno> alumnos = (ArrayList<Alumno>) repo.findAll();
			String code = "<div style=\"text-align: center; font-family: Arial, Helvetica, sans-serif;\"><h2 style=\"width: 100%; text-align: left; margin-bottom: 10px;\">Alumnos Registrados</h2><table style=\"width: 100%; border: 2px solid #444; border-spacing: 0px\"><thead style=\"font-weight: bolder; background: #444; color: #fff;\"><tr><td style=\"padding: 8px;\">#</td><td style=\"padding: 8px;\">Nombre</td><td style=\"padding: 8px;\">Lugar</td><td style=\"padding: 8px;\">Encargado</td></tr></thead><tbody>";
			
			for (int i = 0; i < alumnos.size(); i++) {
				
				Alumno alumno = alumnos.get(i);
				String nombre, lugar, encargado, n;
				Encargado encargadoObject;
				
				nombre = alumno.getNombre() + " "+ alumno.getApellido();
				lugar = alumno.getLugar();
				encargadoObject = alumno.getEncargado();
				encargado = encargadoObject.getNombre() + " " + encargadoObject.getApellido();
				n = String.valueOf(i+1);
			  
				code += "<tr><td style=\"padding: 8px;\">"+ n +"</td><td style=\"padding: 8px;\">"+ nombre +"</td><td style=\"padding: 8px;\">"+ lugar +"</td><td style=\"padding: 8px;\">"+ encargado +"</td></tr>";
			}
			
			code += "</tbody></table></div>";
			
			
			OutputStream outputStream = null;
			
			try {
				outputStream = new FileOutputStream("reporte.pdf");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(code);	
			renderer.layout();
			
			try {
				renderer.createPDF(outputStream);
			} catch (com.lowagie.text.DocumentException e) {
				e.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();

			}

		}
}
