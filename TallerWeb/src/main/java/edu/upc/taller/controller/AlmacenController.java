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

import edu.upc.taller.controller.service.IAlmacenService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Almacen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/almacen")
@Api(tags = "Almacen", value = "Servicio Web RESTFul de Almacen")
public class AlmacenController {
	
	@Autowired
	private IAlmacenService almacenService;
	
	@PostMapping
	@ApiOperation(value = "Crear Almacen", notes = "Servicio para crear un nuevo almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Almacen> registrar(@Valid @RequestBody Almacen almacen){
		
		Almacen almacenNew=new Almacen();
		almacenNew=almacenService.registrar(almacen);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_almacen}").buildAndExpand(almacenNew.getCod_almacen()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Almacen", notes = "Servicio para actualizar un almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Almacen no encontrado")})
	public ResponseEntity<Almacen> actualizar(@Valid @RequestBody Almacen almacen){
		
		almacenService.modificar(almacen);
		return new ResponseEntity<Almacen>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_almacen}")
	@ApiOperation(value = "Eliminar Almacen", notes = "Servicio para eliminar un almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Almacen no encontrado")})
	public void eliminar(@PathVariable("cod_almacen") Integer id) {
		Optional<Almacen> almacen=almacenService.listarId(id);
		
		if(almacen.isPresent()) 
			almacenService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Almacenes", notes = "Servicio para listar a todos los almacenes")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacenes encontrados"),
						  @ApiResponse(code = 404, message = "Almacenes no encontrados")})
	public ResponseEntity<List<Almacen>> listar(){
		List<Almacen> almacenes=new ArrayList<Almacen>();
		almacenes=almacenService.listar();
		
		return new ResponseEntity<List<Almacen>>(almacenes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_almacen}")
	@ApiOperation(value = "Listar Almacenes por Id", notes = "Servicio para listar almacenes por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Almacen encontrado"),
						  @ApiResponse(code = 404, message = "Almacen no encontrado")})
	public ResponseEntity<Almacen> listarPorId(@PathVariable("cod_almacen") Integer id){
		Optional<Almacen> almacen=almacenService.listarId(id);
		
		if(!almacen.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Almacen>(almacen.get(),HttpStatus.OK);
	}
}
