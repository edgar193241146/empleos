package com.edgar.ortiz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edgar.ortiz.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	//Recupera todas las vacantes destacadas y con un estatus
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
	
	//Método que realiza una consulta con sql nativo
	@Query(value="SELECT * FROM vacantes WHERE destacado= 1\r\n"
			+ "AND estatus = 'Aprobada' ORDER BY id", nativeQuery = true)
	List<Vacante> obtenerTodasDestacadas();
}
