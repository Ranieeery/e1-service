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

import br.com.empresa1.report.app.TitleReceiptController;
import br.com.empresa1.report.service.command.read.ReadTitleReceiptRequest;
import br.com.empresa1.report.service.command.response.TitleReceiptResponse;
import br.com.empresa1.report.service.command.response.TitleReceiptSearchResponse;
import br.com.empresa1.report.service.command.search.SearchTitleReceiptRequest;

@RestResource
@Path("/title-receipt-list")
public class TitleReceiptResource extends AbstractRestResource {

	@Autowired
	private TitleReceiptController controller;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response read(@PathParam("id") Long id) {

		ReadTitleReceiptRequest request = new ReadTitleReceiptRequest();
		request.setId(id);

		TitleReceiptResponse response = controller.read(request);

		return toRestResponse(response, Status.OK);
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response search(@QueryParam("id") Long id, 
			@QueryParam("nome") String nome,
			@QueryParam("_pageSize") Integer pageSize, 
			@QueryParam("_pageIndex") Integer pageIndex,
			@QueryParam("_matchMode") String matchMode, 
			@QueryParam("_sortField") String sortField, 
			@QueryParam("_sortOrder") String sortOrder) {
		SearchTitleReceiptRequest searchTitleReceiptRequest = new SearchTitleReceiptRequest();
				
		if (id != null && !id.equals("")) {
			searchTitleReceiptRequest.setId(id);
		}
		if (nome != null && !nome.equals("")) {
			searchTitleReceiptRequest.setNome(nome);
		}
		if (pageSize != null && !pageSize.equals("")) {
			searchTitleReceiptRequest.setPageSize(pageSize);
		}
		if (pageIndex != null && !pageIndex.equals("")) {
			searchTitleReceiptRequest.setPageIndex(pageIndex);
		}
		if (sortField != null && !sortField.equals("")) {
			searchTitleReceiptRequest.setSortField(sortField);
		}
		searchTitleReceiptRequest.setSortOrder(EnumUtil.getEnumIgnoringCaseOrNull(SortOrder.class, sortOrder));
		searchTitleReceiptRequest.setMatchMode(EnumUtil.getEnumIgnoringCaseOrDefault(MatchMode.class, matchMode, MatchMode.START));
		
		TitleReceiptSearchResponse response = controller.search(searchTitleReceiptRequest);
		return toRestResponse(response, Status.OK);
	}

}
