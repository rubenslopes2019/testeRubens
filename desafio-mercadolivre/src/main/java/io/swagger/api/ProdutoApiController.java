package io.swagger.api;

import io.swagger.model.Produto;
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
import io.swagger.custom.service.ProdutoService;
import io.swagger.custom.repository.Produtos;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-03T01:38:51.680Z")

@Controller
public class ProdutoApiController implements ProdutoApi {

   
    @Autowired
	private ProdutoService produtoService;
    
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProdutoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }    

    public ResponseEntity<Void> alteraProduto(@ApiParam(value = "",required=true) @PathVariable("codigoProduto") String codigoProduto,@ApiParam(value = "" ,required=true) @Valid @RequestBody Produto produto_) {

        try {
        	return produtoService.alteraProduto(codigoProduto, produto_);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }  
    }

    public ResponseEntity<Produto> cadastraProduto(@ApiParam(value = ""  )  @Valid @RequestBody Produto produto_) {

            try {
            	return produtoService.cadastraProduto(produto_);
            } catch (Exception e) {
                return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    public ResponseEntity<List<Produto>> consultaProduto() {
            try {
            	return produtoService.consultaProduto();
            } catch (Exception e) {
                return new ResponseEntity<List<Produto>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

    public ResponseEntity<Void> excluiProduto(@ApiParam(value = "",required=true) @PathVariable("codigoProduto") String codigoProduto) {
        try {
        	return produtoService.excluiProduto(codigoProduto);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        }  
    }

}
