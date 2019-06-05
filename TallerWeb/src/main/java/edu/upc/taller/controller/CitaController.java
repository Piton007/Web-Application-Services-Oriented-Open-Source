package edu.upc.taller.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import edu.upc.taller.controller.service.ICitaService;
import edu.upc.taller.exception.ModelNotFoundException;

import edu.upc.taller.model.Cita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cita")
@Api(tags = "cita", value = "Servicio Web RESTFul de Cita ")
public class CitaController {
	@Autowired
	private ICitaService  citaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Cita", notes = "Servicio para crear un nueva Cita")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cita creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Cita> registrar(@Valid @RequestBody Cita cita){
		
		Cita citaNew=new Cita();
		citaNew=citaService.registrar(cita);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(citaNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Cita", notes = "Servicio para actualizar una Cita")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cita actualizada correctamente"),
						  @ApiResponse(code = 404, message = "Cita no encontrada")})
	public ResponseEntity<Cita> actualizar(@Valid @RequestBody Cita cita){
		
		citaService.modificar(cita);
		return new ResponseEntity<Cita>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Cita", notes = "Servicio para eliminar una Cita")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cita eliminada correctamente"),
						  @ApiResponse(code = 404, message = "Cita no encontrada")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Cita> cita=citaService.listarId(id);
		
		if(cita.isPresent()) 
			citaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Citas", notes = "Servicio para listar a todos las Citas")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Citas encontradas"),
						  @ApiResponse(code = 404, message = "Citas no encontradas")})
	public ResponseEntity<List<Cita>> listar(){
		List<Cita> citas=new ArrayList<Cita>();
		citas=citaService.listar();
		
		return new ResponseEntity<List<Cita>>(citas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Citas por Id", notes = "Servicio para listar Citas por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cita encontrada"),
						  @ApiResponse(code = 404, message = "Cita no encontrada")})
	public ResponseEntity<Cita> listarPorId(@PathVariable("Id") Integer id){
		Optional<Cita> cita=citaService.listarId(id);
		
		if(!cita.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Cita>(cita.get(),HttpStatus.OK);
	}


}
