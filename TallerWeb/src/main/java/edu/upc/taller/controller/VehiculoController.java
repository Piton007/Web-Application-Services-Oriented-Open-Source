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
import edu.upc.taller.controller.service.IVehiculoService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Vehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/vehiculo")
@Api(tags = "Vehiculo", value = "Servicio Web RESTFul de Vehiculo")
public class VehiculoController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@PostMapping
	@ApiOperation(value = "Crear Vehiculo", notes = "Servicio para crear un nuevo Vehiculo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Vehiculo creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Vehiculo> registrar(@Valid @RequestBody Vehiculo vehiculo){
		
		Vehiculo vehiculoNew=new Vehiculo();
		vehiculoNew=vehiculoService.registrar(vehiculo);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(vehiculoNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Vehiculo", notes = "Servicio para actualizar un Vehiculo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Vehiculo actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Vehiculo no encontrado")})
	public ResponseEntity<Vehiculo> actualizar(@Valid @RequestBody Vehiculo vehiculo){
		
		vehiculoService.modificar(vehiculo);
		return new ResponseEntity<Vehiculo>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Vehiculo", notes = "Servicio para eliminar un Vehiculo")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Vehiculo eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Vehiculo no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Vehiculo> vehiculo=vehiculoService.listarId(id);
		
		if(vehiculo.isPresent()) 
			vehiculoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Vehiculos", notes = "Servicio para listar a todos los Vehiculos")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Vehiculos encontrados"),
						  @ApiResponse(code = 404, message = "Vehiculos no encontrados")})
	public ResponseEntity<List<Vehiculo>> listar(){
		List<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
		vehiculos=vehiculoService.listar();
		
		return new ResponseEntity<List<Vehiculo>>(vehiculos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Vehiculos por Id", notes = "Servicio para listar Vehiculos por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Vehiculo encontrado"),
						  @ApiResponse(code = 404, message = "Vehiculo no encontrado")})
	public ResponseEntity<Vehiculo> listarPorId(@PathVariable("Id") Integer id){
		Optional<Vehiculo> vehiculo=vehiculoService.listarId(id);
		
		if(!vehiculo.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Vehiculo>(vehiculo.get(),HttpStatus.OK);
	}

}
