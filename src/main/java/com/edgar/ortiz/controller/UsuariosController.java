package com.edgar.ortiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.ortiz.model.Usuario;
import com.edgar.ortiz.service.IntUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Usuario>lista = usuariosService.buscarTodas(page);
		model.addAttribute("usuarios", lista);
		model.addAttribute("total", usuariosService.numeroEntidaddes());
		return "usuarios/listaUsuarios";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuariosService.obtenerTodas();
		model.addAttribute("usuarios", lista);
		model.addAttribute("total", usuariosService.numeroEntidaddes());
		return "usuarios/listaUsuarios";
	}
}
