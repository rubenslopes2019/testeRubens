package io.swagger.custom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.swagger.custom.util.UtilBanco;
import io.swagger.model.Contrato;
import io.swagger.custom.entity.ContratoEntity;
import io.swagger.custom.repository.Contratos;
import io.swagger.custom.util.UtilBanco;

@Service
public class ContratoService {

	@Autowired
	private Contratos repository;
	
	public ResponseEntity<Contrato> cadastraContrato(String codigoCliente, String codigoProduto) {

        try {
        	return repository.incluirContrato(codigoCliente, codigoProduto);
        } catch (Exception e) {
            return new ResponseEntity<Contrato>(HttpStatus.INTERNAL_SERVER_ERROR);
        }   
	}
	
	
	public ResponseEntity<List<Contrato>> consultaContrato() {
        try {
        	return (repository.listarContrato());
        	
        } catch (Exception e) {
            return new ResponseEntity<List<Contrato>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
	
	
	public ResponseEntity<Void> excluiContrato(String codigoContrato) {	
        try {
        	return (repository.excluirContrato(codigoContrato));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}


	public ResponseEntity<Void> alteraContrato(String codigoContrato, String codigoProduto) {
        try {
        	return (repository.alterarContrato(codigoContrato, codigoProduto));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
}
	


