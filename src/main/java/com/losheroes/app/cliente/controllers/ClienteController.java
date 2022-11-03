package com.losheroes.app.cliente.controllers;

import com.losheroes.app.cliente.entities.Cliente;
import com.losheroes.app.cliente.exceptions.ErrorResponse;
import com.losheroes.app.cliente.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;


/**
 * Cliente Controller.
 */
@RestController
@RequestMapping("/cliente")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = {@Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Cliente.class)))}),
        @ApiResponse(responseCode = "204", description = "NO CONTENT", content = {@Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = Cliente.class)))}),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST", content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))}),
        @ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))}),
        @ApiResponse(responseCode = "403", description = "FORBIDDEN",content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ErrorResponse.class))}),
        @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = {@Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Boolean.class))}),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType =
                "application/json",
                schema = @Schema(implementation = ErrorResponse.class)))}
)
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Operation(
            summary = "Obtener Clientes",
            description = "Lista todo los clientes que se encuentren en tabla cliente")
    @GetMapping("/obtenerClientes")
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        LOGGER.info(HtmlUtils.htmlEscape("Aqui en ClienteController llamando obtenerClientes"));
        List<Cliente> resp =  clienteService.obtenerClientes();
        if(resp.isEmpty() || resp.size() == 0){
            return new ResponseEntity<>(resp,HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
    }

    @Operation(
            summary = "Crear Cliente",
            description = "Crea un cliente en tabla cliente")
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        LOGGER.info(HtmlUtils.htmlEscape("Aqui en ClienteController llamando crearCliente"));
        return new ResponseEntity<>(clienteService.guardarCliente(cliente), HttpStatus.CREATED);
    }



    @Operation(
            summary = "Buscar Cliente",
            description = "Busca un cliente en tabla cliente segun su id")
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) {
        LOGGER.info(HtmlUtils.htmlEscape("Aqui en ClienteController llamando buscarCliente"));
        return new ResponseEntity<>(clienteService.obtenerClienteById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Actualizar Cliente",
            description = "Actualiza un cliente en tabla cliente segun un id")
    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente) {
        LOGGER.info(HtmlUtils.htmlEscape("Aqui en ClienteController llamando actualizarCliente"));
        return new ResponseEntity<>(clienteService.actualizarCliente(cliente), HttpStatus.OK);
    }


    @Operation(
            summary = "Eliminar Cliente",
            description = "Elimina un cliente en tabla cliente segun un id")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> eliminarCliente(@PathVariable Integer id) {
        LOGGER.info(HtmlUtils.htmlEscape("Aqui en ClienteController llamando eliminarCliente"));
        //return new ResponseEntity<>(clienteService.eliminarCliente(id),HttpStatus.OK);
        boolean resp = clienteService.eliminarCliente(id);
        if (resp == true){
            return new ResponseEntity<>(resp,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
        }
    }

}
