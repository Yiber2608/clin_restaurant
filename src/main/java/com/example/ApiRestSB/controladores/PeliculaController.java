package com.example.ApiRestSB.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRestSB.modelos.Pelicula;
import com.example.ApiRestSB.repositorios.PeliculaRepository;

@RestController
public class PeliculaController {
	
	PeliculaRepository repositorio;
	
	//ayudamos a spring a rellenar 
	public PeliculaController(PeliculaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	//crea objetos a la base de datos
	@GetMapping("/api/crearPeliculas")
	public void crearPeliculas() {
		Pelicula pelicula1 = new Pelicula("Titanic", "James Cameron", "Drama");
		Pelicula pelicula2 = new Pelicula("Titanic2", "James Cameron2", "Drama2");
		Pelicula pelicula3 = new Pelicula("Titanic3", "James Cameron3", "Drama3");
		
		repositorio.save(pelicula1);
		repositorio.save(pelicula2);
		repositorio.save(pelicula3);
	}
	
	//Consulta los datos de la DB
	@CrossOrigin("http://127.0.0.1:5501")
	@GetMapping("/api/Peliculas")
	public List<Pelicula> obtenerPeliculas(){
		//hace consulta select de todo
		return repositorio.findAll();
	}
	
	@CrossOrigin("http://127.0.0.1:5501")
	@GetMapping("/api/Peliculas/{id}")
	public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id) {//para pasar el id 
		Optional<Pelicula> opt = repositorio.findById(id);
		
		if (opt.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}else {
			return ResponseEntity.ok(opt.get());
		}
	}
	
	@CrossOrigin("http://127.0.0.1:5501")
	@PostMapping("/api/Peliculas")
	public ResponseEntity<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula) {
		
		if (pelicula.getId() != null ) {
			return ResponseEntity.badRequest().build();
		}
		
		repositorio.save(pelicula);
		return ResponseEntity.ok(pelicula);
	}
	
	@CrossOrigin("http://127.0.0.1:5501")
	@PutMapping("/api/Peliculas")
	public ResponseEntity<Pelicula> actualizarPelicula(@RequestBody Pelicula pelicula) {
	    
	    if (pelicula.getId() == null || !repositorio.existsById(pelicula.getId())) {  // Cambiar null por pelicula.getId()
	        return ResponseEntity.badRequest().build();
	    }
	    
	    Pelicula peliculaActualizada = repositorio.save(pelicula);  // Guardar la película actualizada
	    return ResponseEntity.ok(peliculaActualizada);
	}

	
	@CrossOrigin("http://127.0.0.1:5501")
	@DeleteMapping("/api/Peliculas/{id}")
	public ResponseEntity<Pelicula> borrarPelicula(@PathVariable Long id) {
		
		if (id == null || !repositorio.existsById(id) ) {
			return ResponseEntity.badRequest().build();
		}
		
		repositorio.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	
	

}
