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

import edu.upc.taller.controller.service.IRepuesto_proveedor_almacenService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Repuesto_proveedor_almacen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/repuesto_proveedor_almacen")
@Api(tags = "Repuesto_proveedor_almacen", value = "Servicio Web RESTFul de Repuesto_proveedor_almacen")
public class Repuesto_proveedor_almacenController {
	
	@Autowired
	private IRepuesto_proveedor_almacenService rpaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Repuesto_proveedor_almacen", notes = "Servicio para crear un nuevo repuesto_proveedor_almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto_proveedor_almacen creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Repuesto_proveedor_almacen> registrar(@Valid @RequestBody Repuesto_proveedor_almacen rpa){
		
		Repuesto_proveedor_almacen rpaNew=new Repuesto_proveedor_almacen();
		rpaNew=rpaService.registrar(rpa);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_repuesto_prov_alm}").buildAndExpand(rpaNew.getCod_repuesto_prov_alm()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Repuesto_proveedor_almacen", notes = "Servicio para actualizar un repuesto_proveedor_almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto_proveedor_almacen actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Repuesto_proveedor_almacen no encontrado")})
	public ResponseEntity<Repuesto_proveedor_almacen> actualizar(@Valid @RequestBody Repuesto_proveedor_almacen rpa){
		
		rpaService.modificar(rpa);
		return new ResponseEntity<Repuesto_proveedor_almacen>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_repuesto_prov_alm}")
	@ApiOperation(value = "Eliminar Repuesto_proveedor_almacen", notes = "Servicio para eliminar un Repuesto_proveedor_almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto_proveedor_almacen eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Repuesto_proveedor_almacen no encontrado")})
	public void eliminar(@PathVariable("cod_repuesto_prov_alm") Integer id) {
		Optional<Repuesto_proveedor_almacen> rpa=rpaService.listarId(id);
		
		if(rpa.isPresent()) 
			rpaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Repuesto_proveedor_almacen", notes = "Servicio para listar a todos los repuesto_proveedor_almacen")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto_proveedor_almacen encontrados"),
						  @ApiResponse(code = 404, message = "Repuesto_proveedor_almacen no encontrados")})
	public ResponseEntity<List<Repuesto_proveedor_almacen>> listar(){
		List<Repuesto_proveedor_almacen> rpas=new ArrayList<Repuesto_proveedor_almacen>();
		rpas=rpaService.listar();
		
		return new ResponseEntity<List<Repuesto_proveedor_almacen>>(rpas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_repuesto_prov_alm}")
	@ApiOperation(value = "Listar Repuesto_proveedor_almacen por Id", notes = "Servicio para listar repuesto_proveedor_almacen por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Repuesto_proveedor_almacen encontrado"),
						  @ApiResponse(code = 404, message = "Repuesto_proveedor_almacen no encontrado")})
	public ResponseEntity<Repuesto_proveedor_almacen> listarPorId(@PathVariable("cod_repuesto_prov_alm") Integer id){
		Optional<Repuesto_proveedor_almacen> rpa=rpaService.listarId(id);
		
		if(!rpa.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Repuesto_proveedor_almacen>(rpa.get(),HttpStatus.OK);
	}

}
