package io.swagger.custom.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.custom.entity.*;




@Entity
public class ContratoEntity implements Serializable {

	private static final long serialVersionUID = 1610111962433241138L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String codigoContrato;
	private ClienteEntity cliente;
	private ProdutoEntity produto;
	private String dataAlteracao;
	private String dataInclusao;
	
	public String getCodigoContrato() {
		return codigoContrato;
	}
	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}

	public String getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public ProdutoEntity getProduto() {
		return produto;
	}
	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	
}
