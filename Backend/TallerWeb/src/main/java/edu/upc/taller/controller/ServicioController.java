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

import edu.upc.taller.controller.service.IServService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Servicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/api/servicio")
@Api(tags="ServicioTaller",value="Servicio Web Restful de servicios del taller")
public class ServicioController {
	
	@Autowired
	private IServService servService;
	@PostMapping
	@ApiOperation(value="Crear Servicio del taller",notes="Servicio para generar un servicio del taller")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Servicio del taller creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Servicio>registrar(@Valid @RequestBody Servicio servicio){
		Servicio ServicioNew= new Servicio();
		ServicioNew= servService.registrar(servicio);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(ServicioNew.getCod_servicio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Servicio del taller", notes = "Servicio para actualizar un  servicio del taller")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Servicio del taller actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Servicio del taller no encontrado")})
	public ResponseEntity<Servicio> actualizar(@Valid @RequestBody Servicio servicio){
		
		servService.modificar(servicio);
		return new ResponseEntity<Servicio>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Servicio del taller", notes = "Servicio para eliminar un servicio del taller")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Servicio del taller eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Servicio del taller no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Servicio>servicio=servService.listarId(id);
		
		if(servicio.isPresent()) 
			servService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Servicios del taller", notes = "Servicio para listar a todos los servicios del taller")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Servicios del taller encontrados"),
						  @ApiResponse(code = 404, message = "Servicios del taller no encontrados")})
	public ResponseEntity<List<Servicio>> listar(){
		List<Servicio> servicio=new ArrayList<Servicio>();
		servicio=servService.listar();
		
		return new ResponseEntity<List<Servicio>>(servicio,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Servicio del taller por Id", notes = "Servicio para listar servicios del taller por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Servicio del taller encontrado"),
						  @ApiResponse(code = 404, message = "Servicio del taller no encontrado")})
	public ResponseEntity<Servicio> listarPorId(@PathVariable("Id") Integer id){
		Optional<Servicio> servicio=servService.listarId(id);
		
		if(!servicio.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Servicio>(servicio.get(),HttpStatus.OK);
	}

	
}
