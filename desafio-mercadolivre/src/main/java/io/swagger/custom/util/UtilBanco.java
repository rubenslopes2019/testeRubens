package io.swagger.custom.util;

import org.springframework.data.repository.CrudRepository;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import io.swagger.model.Produto;

@Component
public class UtilBanco {
	
	public static MongoCollection<Document> conectarBanco(String table) {
	
		MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
		MongoDatabase db = mongoClient.getDatabase("db");
		MongoCollection<Document> collection = db.getCollection(table);
		
		return collection;
	}
	
	public static FindIterable<Document> findCollection(String id, String tabela) {
		
		MongoCollection<Document> coll = conectarBanco(tabela);
		FindIterable<Document> document = coll.find(new Document().append("_id", new ObjectId(id)));
		
		return document;
		
	}
	
	public static ResponseEntity<Void> deleteCollection(String id, String tabela) {
		
		Document result = (Document) (findCollection(id, tabela)).iterator().next();	
		MongoCollection<Document> coll = conectarBanco(tabela);
		coll.deleteOne(result);
		return new ResponseEntity<Void>(HttpStatus.OK);
		        	
	}

}
