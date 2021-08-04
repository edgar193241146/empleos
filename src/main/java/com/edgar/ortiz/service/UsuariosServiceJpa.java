package com.edgar.ortiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edgar.ortiz.model.Usuario;
import com.edgar.ortiz.repository.UsuarioRepository;

@Service
public class UsuariosServiceJpa implements IntUsuariosService {
	
	@Autowired
	private UsuarioRepository repoUsuarios;
	
	@Override
	public List<Usuario> obtenerTodas() {
		return repoUsuarios.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		repoUsuarios.save(usuario);
	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuarios.deleteById(idUsuario);

	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {
		return repoUsuarios.findAll(page);
	}

	@Override
	public Integer numeroEntidaddes() {
		//return repoUsuarios.findAll().size();
		return repoUsuarios.totalEntidades();
	}

}
