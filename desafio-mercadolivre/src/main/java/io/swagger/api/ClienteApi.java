/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.5).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Cliente;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-04T23:03:30.111Z")

@Api(value = "cliente", description = "the cliente API")
public interface ClienteApi {

    @ApiOperation(value = "Altera o cliente", nickname = "alteraCliente", notes = "Altera os dados do cliente.", authorizations = {
        @Authorization(value = "BasicAuth")
    }, tags={ "Cliente", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Alteração efeturada com sucesso!"),
        @ApiResponse(code = 400, message = "Requisição inválida."),
        @ApiResponse(code = 401, message = "Requisição não autorizada."),
        @ApiResponse(code = 404, message = "Registro não encontrado."),
        @ApiResponse(code = 500, message = "Erro interno do servidor.") })
    @RequestMapping(value = "/cliente/{codigoCliente}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> alteraCliente(@ApiParam(value = "",required=true) @PathVariable("codigoCliente") String codigoCliente,@ApiParam(value = ""  )  @Valid @RequestBody Cliente cliente_);


    @ApiOperation(value = "Cadastra Cliente", nickname = "cadastraCliente", notes = "Cadastra um novo cliente", response = Cliente.class, authorizations = {
        @Authorization(value = "BasicAuth")
    }, tags={ "Cliente", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Cadastro efetuado com sucesso", response = Cliente.class),
        @ApiResponse(code = 400, message = "Requisicao invalida"),
        @ApiResponse(code = 500, message = "Erro interno do servidor") })
    @RequestMapping(value = "/cliente",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Cliente> cadastraCliente(@ApiParam(value = ""  )  @Valid @RequestBody Cliente cliente_);


    @ApiOperation(value = "Consulta Cliente", nickname = "consultaCliente", notes = "Consulta o cadastro de todos os clientes.", response = Cliente.class, responseContainer = "List", authorizations = {
        @Authorization(value = "BasicAuth")
    }, tags={ "Cliente", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Consulta cadastro de cliente efetuada com sucesso", response = Cliente.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Requisicao invalida"),
        @ApiResponse(code = 500, message = "Erro interno do servidor") })
    @RequestMapping(value = "/cliente",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Cliente>> consultaCliente();


    @ApiOperation(value = "Exclui o cliente", nickname = "excluiCliente", notes = "Exclui o cliente existente.", authorizations = {
        @Authorization(value = "BasicAuth")
    }, tags={ "Cliente", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Exclusão efetuada com sucesso"),
        @ApiResponse(code = 400, message = "Requisição inválida."),
        @ApiResponse(code = 401, message = "Requisição não autorizada."),
        @ApiResponse(code = 404, message = "Registro não encontrado."),
        @ApiResponse(code = 500, message = "Erro interno do servidor.") })
    @RequestMapping(value = "/cliente/{codigoCliente}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> excluiCliente(@ApiParam(value = "",required=true) @PathVariable("codigoCliente") String codigoCliente);

}