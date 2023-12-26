package br.com.empresa1.report.app;

import java.util.List;

import com.avenuecode.core.app.AbstractController;
import com.avenuecode.core.app.AppController;

import br.com.empresa1.report.dto.backoffice.TituloReciboDTO;
import br.com.empresa1.report.service.command.read.ReadTitleReceiptRequest;
import br.com.empresa1.report.service.command.response.TitleReceiptResponse;
import br.com.empresa1.report.service.command.response.TitleReceiptSearchResponse;
import br.com.empresa1.report.service.command.search.SearchTitleReceiptRequest;
@AppController
public class TitleReceiptController extends AbstractController  {

    public TitleReceiptResponse read(ReadTitleReceiptRequest request) {
        return handle(request);
    }

    public TitleReceiptSearchResponse search(SearchTitleReceiptRequest request) {
        return handle(request);
    }
    
    public List<TituloReciboDTO> findById(Long id){
        SearchTitleReceiptRequest request = new SearchTitleReceiptRequest();
        request.setId(id); 
        return ((TitleReceiptSearchResponse)handle(request)).getValues();
    }
    public List<TituloReciboDTO> findByName(String nome){
        SearchTitleReceiptRequest request = new SearchTitleReceiptRequest();
        request.setNome(nome); 
        return ((TitleReceiptSearchResponse)handle(request)).getValues();
    }
}
