package com.example.ApiRestSB.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiRestSB.modelos.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

}
