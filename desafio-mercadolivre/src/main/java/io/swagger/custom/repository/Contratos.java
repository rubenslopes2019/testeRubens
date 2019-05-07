package io.swagger.custom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import io.swagger.model.Cliente;
import io.swagger.model.Contrato;
import io.swagger.model.Produto;
import io.swagger.custom.util.UtilBanco;

@Repository
public class Contratos {
	
	String tabela = "tContrato";	
	
	@Autowired
	private UtilBanco utilBanco;
	
	public ResponseEntity<Contrato> incluirContrato(String codigoCliente, String codigoProduto) {
	
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		Document doc = new Document();
		doc.put("dataAlteracao", OffsetDateTime.now().toString());
		doc.put("dataInclusao", OffsetDateTime.now().toString());
		doc.put("cliente", codigoCliente);
		doc.put("produto", codigoProduto);
		coll.insertOne(doc);

	return new ResponseEntity<Contrato>(HttpStatus.OK);
}

	public ResponseEntity<List<Contrato>> listarContrato() {
		
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		MongoCursor<Document> cursor = coll.find().iterator();		
		List<Contrato> contrato = new ArrayList<Contrato>();

		while (cursor.hasNext()) {
			
			Document result = (Document) cursor.next();
			
			Contrato resultado = new Contrato();
			resultado.setCodigoContrato(result.get("_id").toString());
			resultado.setDataAlteracao(OffsetDateTime.parse(result.get("dataAlteracao").toString()));
			resultado.setDataInclusao(OffsetDateTime.parse(result.get("dataInclusao").toString()));
			Document resultCliente = (Document) (utilBanco.findCollection((result.get("cliente").toString()),"tCliente")).iterator().next();

			Cliente resultadoCliente = new Cliente();
			resultadoCliente.setCodigoCliente(resultCliente.get("_id").toString());
			resultadoCliente.setBairro(resultCliente.get("bairro").toString());
			resultadoCliente.setCep(Integer.parseInt(resultCliente.get("cep").toString()));
			resultadoCliente.setCidade(resultCliente.get("cidade").toString());
			resultadoCliente.setComplemento(resultCliente.get("complemento").toString());
			resultadoCliente.setCpf(resultCliente.get("cpf").toString());
			resultadoCliente.setDataNascimento(LocalDate.parse(resultCliente.get("dataNascimento").toString()));
			resultadoCliente.setEmail(resultCliente.get("email").toString());
			resultadoCliente.setEstado(resultCliente.get("estado").toString());
			resultadoCliente.setNome(resultCliente.get("nome").toString());
			resultadoCliente.setNumero(Integer.parseInt(resultCliente.get("numero").toString()));
			resultadoCliente.setRua(resultCliente.get("rua").toString());
			resultado.setCliente(resultadoCliente);
			
			Document resultProduto = (Document) (utilBanco.findCollection((result.get("produto").toString()),"tProduto")).iterator().next();
			
			Produto resultadoProduto = new Produto();
			resultadoProduto.setCodigoProduto(resultProduto.get("_id").toString());
			resultadoProduto.setNome(resultProduto.get("nome").toString());
			resultadoProduto.setPreco(Double.parseDouble(resultProduto.get("preco").toString()));
			resultado.setProduto(resultadoProduto);

			contrato.add(resultado);
		}
		return new ResponseEntity<List<Contrato>>(contrato,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Void> alterarContrato(String codigoContrato, String codigoProduto) {

		Document result = (Document) (utilBanco.findCollection(codigoContrato,tabela)).iterator().next();
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		
		Document doc = new Document();
		doc.put("dataAlteracao", OffsetDateTime.now().toString());
		doc.put("produto", codigoProduto.toString());
		coll.updateOne(result, (new Document("$set", new Document(doc))));
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> excluirContrato(String codigoContrato) {
		
		
		utilBanco.deleteCollection(codigoContrato,tabela);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
