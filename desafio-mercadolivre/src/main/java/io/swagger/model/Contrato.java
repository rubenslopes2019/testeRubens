package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Cliente;
import io.swagger.model.Produto;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Contrato
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-04T23:03:30.111Z")

public class Contrato   {
  @JsonProperty("codigoContrato")
  private String codigoContrato = null;

  @JsonProperty("cliente")
  private Cliente cliente = null;

  @JsonProperty("produto")
  private Produto produto = null;

  @JsonProperty("dataInclusao")
  private OffsetDateTime dataInclusao = null;

  @JsonProperty("dataAlteracao")
  private OffsetDateTime dataAlteracao = null;

  public Contrato codigoContrato(String codigoContrato) {
    this.codigoContrato = codigoContrato;
    return this;
  }

  /**
   * Get codigoContrato
   * @return codigoContrato
  **/
  @ApiModelProperty(example = "999999", value = "")


  public String getCodigoContrato() {
    return codigoContrato;
  }

  public void setCodigoContrato(String codigoContrato) {
    this.codigoContrato = codigoContrato;
  }

  public Contrato cliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Contrato produto(Produto produto) {
    this.produto = produto;
    return this;
  }

  /**
   * Get produto
   * @return produto
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Contrato dataInclusao(OffsetDateTime dataInclusao) {
    this.dataInclusao = dataInclusao;
    return this;
  }

  /**
   * Get dataInclusao
   * @return dataInclusao
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDataInclusao() {
    return dataInclusao;
  }

  public void setDataInclusao(OffsetDateTime dataInclusao) {
    this.dataInclusao = dataInclusao;
  }

  public Contrato dataAlteracao(OffsetDateTime dataAlteracao) {
    this.dataAlteracao = dataAlteracao;
    return this;
  }

  /**
   * Get dataAlteracao
   * @return dataAlteracao
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDataAlteracao() {
    return dataAlteracao;
  }

  public void setDataAlteracao(OffsetDateTime dataAlteracao) {
    this.dataAlteracao = dataAlteracao;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contrato contrato = (Contrato) o;
    return Objects.equals(this.codigoContrato, contrato.codigoContrato) &&
        Objects.equals(this.cliente, contrato.cliente) &&
        Objects.equals(this.produto, contrato.produto) &&
        Objects.equals(this.dataInclusao, contrato.dataInclusao) &&
        Objects.equals(this.dataAlteracao, contrato.dataAlteracao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigoContrato, cliente, produto, dataInclusao, dataAlteracao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contrato {\n");
    
    sb.append("    codigoContrato: ").append(toIndentedString(codigoContrato)).append("\n");
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    produto: ").append(toIndentedString(produto)).append("\n");
    sb.append("    dataInclusao: ").append(toIndentedString(dataInclusao)).append("\n");
    sb.append("    dataAlteracao: ").append(toIndentedString(dataAlteracao)).append("\n");
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

