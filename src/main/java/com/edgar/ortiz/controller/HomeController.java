package com.edgar.ortiz.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edgar.ortiz.model.Perfil;
import com.edgar.ortiz.model.Usuario;
import com.edgar.ortiz.model.Vacante;
import com.edgar.ortiz.service.IntUsuariosService;
import com.edgar.ortiz.service.IntVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@Autowired
	private IntVacantesService vacantesService;
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		String modificar = "{noop}" + usuario.getPassword();
		usuario.setPassword(modificar);
		usuario.setEstatus(1); //1-Activo, 2-Inactivo
		usuario.setFechaRegistro(LocalDate.now());
		//Crear el perfil o rol
		Perfil perfil = new Perfil();
		perfil.setId(3); //Rol-Usuario
		usuario.agregar(perfil);
		System.out.println(usuario);
		usuariosService.guardar(usuario);
		return "home";
	}
	
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes = vacantesService.todasDestacadas();
		model.addAttribute("vacantes", vacantes);
		return "home";
	}
}
