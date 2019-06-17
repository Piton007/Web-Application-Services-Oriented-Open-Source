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

import edu.upc.taller.controller.service.IRevisionService;
import edu.upc.taller.exception.ModelNotFoundException;
import edu.upc.taller.model.Revision;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
@RestController
@RequestMapping("/api/revision")
@Api(tags="Revisiones",value="Servicio Web Restful de Revisiones")
public class RevisionController {
	@Autowired
	private IRevisionService revisionService;
	@PostMapping
	@ApiOperation(value="Crear Revision",notes="Servicio para generar una Revision")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Revision creada correctamente"),
						  @ApiResponse(code = 400, message = "Solicitud Inválida")})
	public ResponseEntity<Revision>registrar(@Valid @RequestBody Revision revision){
		Revision RevisionNew= new Revision();
		RevisionNew= revisionService.registrar(revision);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
				.buildAndExpand(RevisionNew.getCod_revision()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ApiOperation(value = "Actualizar Revision", notes = "Servicio para actualizar una revision")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Revision actualizada correctamente"),
						  @ApiResponse(code = 404, message = "Revision no encontrada")})
	public ResponseEntity<Revision> actualizar(@Valid @RequestBody Revision revision){
		
		revisionService.modificar(revision);
		return new ResponseEntity<Revision>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{Id}")
	@ApiOperation(value = "Eliminar Revision", notes = "Servicio para eliminar una revision")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Revision eliminada correctamente"),
						  @ApiResponse(code = 404, message = "Revision no encontrada")})
	public void eliminar(@PathVariable("Id") Integer id) {
		Optional<Revision>revision=revisionService.listarId(id);
		
		if(revision.isPresent()) 
			revisionService.eliminar(id);
		else 
			throw new ModelNotFoundException("ID"+id);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Listar Revisiones", notes = "Servicio para listar a todos las revisiones")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Revisiones encontradas"),
						  @ApiResponse(code = 404, message = "Revisiones no encontradas")})
	public ResponseEntity<List<Revision>> listar(){
		List<Revision> revisiones=new ArrayList<Revision>();
		revisiones=revisionService.listar();
		
		return new ResponseEntity<List<Revision>>(revisiones,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{Id}")
	@ApiOperation(value = "Listar Revisiones por Id", notes = "Servicio para listar revisiones por id")
	@ApiResponses(value= {@ApiResponse(code = 201, message = "Revision encontrada"),
						  @ApiResponse(code = 404, message = "Revision no encontrada")})
	public ResponseEntity<Revision> listarPorId(@PathVariable("Id") Integer id){
		Optional<Revision> revision=revisionService.listarId(id);
		
		if(!revision.isPresent())
			throw new ModelNotFoundException("ID"+id);
		
		return new ResponseEntity<Revision>(revision.get(),HttpStatus.OK);
	}


}
