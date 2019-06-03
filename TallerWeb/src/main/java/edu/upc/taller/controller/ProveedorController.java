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

import edu.upc.taller.controller.service.IProveedorService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Proveedor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/proveedor")
@Api(tags = "Proveedor", value = "Servicio Web RESTFul de Proveedor")
public class ProveedorController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@PostMapping
	@ApiOperation(value = "Crear Proveedor", notes = "Servicio para crear un nuevo proveedor")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Proveedor creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Proveedor> registrar(@Valid @RequestBody Proveedor proveedor){
		
		Proveedor proveedorNew=new Proveedor();
		proveedorNew=proveedorService.registrar(proveedor);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_proveedor}").buildAndExpand(proveedorNew.getCod_proveedor()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Proveedor", notes = "Servicio para actualizar un proveedor")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Proveedor actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Proveedor no encontrado")})
	public ResponseEntity<Proveedor> actualizar(@Valid @RequestBody Proveedor proveedor){
		
		proveedorService.modificar(proveedor);
		return new ResponseEntity<Proveedor>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{cod_proveedor}")
	@ApiOperation(value = "Eliminar Proveedor", notes = "Servicio para eliminar un proveedor")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Proveedor eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Proveedor no encontrado")})
	public void eliminar(@PathVariable("cod_proveedor") Integer id) {
		Optional<Proveedor> proveedor=proveedorService.listarId(id);
		
		if(proveedor.isPresent()) 
			proveedorService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Proveedores", notes = "Servicio para listar a todos los proveedores")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Proveedores encontrados"),
						  @ApiResponse(code = 404, message = "Proveedores no encontrados")})
	public ResponseEntity<List<Proveedor>> listar(){
		List<Proveedor> proveedores=new ArrayList<Proveedor>();
		proveedores=proveedorService.listar();
		
		return new ResponseEntity<List<Proveedor>>(proveedores,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cod_proveedor}")
	@ApiOperation(value = "Listar Proveedores por Id", notes = "Servicio para listar proveedores por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Proveedor encontrado"),
						  @ApiResponse(code = 404, message = "Proveedor no encontrado")})
	public ResponseEntity<Proveedor> listarPorId(@PathVariable("cod_proveedor") Integer id){
		Optional<Proveedor> proveedor=proveedorService.listarId(id);
		
		if(!proveedor.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Proveedor>(proveedor.get(),HttpStatus.OK);
	}
}
