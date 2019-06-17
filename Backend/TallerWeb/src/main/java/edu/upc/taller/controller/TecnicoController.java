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

import edu.upc.taller.controller.service.ITecnicoService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Tecnico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/tecnico")
@Api(tags = "Tecnico", value = "Servicio Web RESTFul de Tecnico")
public class TecnicoController {
	
	@Autowired
	private ITecnicoService tecnicoService;
	
	@PostMapping
	@ApiOperation(value = "Crear Tecnico", notes = "Servicio para crear un nuevo tecnico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tecnico creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Tecnico> registrar(@Valid @RequestBody Tecnico tecnico){
		
		Tecnico tecnicoNew=new Tecnico();
		tecnicoNew=tecnicoService.registrar(tecnico);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_tecnico}").buildAndExpand(tecnicoNew.getCod_tecnico()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Tecnico", notes = "Servicio para actualizar un tecnico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tecnico actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Tecnico no encontrado")})
	public ResponseEntity<Tecnico> actualizar(@Valid @RequestBody Tecnico tecnico){
		
		tecnicoService.modificar(tecnico);
		return new ResponseEntity<Tecnico>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_tecnico}")
	@ApiOperation(value = "Eliminar Tecnico", notes = "Servicio para eliminar un Tecnico")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tecnico eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Tecnico no encontrado")})
	public void eliminar(@PathVariable("cod_tecnico") Integer id) {
		Optional<Tecnico> tecnico=tecnicoService.listarId(id);
		
		if(tecnico.isPresent()) 
			tecnicoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Tecnicos", notes = "Servicio para listar a todos los tecnicos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tecnicos encontrados"),
						  @ApiResponse(code = 404, message = "Tecnicos no encontrados")})
	public ResponseEntity<List<Tecnico>> listar(){
		List<Tecnico> tecnicos=new ArrayList<Tecnico>();
		tecnicos=tecnicoService.listar();
		
		return new ResponseEntity<List<Tecnico>>(tecnicos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_tecnico}")
	@ApiOperation(value = "Listar Tecnicos por Id", notes = "Servicio para listar tecnicos por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tecnico encontrado"),
						  @ApiResponse(code = 404, message = "Tecnico no encontrado")})
	public ResponseEntity<Tecnico> listarPorId(@PathVariable("cod_tecnico") Integer id){
		Optional<Tecnico> tecnico=tecnicoService.listarId(id);
		
		if(!tecnico.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Tecnico>(tecnico.get(),HttpStatus.OK);
	}
}
