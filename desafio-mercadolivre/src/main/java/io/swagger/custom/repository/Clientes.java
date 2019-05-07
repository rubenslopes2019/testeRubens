package io.swagger.custom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import io.swagger.model.Cliente;
import io.swagger.custom.util.UtilBanco;

@Repository
public class Clientes {

	String tabela = "tCliente";

	@Autowired
	private UtilBanco utilBanco;

	public ResponseEntity<Cliente> incluirCliente(Cliente cliente_) {
	
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		Document doc = new Document();
		doc.put("bairro", cliente_.getBairro());
		doc.put("cep", cliente_.getCep());
		doc.put("cidade", cliente_.getCidade());
		doc.put("complemento", cliente_.getComplemento());
		doc.put("cpf", cliente_.getCpf());
		doc.put("dataNascimento", cliente_.getDataNascimento().toString());
		doc.put("email", cliente_.getEmail());
		doc.put("estado", cliente_.getEstado());
		doc.put("nome", cliente_.getNome());
		doc.put("numero", cliente_.getNumero().toString());
		doc.put("rua", cliente_.getRua());
		coll.insertOne(doc);

	return new ResponseEntity<Cliente>(cliente_, HttpStatus.OK);
}

	public ResponseEntity<List<Cliente>> listarCliente() {

		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		MongoCursor<Document> cursor = coll.find().iterator();
		
		List<Cliente> cliente = new ArrayList<Cliente>();

		while (cursor.hasNext()) {

			Document result = (Document) cursor.next();
			Cliente resultado = new Cliente();
			resultado.setCodigoCliente(result.get("_id").toString());
			resultado.setBairro(result.get("bairro").toString());
			resultado.setCep((Integer.parseInt(result.get("cep").toString())));
			resultado.setCidade(result.get("cidade").toString());
			resultado.setComplemento(result.get("complemento").toString());
			resultado.setCpf(result.get("cpf").toString());
			resultado.setDataNascimento(LocalDate.parse(result.get("dataNascimento").toString()));
			resultado.setEmail(result.get("email").toString());
			resultado.setEstado(result.get("estado").toString());
			resultado.setNome(result.get("nome").toString());
			resultado.setNumero(Integer.parseInt(result.get("numero").toString()));
			resultado.setRua(result.get("rua").toString());
			cliente.add(resultado);
		}
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);

	}

	public ResponseEntity<Void> alterarCliente(String codigoCliente, Cliente cliente_) {

		Document result = (Document) (utilBanco.findCollection(codigoCliente, tabela)).iterator().next();
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);

		Document doc = new Document();		
		doc.put("bairro", cliente_.getBairro());
		doc.put("cep", cliente_.getCep().toString());
		doc.put("cidade", cliente_.getCidade());
		doc.put("complemento", cliente_.getComplemento());
		doc.put("cpf", cliente_.getCpf());
		doc.put("dataNascimento", cliente_.getDataNascimento().toString());
		doc.put("email", cliente_.getEmail());
		doc.put("estado", cliente_.getEstado());
		doc.put("nome", cliente_.getNome());
		doc.put("numero", cliente_.getNumero().toString());
		doc.put("rua", cliente_.getRua());
		coll.updateOne(result, (new Document("$set", new Document(doc))));

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Void> excluirCliente(String codigoCliente) {

		utilBanco.deleteCollection(codigoCliente, tabela);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
