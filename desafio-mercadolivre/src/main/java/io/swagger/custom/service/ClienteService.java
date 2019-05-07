package io.swagger.custom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.swagger.custom.util.UtilBanco;
import io.swagger.model.Cliente;
import io.swagger.custom.entity.ClienteEntity;
import io.swagger.custom.repository.Clientes;
import io.swagger.custom.util.UtilBanco;

@Service
public class ClienteService {

	@Autowired
	private Clientes repository;
	
	public ResponseEntity<Cliente> cadastraCliente(Cliente cliente_) {

        try {
        	return repository.incluirCliente(cliente_);
        } catch (Exception e) {
            return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
        }   
	}
	
	
	public ResponseEntity<List<Cliente>> consultaCliente() {
        try {
        	return (repository.listarCliente());
        	
        } catch (Exception e) {
            return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
	
	
	public ResponseEntity<Void> excluiCliente(String codigoCliente) {	
        try {
        	return (repository.excluirCliente(codigoCliente));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}


	public ResponseEntity<Void> alteraCliente(String codigoCliente, Cliente cliente_) {
        try {
        	return (repository.alterarCliente(codigoCliente, cliente_));
        	
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
	}
}
	

