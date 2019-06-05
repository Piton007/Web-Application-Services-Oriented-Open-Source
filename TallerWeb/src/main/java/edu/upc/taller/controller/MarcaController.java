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
import edu.upc.taller.controller.service.IMarcaService;
import edu.upc.taller.exception.ModelNotFoundException;

import edu.upc.taller.model.Marca;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/marca")
@Api(tags = "Marca", value = "Servicio Web RESTFul de Marca ")
public class MarcaController {
	@Autowired
	private IMarcaService  marcaService;
	
	@PostMapping
	@ApiOperation(value = "Crear Marca", notes = "Servicio para crear un nueva Marca")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Marca creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Marca> registrar(@Valid @RequestBody Marca marca){
		
		Marca marcaNew=new Marca();
		marcaNew=marcaService.registrar(marca);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(marcaNew.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Marca", notes = "Servicio para actualizar una Marca")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Marca actualizada correctamente"),
						  @ApiResponse(code = 404, message = "Marcano encontrada")})
	public ResponseEntity<Marca> actualizar(@Valid @RequestBody Marca marca){
		
		marcaService.modificar(marca);
		return new ResponseEntity<Marca>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Marca", notes = "Servicio para eliminar una Marca")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Marca eliminada correctamente"),
						  @ApiResponse(code = 404, message = "Marca no encontrada")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Marca> marca=marcaService.listarId(id);
		
		if(marca.isPresent()) 
			marcaService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Marcas", notes = "Servicio para listar a todos las Marcas")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Marcas encontradas"),
						  @ApiResponse(code = 404, message = "Marcas no encontradas")})
	public ResponseEntity<List<Marca>> listar(){
		List<Marca> marcas=new ArrayList<Marca>();
		marcas=marcaService.listar();
		
		return new ResponseEntity<List<Marca>>(marcas,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Marcas por Id", notes = "Servicio para listar Marcas por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Marca encontrada"),
						  @ApiResponse(code = 404, message = "Marca no encontrada")})
	public ResponseEntity<Marca> listarPorId(@PathVariable("Id") Integer id){
		Optional<Marca> marca=marcaService.listarId(id);
		
		if(!marca.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Marca>(marca.get(),HttpStatus.OK);
	}


}
