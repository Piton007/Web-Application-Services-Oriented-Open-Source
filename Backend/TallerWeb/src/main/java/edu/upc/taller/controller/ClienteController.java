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

import edu.upc.taller.controller.service.IClienteService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "Cliente", value = "Servicio Web RESTFul de Cliente")
public class ClienteController {


	@Autowired
	private IClienteService clienteService;
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un nuevo Cliente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cliente creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente){
		
		Cliente clienteNew=new Cliente();
		clienteNew=clienteService.registrar(cliente);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(clienteNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un Cliente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Cliente no encontrado")})
	public ResponseEntity<Cliente> actualizar(@Valid @RequestBody Cliente cliente){
		
		clienteService.modificar(cliente);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un Cliente")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Cliente no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Cliente> cliente=clienteService.listarId(id);
		
		if(cliente.isPresent()) 
			clienteService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar a todos los Clientes")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Clientes encontrados"),
						  @ApiResponse(code = 404, message = "Clientes no encontrados")})
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> clientes=new ArrayList<Cliente>();
		clientes=clienteService.listar();
		
		return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Clientes por Id", notes = "Servicio para listar Clientes por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Cliente encontrado"),
						  @ApiResponse(code = 404, message = "Cliente no encontrado")})
	public ResponseEntity<Cliente> listarPorId(@PathVariable("Id") Integer id){
		Optional<Cliente> cliente=clienteService.listarId(id);
		
		if(!cliente.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
}
