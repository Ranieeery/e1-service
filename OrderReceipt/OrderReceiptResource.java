package br.com.empresa1.report.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.avenuecode.core.service.command.request.SortOrder;
import com.avenuecode.core.util.EnumUtil;
import com.avenuecode.core.web.rest.AbstractRestResource;
import com.avenuecode.core.web.rest.RestResource;

import br.com.empresa1.report.app.OrderReceiptController;
import br.com.empresa1.report.service.command.read.ReadOrderReceiptRequest;
import br.com.empresa1.report.service.command.response.OrderReceiptResponse;
import br.com.empresa1.report.service.command.response.OrderReceiptSearchResponse;
import br.com.empresa1.report.service.command.search.SearchOrderReceiptRequest;

@RestResource
@Path("/receipt-list")
public class OrderReceiptResource extends AbstractRestResource {
    @Autowired
    private OrderReceiptController controller;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response read(@PathParam("id") Long id) {

        ReadOrderReceiptRequest request = new ReadOrderReceiptRequest();
        request.setId(id);

        OrderReceiptResponse response = controller.read(request);

        return toRestResponse(response, Status.OK);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response search(
        @QueryParam("order.id") Integer tipoRecibo,
        @QueryParam("order.organization.id") Integer orgId,
        @QueryParam("order.numPedido") Integer numPedido,
        @QueryParam("order.startDate") String dataInicio,
        @QueryParam("order.endDate") String dataFim,

        @QueryParam("_pageSize") Integer pageSize,
        @QueryParam("_pageIndex") Integer pageIndex,
        @QueryParam("_matchMode") String matchMode,
        @QueryParam("_sortField") String sortField,
        @QueryParam("_sortOrder") String sortOrder

    ) {
        SearchOrderReceiptRequest request = new SearchOrderReceiptRequest();

        if (tipoRecibo != null && !tipoRecibo.equals("")) {
            request.setTipoRecibo(tipoRecibo);
        }

        if (orgId != null && !orgId.equals("")) {
            request.setOrgId(orgId);
        }

        if (numPedido != null && !numPedido.equals("")) {
            request.setNumPedido(numPedido);
        }
        if (dataInicio != null && !dataInicio.equals("")) {
            request.setDataInicio(dataInicio);
        }

        if (dataFim != null && !dataFim.equals("")) {
            request.setDataFim(dataFim);
        }

        request.setSortOrder(EnumUtil.getEnumIgnoringCaseOrNull(SortOrder.class, sortOrder));
        request.setMatchMode(EnumUtil.getEnumIgnoringCaseOrDefault(MatchMode.class, matchMode, MatchMode.START));

        OrderReceiptSearchResponse response = controller.search(request);

        return toRestResponse(response, Status.OK);
    }

}