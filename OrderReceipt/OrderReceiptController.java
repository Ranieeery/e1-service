package br.com.empresa1.report.app;

import java.util.List;

import com.avenuecode.core.app.AbstractController;
import com.avenuecode.core.app.AppController;

import br.com.empresa1.report.dto.backoffice.PedidoReciboDTO;
import br.com.empresa1.report.service.command.read.ReadOrderReceiptRequest;
import br.com.empresa1.report.service.command.response.OrderReceiptSearchResponse;
import br.com.empresa1.report.service.command.response.OrderReceiptResponse;
import br.com.empresa1.report.service.command.search.SearchOrderReceiptRequest;

@AppController
public class OrderReceiptController extends AbstractController {

    public OrderReceiptResponse read(ReadOrderReceiptRequest request) {
        return handle(request);
    }

    public OrderReceiptSearchResponse search(SearchOrderReceiptRequest request) {
        return handle(request);
    }

    public List<PedidoReciboDTO> findById(Long id){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setId(id);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }

    public List<PedidoReciboDTO> findByNome(String nome){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setNome(nome);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }

    public List<PedidoReciboDTO> findByValorPedido(String valorPedido){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setValorPedido(valorPedido);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }

    public List<PedidoReciboDTO> findByDataProcessamento(String dataProcessamento){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setDataProcessamento(dataProcessamento);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }

    public List<PedidoReciboDTO> findByDataUltimaReimpressao(String dataUltimaReimpressao){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setDataUltimaReimpressao(dataUltimaReimpressao);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }

    public List<PedidoReciboDTO> findByQtdReimpressao(Long qtdReimpressao){
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();
        request.setQtdReimpressao(qtdReimpressao);
        return ((OrderReceiptSearchResponse)handle(request)).getValues();
    }
}