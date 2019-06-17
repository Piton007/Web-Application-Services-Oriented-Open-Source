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
import edu.upc.taller.controller.service.IModeloService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Modelo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/modelo")
@Api(tags = "Modelo", value = "Servicio Web RESTFul de Modelo ")
public class ModeloController {

	@Autowired
	private IModeloService  modeloService;
	
	@PostMapping
	@ApiOperation(value = "Crear Modelo", notes = "Servicio para crear un nuevo Modelo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Modelo creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Modelo> registrar(@Valid @RequestBody Modelo modelo){
		
		Modelo modeloNew=new Modelo();
		modeloNew=modeloService.registrar(modelo);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(modeloNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Modelo", notes = "Servicio para actualizar un Modelo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Modelo actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Modelo no encontrado")})
	public ResponseEntity<Modelo> actualizar(@Valid @RequestBody Modelo modelo){
		
		modeloService.modificar(modelo);
		return new ResponseEntity<Modelo>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Modelo", notes = "Servicio para eliminar un Modelo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Modelo eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Modelo no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Modelo> modelo=modeloService.listarId(id);
		
		if(modelo.isPresent()) 
			modeloService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Modelos", notes = "Servicio para listar a todos los Modelos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Modelos encontrados"),
						  @ApiResponse(code = 404, message = "Modelos no encontrados")})
	public ResponseEntity<List<Modelo>> listar(){
		List<Modelo> modelos=new ArrayList<Modelo>();
		modelos=modeloService.listar();
		
		return new ResponseEntity<List<Modelo>>(modelos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Modelos por Id", notes = "Servicio para listar Modelos por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Modelo encontrado"),
						  @ApiResponse(code = 404, message = "Modelo no encontrado")})
	public ResponseEntity<Modelo> listarPorId(@PathVariable("Id") Integer id){
		Optional<Modelo> modelo=modeloService.listarId(id);
		
		if(!modelo.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Modelo>(modelo.get(),HttpStatus.OK);
	}

}
