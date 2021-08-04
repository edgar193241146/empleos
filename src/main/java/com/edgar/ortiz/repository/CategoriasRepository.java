package com.edgar.ortiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.edgar.ortiz.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
	
}
