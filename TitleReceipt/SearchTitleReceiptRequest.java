package br.com.empresa1.report.service.command.search;

import com.avenuecode.core.service.command.request.AbstractSearchRequest;
import com.avenuecode.core.service.command.request.RequestProcessing;

import br.com.empresa1.report.service.command.response.TitleReceiptSearchResponse;

@RequestProcessing(command = SearchTitleReceiptNativeCommand.class, response = TitleReceiptSearchResponse.class)
public class SearchTitleReceiptRequest extends AbstractSearchRequest {

    private static final long serialVersionUID = 8665216810083510L;
    
    private Long id;
    private String nome;

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
}