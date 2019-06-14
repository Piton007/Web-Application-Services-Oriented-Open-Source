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


import edu.upc.taller.controller.service.IDetComprobanteService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.DetComprobante;


@RestController
@RequestMapping("/api/detcomprobante")
@Api(tags="Detalle de Comprobantes",value="Servicio Web Restful de Detalle de Comprobantes")
public class DetComprobanteController {

		@Autowired
	private IDetComprobanteService detcomprobanteService;
	@PostMapping
	@ApiOperation(value="Crear detalle de comprobante",notes="Servicio para generar detalle de comprobante")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de comprobante creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<DetComprobante>registrar(@Valid @RequestBody DetComprobante detcomprobante){
		DetComprobante DetComprobanteNew= new DetComprobante();
		DetComprobanteNew= detcomprobanteService.registrar(detcomprobante);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(DetComprobanteNew.getCod_det_comprobante()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Detalle de comprobante", notes = "Servicio para actualizar un detalle de comprobante")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de comprobante actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Detalle de comprobante no encontrado")})
	public ResponseEntity<DetComprobante> actualizar(@Valid @RequestBody DetComprobante detcomprobante){
		
		detcomprobanteService.modificar(detcomprobante);
		return new ResponseEntity<DetComprobante>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Detalle de Comprobante", notes = "Servicio para eliminar un detalle de comprobante")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de comprobante eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Detalle de comprobante no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<DetComprobante> detcomprobante=detcomprobanteService.listarId(id);
		
		if(detcomprobante.isPresent()) 
			detcomprobanteService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Detalles de Comprobantes", notes = "Servicio para listar a todos los detalles de comprobantes")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalles de Comprobantes encontrados"),
						  @ApiResponse(code = 404, message = "Detalles de Comprobantes no encontrados")})
	public ResponseEntity<List<DetComprobante>> listar(){
		List<DetComprobante> detcomprobantes=new ArrayList<DetComprobante>();
		detcomprobantes=detcomprobanteService.listar();
		
		return new ResponseEntity<List<DetComprobante>>(detcomprobantes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Detalles de Comprobantes por Id", notes = "Servicio para listar  Detalles de Comprobantes por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Detalle de Comprobante encontrado"),
						  @ApiResponse(code = 404, message = "Detalle de Comprobante no encontrado")})
	public ResponseEntity<DetComprobante> listarPorId(@PathVariable("Id") Integer id){
		Optional<DetComprobante> detcomprobante=detcomprobanteService.listarId(id);
		
		if(!detcomprobante.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<DetComprobante>(detcomprobante.get(),HttpStatus.OK);
	}


}
