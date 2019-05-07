package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Produto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-04T23:03:30.111Z")

public class Produto   {
  @JsonProperty("codigoProduto")
  private String codigoProduto = null;

  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("preco")
  private Double preco = null;

  public Produto codigoProduto(String codigoProduto) {
    this.codigoProduto = codigoProduto;
    return this;
  }

  /**
   * Get codigoProduto
   * @return codigoProduto
  **/
  @ApiModelProperty(example = "1", value = "")


  public String getCodigoProduto() {
    return codigoProduto;
  }

  public void setCodigoProduto(String codigoProduto) {
    this.codigoProduto = codigoProduto;
  }

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  **/
  @ApiModelProperty(example = "Plano A", value = "")


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto preco(Double preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  **/
  @ApiModelProperty(example = "199.99", value = "")


  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return Objects.equals(this.codigoProduto, produto.codigoProduto) &&
        Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.preco, produto.preco);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoProduto, nome, preco);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    
    sb.append("    codigoProduto: ").append(toIndentedString(codigoProduto)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
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

