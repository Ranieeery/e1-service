package br.com.empresa1.report.service.command.search;

import com.avenuecode.core.service.command.request.AbstractSearchRequest;
import com.avenuecode.core.service.command.request.RequestProcessing;

import br.com.empresa1.report.service.command.response.OrderReceiptSearchResponse;

@RequestProcessing(command = SearchOrderReceiptCommand.class, response = OrderReceiptSearchResponse.class)
public class SearchOrderReceiptRequest extends AbstractSearchRequest {
    private static final long serialVersionUID = 6512453486597701184L;

    private Long id;
    private String nome;
    private String valorPedido;
    private String dataProcessamento;
    private String dataUltimaReimpressao;
    private Long qtdReimpressao;

    private Integer tipoRecibo;
    private Integer orgId;
    private Integer numPedido;
    private String dataInicio;
    private String dataFim;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getTipoRecibo() {
        return tipoRecibo;
    }

    public void setTipoRecibo(Integer tipoRecibo) {
        this.tipoRecibo = tipoRecibo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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