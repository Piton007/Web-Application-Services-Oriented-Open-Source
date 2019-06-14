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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import edu.upc.taller.controller.service.IDetServService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.DetServicio;


@RestController
@RequestMapping("/api/detservicio")
@Api(tags="DetalleServicio",value="Servicio Web Restful de Detalles de revisiones")
public class DetServController {
	
	@Autowired
	private IDetServService detservService;
	@PostMapping
	@ApiOperation(value="Crear Detalle de servicio",notes="Servicio para generar un detalle de servicio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de servicio creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<DetServicio>registrar(@Valid @RequestBody DetServicio detservicio){
		DetServicio DetServicioNew= new DetServicio();
		DetServicioNew= detservService.registrar(detservicio);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(DetServicioNew.getCod_det_serv()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Detalle de servicio", notes = "Servicio para actualizar un detalle de servicio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de servicio actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Detalle de servicio no encontrado")})
	public ResponseEntity<DetServicio> actualizar(@Valid @RequestBody DetServicio detservicio){
		
		detservService.modificar(detservicio);
		return new ResponseEntity<DetServicio>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Detalle de servicio", notes = "Servicio para eliminar un detalle de servicio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de servicio eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Detalle de servicio no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<DetServicio>detservicio=detservService.listarId(id);
		
		if(detservicio.isPresent()) 
			detservService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Detalle de Servicio", notes = "Servicio para listar a todos los detalles de servicio")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalles de servicio encontrados"),
						  @ApiResponse(code = 404, message = "Detalles de servicio no encontrados")})
	public ResponseEntity<List<DetServicio>> listar(){
		List<DetServicio> detservicio=new ArrayList<DetServicio>();
		detservicio=detservService.listar();
		
		return new ResponseEntity<List<DetServicio>>(detservicio,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Detalle de Servicio por Id", notes = "Servicio para listar detalles de servicios por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de Servicio encontrado"),
						  @ApiResponse(code = 404, message = "Detalle de Servicio no encontrado")})
	public ResponseEntity<DetServicio> listarPorId(@PathVariable("Id") Integer id){
		Optional<DetServicio> detservicio=detservService.listarId(id);
		
		if(!detservicio.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<DetServicio>(detservicio.get(),HttpStatus.OK);
	}

}
