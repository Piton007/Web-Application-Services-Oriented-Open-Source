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

import edu.upc.taller.controller.service.IRepuestoService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Repuesto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/repuesto")
@Api(tags = "Repuesto", value = "Servicio Web RESTFul de Repuesto")
public class RepuestoController {
	
	@Autowired
	private IRepuestoService repuestoService;
	
	@PostMapping
	@ApiOperation(value = "Crear Repuesto", notes = "Servicio para crear un nuevo repuesto")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Repuesto> registrar(@Valid @RequestBody Repuesto repuesto){
		
		Repuesto repuestoNew=new Repuesto();
		repuestoNew=repuestoService.registrar(repuesto);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_repuesto}").buildAndExpand(repuestoNew.getCod_repuesto()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Repuesto", notes = "Servicio para actualizar un Repuesto")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Repuesto no encontrado")})
	public ResponseEntity<Repuesto> actualizar(@Valid @RequestBody Repuesto repuesto){
		
		repuestoService.modificar(repuesto);
		return new ResponseEntity<Repuesto>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_repuesto}")
	@ApiOperation(value = "Eliminar Repuesto", notes = "Servicio para eliminar un repuesto")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Repuesto no encontrado")})
	public void eliminar(@PathVariable("cod_repuesto") Integer id) {
		Optional<Repuesto> repuesto=repuestoService.listarId(id);
		
		if(repuesto.isPresent()) 
			repuestoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Repuestos", notes = "Servicio para listar a todos los repuestos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuestos encontrados"),
						  @ApiResponse(code = 404, message = "Repuestos no encontrados")})
	public ResponseEntity<List<Repuesto>> listar(){
		List<Repuesto> repuestos=new ArrayList<Repuesto>();
		repuestos=repuestoService.listar();
		
		return new ResponseEntity<List<Repuesto>>(repuestos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_repuesto}")
	@ApiOperation(value = "Listar Repuestos por Id", notes = "Servicio para listar repuestos por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto encontrado"),
						  @ApiResponse(code = 404, message = "Repuesto no encontrado")})
	public ResponseEntity<Repuesto> listarPorId(@PathVariable("cod_repuesto") Integer id){
		Optional<Repuesto> repuesto=repuestoService.listarId(id);
		
		if(!repuesto.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Repuesto>(repuesto.get(),HttpStatus.OK);
	}
}
