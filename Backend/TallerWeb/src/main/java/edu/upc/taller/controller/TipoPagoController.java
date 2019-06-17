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

import edu.upc.taller.controller.service.ITipoPagoService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.TipoPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/tipopago")
@Api(tags="TiposPagos",value="Servicio Web Restful de Tipos de Pago")
public class TipoPagoController {
	@Autowired
	private ITipoPagoService tipopagoService;
	@PostMapping
	@ApiOperation(value="Crear Tipo de Pago",notes="Servicio para generar un Tipo de Pago")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tipo de Pago creado correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<TipoPago>registrar(@Valid @RequestBody TipoPago tipopago){
		TipoPago TipoPagoNew= new TipoPago();
		TipoPagoNew= tipopagoService.registrar(tipopago);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(TipoPagoNew.getCod_tipo_pago()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar tipo de pago", notes = "Servicio para actualizar un tipo de pago")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tipo de Pago actualizado correctamente"),
						  @ApiResponse(code = 404, message = "Tipo de Pago no encontrado")})
	public ResponseEntity<TipoPago> actualizar(@Valid @RequestBody TipoPago tipopago){
		
		tipopagoService.modificar(tipopago);
		return new ResponseEntity<TipoPago>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Tipo de Pago", notes = "Servicio para eliminar un Tipo de Pago")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tipo de Pago eliminado correctamente"),
						  @ApiResponse(code = 404, message = "Tipo de Pago no encontrado")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<TipoPago>tipopago=tipopagoService.listarId(id);
		
		if(tipopago.isPresent()) 
			tipopagoService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Tipos de Pago", notes = "Servicio para listar a todos los Tipos de Pago")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tipos de Pago encontrados"),
						  @ApiResponse(code = 404, message = "Tipos de Pago no encontrados")})
	public ResponseEntity<List<TipoPago>> listar(){
		List<TipoPago> tipopagos=new ArrayList<TipoPago>();
		tipopagos=tipopagoService.listar();
		
		return new ResponseEntity<List<TipoPago>>(tipopagos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Tipos de Pago por Id", notes = "Servicio para listar  Tipos de Pago por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Tipo de Pago encontrado"),
						  @ApiResponse(code = 404, message = "Tipo de Pago no encontrado")})
	public ResponseEntity<TipoPago> listarPorId(@PathVariable("Id") Integer id){
		Optional<TipoPago> tipopago=tipopagoService.listarId(id);
		
		if(!tipopago.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<TipoPago>(tipopago.get(),HttpStatus.OK);
	}


}
