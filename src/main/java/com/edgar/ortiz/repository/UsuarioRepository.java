package com.edgar.ortiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edgar.ortiz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	//metodo personalizado con sql nativo
    @Query(value = "select count(*) from usuarios", nativeQuery = true)
    Integer totalEntidades();
}
