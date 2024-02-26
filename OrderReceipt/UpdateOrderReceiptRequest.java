package br.com.empresa1.report.service.command.update;

import com.avenuecode.core.service.command.request.IdentifiedRequest;
import com.avenuecode.core.service.command.request.RequestProcessing;
import com.avenuecode.core.service.command.response.GenericCreateUpdateNativeResponse;

import br.com.empresa1.report.service.command.search.SearchOrderReceiptRequest;



@RequestProcessing(command = UpdateOrderReceiptNativeCommand.class, response = GenericCreateUpdateNativeResponse.class)
public class UpdateOrderReceiptRequest extends SearchOrderReceiptRequest implements IdentifiedRequest<Long> {
    private static final long serialVersionUID = -3846764707371823451L;
}
