package io.swagger.custom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import io.swagger.model.Produto;
import io.swagger.custom.util.UtilBanco;

@Repository
public class Produtos {
	
	String tabela = "tProduto";	
	
	@Autowired
	private UtilBanco utilBanco;
	
	public ResponseEntity<Produto> incluirProduto(Produto produto_) {
	
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		Document doc = new Document();
		//
		doc.put("nome", produto_.getNome());
		doc.put("preco", produto_.getPreco());
		//	
		coll.insertOne(doc);

	return new ResponseEntity<Produto>(produto_, HttpStatus.OK);
}

	public ResponseEntity<List<Produto>> listarProduto() {
		
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		MongoCursor<Document> cursor = coll.find().iterator();		
		List<Produto> produto = new ArrayList<Produto>();

		while (cursor.hasNext()) {
			
			Document result = (Document) cursor.next();
			Produto resultado = new Produto();
			//
			resultado.setCodigoProduto(result.get("_id").toString());
			resultado.setNome(result.get("nome").toString());
			resultado.setPreco(Double.parseDouble(result.get("preco").toString()));
			//
			produto.add(resultado);
		}
		return new ResponseEntity<List<Produto>>(produto,HttpStatus.OK);
		
	}
	
	public ResponseEntity<Void> alterarProduto(String codigoProduto, Produto produto_) {

		Document result = (Document) (utilBanco.findCollection(codigoProduto,tabela)).iterator().next();
		MongoCollection<Document> coll = utilBanco.conectarBanco(tabela);
		
		Document doc = new Document();
		//
		doc.put("nome", produto_.getNome());
		doc.put("preco", produto_.getPreco());
		//
		coll.updateOne(result, (new Document("$set", new Document(doc))));
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> excluirProduto(String codigoProduto) {
		
		
		utilBanco.deleteCollection(codigoProduto,tabela);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
