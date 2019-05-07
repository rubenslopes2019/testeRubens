package io.swagger.api;

import io.swagger.model.Contrato;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import io.swagger.custom.service.ContratoService;
import io.swagger.custom.repository.Contratos;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-03T01:38:51.680Z")

@Controller
public class ContratoApiController implements ContratoApi {

   
    @Autowired
	private ContratoService contratoService;
    
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContratoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }    

    public ResponseEntity<Void> alteraContrato(@ApiParam(value = "",required=true) @PathVariable("codigoContrato") String codigoContrato, @PathVariable("codigoProduto") String codigoProduto) {

        try {
        	return contratoService.alteraContrato(codigoContrato, codigoProduto);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }  
    }

    public ResponseEntity<Contrato> cadastraContrato(@ApiParam(value = "",required=true) @PathVariable("codigoCliente") String codigoCliente, @PathVariable("codigoProduto") String codigoProduto) {
            try {
            	return contratoService.cadastraContrato(codigoCliente, codigoProduto);
            } catch (Exception e) {
                return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    public ResponseEntity<List<Contrato>> consultaContrato() {
            try {
            	return contratoService.consultaContrato();
            } catch (Exception e) {
                return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    public ResponseEntity<Void> excluiContrato(@ApiParam(value = "",required=true) @PathVariable("codigoContrato") String codigoContrato) {
        try {
        	return contratoService.excluiContrato(codigoContrato);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }  
    }

}
