package io.swagger.custom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.swagger.custom.util.UtilBanco;
import io.swagger.model.Produto;
import io.swagger.custom.entity.ProdutoEntity;
import io.swagger.custom.repository.Produtos;
import io.swagger.custom.util.UtilBanco;

@Service
public class ProdutoService {

	@Autowired
	private Produtos repository;
	
	public ResponseEntity<Produto> cadastraProduto(Produto produto_) {

        try {
        	return repository.incluirProduto(produto_);
        } catch (Exception e) {
            return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }   
	}
	
	
	public ResponseEntity<List<Produto>> consultaProduto() {
        try {
        	return (repository.listarProduto());
        	
        } catch (Exception e) {
            return new ResponseEntity<List<Produto>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
	
	
	public ResponseEntity<Void> excluiProduto(String codigoProduto) {	
        try {
        	return (repository.excluirProduto(codigoProduto));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}


	public ResponseEntity<Void> alteraProduto(String codigoProduto, Produto produto_) {
        try {
        	return (repository.alterarProduto(codigoProduto, produto_));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
}
	

