package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Cliente
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-04T23:03:30.111Z")

public class Cliente   {
	
  @JsonProperty("codigoCliente")
  private String codigoCliente = null;	
	
  @JsonProperty("cpf")
  private String cpf = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("dataNascimento")
  private LocalDate dataNascimento = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("cep")
  private Integer cep = null;

  @JsonProperty("rua")
  private String rua = null;

  @JsonProperty("numero")
  private Integer numero = null;

  @JsonProperty("complemento")
  private String complemento = null;

  @JsonProperty("bairro")
  private String bairro = null;

  @JsonProperty("cidade")
  private String cidade = null;

  @JsonProperty("estado")
  private String estado = null;
  
  
  
  
  public Cliente codigoCliente(String codigoCliente) {
	    this.codigoCliente = codigoCliente;
	    return this;
	  }

	  /**
	   * Get codigoCliente
	   * @return codigoCliente
	  **/
	  @ApiModelProperty(example = "1", value = "")
 
	  public String getCodigoCliente() {
	    return codigoCliente;
	  }

	  public void setCodigoCliente(String codigoCliente) {
	    this.codigoCliente = codigoCliente;
	  }

  public Cliente cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
  **/
  @ApiModelProperty(example = "12345678911", value = "")

@Size(min=11,max=11) 
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Cliente nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  **/
  @ApiModelProperty(example = "Rubens Lopes", value = "")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cliente dataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
    return this;
  }

  /**
   * Get dataNascimento
   * @return dataNascimento
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate localDate) {
    this.dataNascimento = localDate;
  }

  public Cliente email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "rubens_lopes@hotmail.com", value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Cliente cep(Integer cep) {
    this.cep = cep;
    return this;
  }

  /**
   * Get cep
   * @return cep
  **/
  @ApiModelProperty(example = "1704560", value = "")


  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public Cliente rua(String rua) {
    this.rua = rua;
    return this;
  }

  /**
   * Get rua
   * @return rua
  **/
  @ApiModelProperty(example = "Av. Henriqueta Mendes Guerra", value = "")


  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public Cliente numero(Integer numero) {
    this.numero = numero;
    return this;
  }

  /**
   * Get numero
   * @return numero
  **/
  @ApiModelProperty(example = "1330", value = "")


  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public Cliente complemento(String complemento) {
    this.complemento = complemento;
    return this;
  }

  /**
   * Get complemento
   * @return complemento
  **/
  @ApiModelProperty(example = "Apto 74", value = "")


  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public Cliente bairro(String bairro) {
    this.bairro = bairro;
    return this;
  }

  /**
   * Get bairro
   * @return bairro
  **/
  @ApiModelProperty(example = "Centro", value = "")


  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public Cliente cidade(String cidade) {
    this.cidade = cidade;
    return this;
  }

  /**
   * Get cidade
   * @return cidade
  **/
  @ApiModelProperty(example = "Barueri", value = "")


  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Cliente estado(String estado) {
    this.estado = estado;
    return this;
  }

  /**
   * Get estado
   * @return estado
  **/
  @ApiModelProperty(example = "São Paulo", value = "")


  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return Objects.equals(this.codigoCliente, cliente.codigoCliente) &&
    	Objects.equals(this.cpf, cliente.cpf) &&
        Objects.equals(this.nome, cliente.nome) &&
        Objects.equals(this.dataNascimento, cliente.dataNascimento) &&
        Objects.equals(this.email, cliente.email) &&
        Objects.equals(this.cep, cliente.cep) &&
        Objects.equals(this.rua, cliente.rua) &&
        Objects.equals(this.numero, cliente.numero) &&
        Objects.equals(this.complemento, cliente.complemento) &&
        Objects.equals(this.bairro, cliente.bairro) &&
        Objects.equals(this.cidade, cliente.cidade) &&
        Objects.equals(this.estado, cliente.estado);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoCliente, cpf, nome, dataNascimento, email, cep, rua, numero, complemento, bairro, cidade, estado);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cliente {\n");
    
    sb.append("    CodigoCliente: ").append(toIndentedString(codigoCliente)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    cep: ").append(toIndentedString(cep)).append("\n");
    sb.append("    rua: ").append(toIndentedString(rua)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    complemento: ").append(toIndentedString(complemento)).append("\n");
    sb.append("    bairro: ").append(toIndentedString(bairro)).append("\n");
    sb.append("    cidade: ").append(toIndentedString(cidade)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

