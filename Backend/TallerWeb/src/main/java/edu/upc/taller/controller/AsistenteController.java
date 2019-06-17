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

import edu.upc.taller.controller.service.IAsistenteService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Asistente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/asistente")
@Api(tags = "Asistente", value = "Servicio Web RESTFul de Asistente ")
public class AsistenteController {
	@Autowired
	private IAsistenteService  asistenteService;
	
	@PostMapping
	@ApiOperation(value = "Crear Asistente", notes = "Servicio para crear un nuevo Asistente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Asistente creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Asistente> registrar(@Valid @RequestBody Asistente asistente){
		
		Asistente asistenteNew=new Asistente();
		asistenteNew=asistenteService.registrar(asistente);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(asistenteNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Asistente", notes = "Servicio para actualizar un Asistente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Asistente actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Asistente no encontrado")})
	public ResponseEntity<Asistente> actualizar(@Valid @RequestBody Asistente asistente){
		
		asistenteService.modificar(asistente);
		return new ResponseEntity<Asistente>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Asistente", notes = "Servicio para eliminar un Asistente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Asistente eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Asistente no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Asistente> asistente=asistenteService.listarId(id);
		
		if(asistente.isPresent()) 
			asistenteService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Asistentes", notes = "Servicio para listar a todos los Asistentes")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Asistentes encontrados"),
						  @ApiResponse(code = 404, message = "Asistentes no encontrados")})
	public ResponseEntity<List<Asistente>> listar(){
		List<Asistente> asistentes=new ArrayList<Asistente>();
		asistentes=asistenteService.listar();
		
		return new ResponseEntity<List<Asistente>>(asistentes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Asistentes por Id", notes = "Servicio para listar Asistentes por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Asistente encontrado"),
						  @ApiResponse(code = 404, message = "Asistente no encontrado")})
	public ResponseEntity<Asistente> listarPorId(@PathVariable("Id") Integer id){
		Optional<Asistente> asistente=asistenteService.listarId(id);
		
		if(!asistente.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Asistente>(asistente.get(),HttpStatus.OK);
	}

}
