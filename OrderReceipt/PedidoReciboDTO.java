package br.com.empresa1.report.dto.backoffice;

import com.avenuecode.core.service.dao.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoReciboDTO implements Entity<Long> {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private Long numPedido;

    @JsonProperty
    private String valorPedido;

    @JsonProperty
    private String dataProcessamento;

    @JsonProperty
    private String dataUltimaReimpressao;

    @JsonProperty
    private Long qtdReimpressao;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Long numPedido) {
        this.numPedido = numPedido;
    }

    public String getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(String valorPedido) {
        this.valorPedido = valorPedido;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public String getDataUltimaReimpressao() {
        return dataUltimaReimpressao;
    }

    public void setDataUltimaReimpressao(String dataUltimaReimpressao) {
        this.dataUltimaReimpressao = dataUltimaReimpressao;
    }

    public Long getQtdReimpressao() {
        return qtdReimpressao;
    }

    public void setQtdReimpressao(Long qtdReimpressao) {
        this.qtdReimpressao = qtdReimpressao;
    }

}